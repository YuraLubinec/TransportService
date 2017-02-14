package com.oblenergo.controller;

import com.oblenergo.enums.StatusOrderEnum;
import com.oblenergo.model.Notification;
import com.oblenergo.model.OrderMessage;
import com.oblenergo.model.Orders;
import com.oblenergo.service.OrderService;
import com.oblenergo.service.SapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/cashier")
public class CashierController {

	private static final String ORDER_LIST = "orders";

	@Autowired
	private OrderService orderServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCashierPage(Model model) {
		
	  model.addAttribute(ORDER_LIST, orderServiceImpl.findAllConfirm());
		return "cashier";
	}

	@RequestMapping(value = "/cashierPaid", method = RequestMethod.GET)
	public String getAllPaidOrders(Model model){
		
	  model.addAttribute(ORDER_LIST, orderServiceImpl.findAllPaid());
		return "cashierPaid";
	}

	@RequestMapping(value = "/approvePayment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void approvePayment(@RequestBody int id) {
		
	  Orders order = orderServiceImpl.findOrderById(id);
		order.setStatus_order(StatusOrderEnum.valueOf("PAID"));
		orderServiceImpl.update(order);
	}
	

	@MessageMapping("/paymentAproveNotification")
	@SendTo("/adminNotification")
	public Notification greeting(OrderMessage orderMessage) {

		return new Notification(orderMessage.getMessage());
	}
}