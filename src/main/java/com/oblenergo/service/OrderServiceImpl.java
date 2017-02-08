package com.oblenergo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oblenergo.DAO.OrderDao;
import com.oblenergo.model.Orders;

@Service
public class OrderServiceImpl implements OrderService {

  Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

  @Autowired
  OrderDao dao;

  /** FullTimeRange it is array with all hours for full work days */
  private final static String[] fullTimeRange = { "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00",
      "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00",
      "17:00:00", "17:30:00" };

  /** shortTimeRange it is array with all hours for short work day it is Friday */
  private final static String[] shortTimeRange = { "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00",
      "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00" };

  private final static int shortDay = 7;// Friday

  /** This method return list of all orders which are in DB
   * 
   * @throws DataAccessException
   * @return List<Orders> */
  @Transactional
  @Override
  public List<Orders> findAll() {
    try {
      return dao.findAllItems();
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to get all workTypes", dae);
      throw dae;
    }
  }

  /** Save to DB
   * 
   * @param Orders which have to be save
   * @throws DataAccessException */

  @Transactional
  @Override
  public void save(Orders order) {
    try {
      dao.save(order);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to write data to DB for save order", dae);
      throw dae;
    }
  }

  /** Find by id from DB
   * 
   * @param int id for search Orders in DB
   * @throws DataAccessException */
  @Transactional
  @Override
  public Orders findOrderById(int id) {
    try {
      return dao.findById(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find order with id : " + id, dae);
      throw dae;
    }
  }

  /** Update order in DB
   * 
   * @param Orders order which have to be update
   * @throws DataAccessException */
  @Transactional
  @Override
  public void update(Orders order) {

    Orders entity = null;
    try {

      entity = dao.findById(order.getId());

    } catch (DataAccessException dae) {
      LOGGER.error("Unable to get order with id : " + order.getId(), dae);
      throw dae;
    }

    entity.setCount(order.getCount());
    entity.setCar(order.getCar());
    entity.setCar_model(order.getCar_model());
    entity.setPerformer_id(order.getPerformer_id());
    entity.setDate(order.getDate());
    entity.setTime(order.getTime());
    entity.setTime_end(order.getTime_end());
    entity.setCar_number(order.getCar_number());
    entity.setStatus_order(order.getStatus_order());
    entity.setBill_number(order.getBill_number());

  }

  /** Delete from DB
   * 
   * @param int id of Orders which have to be remove
   * @throws DataAccessException */
  @Transactional
  @Override
  public void delete(int id) {
    try {
      dao.delete(id);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to delete order with id : " + id, dae);
      throw dae;
    }

  }

  /** Looking for all orders with date from DB
   * 
   * @param String date of Orders
   * @throws DataAccessException */
  @Transactional
  @Override
  public List<Orders> findDateOfOrders(String date) {
    try {
      return dao.dateOfOrders(date);
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find order with date" + date);
      throw dae;
    }
  }

  /** Search all free hours for order
   * 
   * @param String[][] arrTimeOrders - all time orders which have status DONE OR PAID
   * @param String date - it date from input which chosen administrator
   * @param Orders order - it order from form which edited administrator
   * @param String timeExecution - it time execution of order from SAP */
  @Override
  public List<String> findFreeTimeForAdmin(String[][] arrTimeOrders, String date, Orders order, String timeExecution) {
    String[] timeAdmin;

    if (shortDay == getDayOfWeek(date)) {
      timeAdmin = shortTimeRange;
    } else {
      timeAdmin = fullTimeRange;
    }

    List<String> busyTime = getBusyTimes(timeAdmin, arrTimeOrders, date);
    List<String> freeTime = getFreeTime(timeAdmin, busyTime);
    List<String> avaliableTime = getAvailableTime(timeAdmin, freeTime, order, timeExecution);

    return avaliableTime;
  }

  /** Use for getting week`s day of order
   * 
   * @param date
   * @return int dateOfWeek */
  public int getDayOfWeek(String date) {
    Calendar c = Calendar.getInstance();
    try {
      c.setTime(new SimpleDateFormat("yyyy-mm-dd").parse(date));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    return dayOfWeek;
  }

  /** Use for getting busy time on order`s day
   * 
   * @param time
   * @param arrTimeOrders
   * @param date
   * @return List<String> busyTime */
  public List<String> getBusyTimes(String[] time, String[][] arrTimeOrders, String date) {
    /** value beginning order`s execution */
    int start = 0;
    /** value finish order`s execution */
    int end = 1;

    /** value for definition start time of order, it must not write to list with
     * busy time */
    int startTimeOrder;

    ArrayList<String> busyTimes = new ArrayList<String>();
    // array of all times of week
    for (int timeI = 0; timeI < time.length; timeI++) {

      outTimeOrder: for (int timeOrderI = 0; timeOrderI < arrTimeOrders.length; timeOrderI++) {
        for (int j = 0; j < arrTimeOrders[timeOrderI].length; j++) {
          if (time[timeI].equals(arrTimeOrders[timeOrderI][start])) {

            startTimeOrder = 0;

            for (int i = timeI; i < time.length; i++) {

              startTimeOrder++;
              if (time[i].equals(arrTimeOrders[timeOrderI][end])) {
                timeI = i - 1;
                break outTimeOrder;

              } else {
                if (startTimeOrder != 1) {
                  busyTimes.add(time[i]);
                }
              }
            }
          } else {
            break;
          }
        }
      }
    }

    /** removes duplicate from list busyTimes */
    Set<String> setBusyTime = new LinkedHashSet<String>(busyTimes);

    // write to ArrayList for working with indexes
    ArrayList<String> busy = new ArrayList<String>(setBusyTime);
    return busy;
  }

  /** Use for getting available time for set time order
   * 
   * @param time
   * @param freeTime
   * @param order
   * @param timeExecution
   * @return List<String> availableTime */
  public List<String> getAvailableTime(String time[], List<String> freeTime, Orders order, String timeExecution) {

    /** List for save available time */
    List<String> availableTime = new ArrayList<String>();

    /** value which have count of order */
    int countOrder = order.getCount();

    /** value which have number steps for equal hours in list */
    int stepTime = convertToStep(timeExecution) * countOrder;

    int countEquals = 0;
    int temp = 0;

    for (int i = 0; i < time.length; i++) {
      temp = i;
      for (int j = 0; j < freeTime.size(); j++) {
        if (time[i].equals(freeTime.get(j))) {
          countEquals++;
          i++;
          if (countEquals == stepTime) {
            availableTime.add(time[temp]);
            countEquals = 0;
            i = temp;
            break;
          }
        } else {
          countEquals = 0;
          i = temp;
        }
      }
    }

    return availableTime;
  }

  /** Convert execution of order to step for comparing hours which are in this range of
   * 
   * @param String execution
   * @return int double step */
  public int convertToStep(String execution) {
    double timeExecution = 0;
    timeExecution = Double.parseDouble(execution);
    double execOrder = (double) (timeExecution / 60);
    return (int) (execOrder + execOrder + 1);
  }

  /** Return list with hours which are free in day
   * 
   * @param String[] time - it array with all hours of day
   * @param List<String> busyTime - it list with hours, which are busy in day
   * @return List<String> - list with hours which are free */
  public List<String> getFreeTime(String[] time, List<String> busyTime) {

    List<String> list = new ArrayList<>(Arrays.asList(time));
    List<String> freeTime = list.stream().filter(x -> !busyTime.contains(x)).collect(Collectors.toList());
    return freeTime;
  }

  /** Return multidimensional array which have hours start and finish of orders
   * 
   * @param List<Orders> orders - it list all orders which have in day
   * @return String[][] - multidimensional array with hours start and finish of orders */
  @Override
  public String[][] getAllTimeOfOrders(List<Orders> orders) {

    String[][] arrTimeOrders = new String[orders.size()][2];
    for (int i = 0; i < arrTimeOrders.length; i++) {

      for (int j = 0; j < arrTimeOrders[i].length; j++) {
        arrTimeOrders[i][0] = orders.get(i).getTime();
        arrTimeOrders[i][1] = orders.get(i).getTime_end();
      }
    }
    return arrTimeOrders;
  }

  /** Finds all orders which have status DONE
   * 
   * @throws DataAccessException
   * @return List<Orders> - list with orders which have status DONE */
  @Transactional
  @Override
  public List<Orders> findAllConfirm() {
    try {
      return dao.findAllConfirmOrders();
    } catch (DataAccessException dae) {
      LOGGER.error("Unable to find new orders");
      throw dae;
    }

  }

  @Transactional
  @Override
  public List<Orders> findAllPaid(){
    try{
      return  dao.findAllPaidOrders();
    } catch (DataAccessException dae){
      LOGGER.error("Unable to find paid orders");
      throw  dae;
    }
  }
}
