package com.oblenergo.wsClient;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.DTO.WorkTypeDTO;
import com.sap.document.sap.soap.functions.mc_style.ObjectFactory;
import com.sap.document.sap.soap.functions.mc_style.ZpernDebitor;
import com.sap.document.sap.soap.functions.mc_style.ZsdBillCreate;
import com.sap.document.sap.soap.functions.mc_style.ZsdBillCreateResponse;
import com.sap.document.sap.soap.functions.mc_style.ZsdBillPrint;
import com.sap.document.sap.soap.functions.mc_style.ZsdBillPrintResponse;
import com.sap.document.sap.soap.functions.mc_style.ZsdGetMatnrForSmit;
import com.sap.document.sap.soap.functions.mc_style.ZsdGetMatnrForSmitResponse;
import com.sap.document.sap.soap.functions.mc_style.ZsdOrderAddPos;
import com.sap.document.sap.soap.functions.mc_style.ZsdOrderAddPosResponse;
import com.sap.document.sap.soap.functions.mc_style.ZsdOrderCreate;
import com.sap.document.sap.soap.functions.mc_style.ZsdOrderCreateResponse;
import com.sap.document.sap.soap.functions.mc_style.Zsdsmitmatnr;
import com.sap.document.sap.soap.functions.mc_style.ZsearchPerson;
import com.sap.document.sap.soap.functions.mc_style.ZsearchPersonResponse;

/**
 * @author us9047
 * 
 * SapClient is a class which contains all needed methods for
 * interaction with SAP web-service
 */

public class SapClient extends WebServiceGatewaySupport {

  private static final Logger LOGGER = Logger.getLogger(SapClient.class);

  private static final String EMPTY_FIELD = "";
  
  @Autowired
  private ObjectFactory of;

  /**
   *
   * Returns all employee info by time-board number
   * 
   * @param time-board number of an employee
   * @return ZsearchPersonResponse object with an employee info
   */
  private ZsearchPersonResponse getZsearchPersonResponse(String tabNumber) {

    ZsearchPerson request = of.createZsearchPerson();
    request.setFstnameM(EMPTY_FIELD);
    request.setLastnameM(EMPTY_FIELD);
    request.setOrgtxt(EMPTY_FIELD);
    request.setJobtxt(EMPTY_FIELD);
    request.setJob(EMPTY_FIELD);
    request.setOrgtxt(EMPTY_FIELD);
    request.setOrgUnit(EMPTY_FIELD);
    request.setCheckCommunities(EMPTY_FIELD);
    request.setEmployeeId(tabNumber);
    request.setOutTab(of.createTableOfZpernDebitor());
    ZsearchPersonResponse response = (ZsearchPersonResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    return response;
  }

  /**
   *
   * Returns array with info about all work types which are available in SAP
   *
   * @return ZsdGetMatnrForSmitResponse object
   */
  private ZsdGetMatnrForSmitResponse getZsdGetMatnrForSmitResponse() {

    ZsdGetMatnrForSmit request = of.createZsdGetMatnrForSmit();
    request.setZmatnrtable(of.createTableOfZsdsmitmatnr());
    return (ZsdGetMatnrForSmitResponse) getWebServiceTemplate().marshalSendAndReceive(request);
  }

  /**
   * 
   * Creates order in SAP
   *
   * @param registration number of a car
   * @return ZsdOrderCreateResponse object
   */
  private ZsdOrderCreateResponse getZsdOrderCreateResponse(String carNum, String performer_id) {

    ZsdOrderCreate request = of.createZsdOrderCreate();
    request.setOrderClient("8000000001");
    request.setOrderType("SMIT");
    request.setOrderDoc(carNum);
    request.setOrderPernr(performer_id);
    request.setMesstab(of.createTableOfBdcmsgcoll());
    return (ZsdOrderCreateResponse) getWebServiceTemplate().marshalSendAndReceive(request);
  }

  /**
   * 
   * Adds position to order in SAP
   *
   * @param number of order from SAP
   * @param work type code from SAP
   * @param amount of work to do 
   * @return ZsdOrderAddPosResponse object
   */
  private ZsdOrderAddPosResponse getOrderAddPosResponse(String orderNum, String itemNum, String itemCount) {
   
    ZsdOrderAddPos request = of.createZsdOrderAddPos();
    request.setOrderNum(orderNum);
    request.setItemNum(itemNum);
    request.setItemCnt(itemCount);
    request.setMesstab(of.createTableOfBdcmsgcoll());
    return (ZsdOrderAddPosResponse) getWebServiceTemplate().marshalSendAndReceive(request);
  }

  /**
   * 
   * Creates bill in SAP
   *
   * @param order number from SAP
   * @return ZsdBillCreateResponse object
   */
  private ZsdBillCreateResponse getZsdBillCreateResponse(String orderNum) {

    ZsdBillCreate request = of.createZsdBillCreate();
    request.setOrderNum(orderNum);
    request.setMesstab(of.createTableOfBdcmsgcoll());
    return (ZsdBillCreateResponse) getWebServiceTemplate().marshalSendAndReceive(request);

  }

  /**
   * 
   * Returns pdf file with bill from SAP
   *
   * @param bill number from SAP
   * @return ZsdBillPrintResponse object
   */
  private ZsdBillPrintResponse getZsdBillPrintResponse(String billNumber) {
   
    ZsdBillPrint request = of.createZsdBillPrint();
    request.setBillNumber(billNumber);
    return (ZsdBillPrintResponse) getWebServiceTemplate().marshalSendAndReceive(request);
  }
  
  /**
   * 
   * Returns full name of an employee
   *
   * @param time-board number of an employee
   * @return String with employee`s full name or null if there is no employee
   * with such time-board number
   */
  public String getFullName(String tabNumber) {

    ZsearchPersonResponse response = getZsearchPersonResponse(tabNumber);
    List<ZpernDebitor> itemList = response.getOutTab().getItem();
    if (itemList.size() != 0) {
      ZpernDebitor userInfo = itemList.get(0);
      return userInfo.getFamily() + " " + userInfo.getName() + " " + userInfo.getFather();
    } else {
      return null;
    }
  }

  /**
   * 
   * Returns an employee`s email
   *
   * @param time-board number of an employee
   * @throws IndexOutOfBoundsException exception
   * @return String with employee`s email 
   */
  public String getUserEmail(String tabNumber) {

    ZsearchPersonResponse response = getZsearchPersonResponse(tabNumber);
    try {
      return response.getOutTab().getItem().get(0).getEmail();
    } catch (IndexOutOfBoundsException e) {
      LOGGER.error("Something wrong with SAP person search service", e);
      throw e;
    }
 
  }

  /**
   * 
   * Returns list of all available workTypes
   *
   * @return List<WorkTypeDTO> object
   */
  public List<WorkTypeDTO> getAllWorktypes() {

    ZsdGetMatnrForSmitResponse response = getZsdGetMatnrForSmitResponse();
    List<Zsdsmitmatnr> list = response.getZmatnrtable().getItem();
    List<WorkTypeDTO> workTypeList = new ArrayList<>(list.size());
    for (int i = 0; i < list.size(); i++) {
      Zsdsmitmatnr zsdsmitmatnr = list.get(i);
      WorkTypeDTO workTypeDTO = new WorkTypeDTO();
      workTypeDTO.setId(zsdsmitmatnr.getMatnr());
      workTypeDTO.setName(zsdsmitmatnr.getMaktx());
      workTypeDTO.setPrice(zsdsmitmatnr.getKbetr().toString());
      workTypeDTO.setTime(zsdsmitmatnr.getVrvez());
      workTypeList.add(workTypeDTO);
    }

    return workTypeList;
  }

  /**
   * 
   * Returns order info
   *
   * @param registration number of a car
   * @param work type code from SAP
   * @param amount of work to do 
   * @return OrderDTO object with order info  
   */
  public OrderDTO getOrder(String carNum, String itemNum, String itemCount, String performer_id) {

    ZsdOrderCreateResponse response = getZsdOrderCreateResponse(carNum, performer_id);
    OrderDTO order = new OrderDTO();
    int respCode = response.getSubrc();
    if (respCode == 0) {
      ZsdOrderAddPosResponse posResponse = getOrderAddPosResponse(response.getSalesOrder(), itemNum, itemCount);
      int posRespCode = posResponse.getSubrc();
      if (posRespCode == 0) {
        order.setOrderNum(posResponse.getSalesOrder());
        order.setOrderPrice(posResponse.getItemSapPrice());
        order.setOrderTime(posResponse.getItemDate());
      } else {
        LOGGER.error("Can`t add order position in SAP, return wrong result code " + posRespCode);
      }
    } else {
      LOGGER.error("Can`t create order in SAP, return wrong result code " + respCode);
    }
    return order;
  }
  
  
  /**
   * 
   * Returns number of the bill
   *
   * @param order number from SAP
   * @return String with number of the bill from SAP  
   */
  public String getBillNumber(String orderNum) {
   
    ZsdBillCreateResponse response = getZsdBillCreateResponse(orderNum);
    int respCode = response.getSubrc();
    if (respCode == 0) {
      return response.getBillNumber();
    } else {
      LOGGER.error("Can`t create bill in SAP, return wrong result code " + respCode);
      throw new RuntimeException();
    }
  }

  /**
   * 
   * Returns PDF with a bill
   *
   * @param bill number from SAP
   * @return byte[] object with bill  
   */
  public byte[] getPDFBill(String billNum) {
    
    byte[] pdfBillData = null;
    ZsdBillPrintResponse responseWithBill = getZsdBillPrintResponse(billNum);
    pdfBillData = responseWithBill.getPdfBinaryData();
    return pdfBillData;
  }

}
