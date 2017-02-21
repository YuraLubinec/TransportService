package com.oblenergo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.DTO.WorkTypeDTO;
import com.oblenergo.wsClient.SapClient;

@Service
public class SapServiceImpl implements SapService {

  private static final Logger LOGGER = Logger.getLogger(SapServiceImpl.class);

  @Autowired
  SapClient sapClient;

  @Override
  public String getUserEmailFromSap(String tabNamber) {

    return sapClient.getUserEmail(tabNamber);
  }

  @Override
  public String getFullNameFromSap(String tabNamber) {
 
    return sapClient.getFullName(tabNamber);
  }

  @Override
  public List<WorkTypeDTO> getAllWorkTypes() {

    return sapClient.getAllWorktypes();
  }

  @Override
  public OrderDTO createNewOrder(String carNum, String itemNum, String itemCount, String user_tab) {

    return sapClient.getOrder(carNum, itemNum, itemCount, user_tab);
  }

  @Override
  public byte[] getBillPDF(String billNumber) {

    return sapClient.getPDFBill(billNumber);
  }

  @Override
  public String getBillNumber(String orderNum) {

    return sapClient.getBillNumber(orderNum);
  }

}
