package com.oblenergo.service;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.DTO.WorkTypeDTO;

import java.util.List;

public interface SapService {

  String getUserEmailFromSap(String tabNamber);

  String getFullNameFromSap(String tabNamber);

  List<WorkTypeDTO> getAllWorkTypes();

  OrderDTO createNewOrder(String carNum, String itemNum, String itemCount, String tab_number);

  byte[] getBillPDF(String billNum);
  
  String getBillNumber(String orderNum);

}
