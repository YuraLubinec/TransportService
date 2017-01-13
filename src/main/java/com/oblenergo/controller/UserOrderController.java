package com.oblenergo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.DTO.WorkTypeDTO;
import com.oblenergo.editor.CarEditor;
import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import com.oblenergo.model.Notification;
import com.oblenergo.model.OrderMessage;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.OrderService;
import com.oblenergo.service.SapService;
import com.oblenergo.service.WorkTypeService;
import com.oblenergo.validator.OrderValidator;

@Controller
@RequestMapping(value = "/")
public class UserOrderController {
  Logger LOGGER = Logger.getLogger(UserOrderController.class);

  private static final String WORKTYPE_FROM_SAP = "workTypeFromSap";
  private static final String ITEMSCAR = "cars";
  private static final String ORDER = "orders";

  @Autowired
  private OrderService orderServiceImpl;

  @Autowired
  private CarService carServiceImpl;

  @Autowired
  private SapService sapServiceImpl;

  @Autowired
  private WorkTypeService wokrTypeServiceImpl;

  @Autowired
  private OrderValidator orderValidator;

  @Autowired
  private ServiceEditor serviceEditor;

  @Autowired
  private CarEditor carEditor;

  @InitBinder("orders")
  public void initBinder(WebDataBinder binder) {

    binder.registerCustomEditor(WorkType.class, serviceEditor);
    binder.registerCustomEditor(Car.class, carEditor);
    binder.addValidators(orderValidator);
  }

  @RequestMapping(method = RequestMethod.GET)
  public String getAllType(Model model) {
    model.addAttribute(WORKTYPE_FROM_SAP, wokrTypeServiceImpl.findAvailableWorkType(sapServiceImpl.getAllWorkTypes()));
    model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
    model.addAttribute(ORDER, new Orders());
    return "createOrder";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String addType(@Validated @ModelAttribute("orders") Orders orders, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      model.addAttribute(WORKTYPE_FROM_SAP,
          wokrTypeServiceImpl.findAvailableWorkType(sapServiceImpl.getAllWorkTypes()));
      model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
      return "createOrder";
    }
    
    orders.setCustomer(sapServiceImpl.getFullNameFromSap(orders.getUser_tab()));
    WorkTypeDTO wtDTO = wokrTypeServiceImpl.getWorkTypeDTOByIdFromSAP(orders.getWorkType().getId());
    String all_sum = wtDTO.getPrice();
    double all_sumWithPDV = Double.parseDouble(all_sum);
    all_sumWithPDV = all_sumWithPDV * 1.2 * orders.getCount();
    all_sum = Double.toString(all_sumWithPDV);
    orders.setAll_sum(all_sum);
    orderServiceImpl.save(orders);

    return "redirect:/?id=" + orders.getId();
  }
  
  @MessageMapping("/newOrderNotification")
  @SendTo("/adminNotification")
  public Notification greeting(OrderMessage orderMessage) {

    return new Notification(orderMessage.getMessage());
  }
}
