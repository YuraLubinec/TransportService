package com.oblenergo.DAO;

import com.oblenergo.enums.StatusOrderEnum;
import com.oblenergo.model.Orders;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractDao<Integer, Orders> implements OrderDao {

  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> findAllItems() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Orders>) crit.list();
  }

  @Override
  public void save(Orders order) {
    persist(order);
  }

  @Override
  public Orders findById(int id) {
    return getById(id);
  }

  @Override
  public void delete(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    Orders order = (Orders) crit.uniqueResult();
    delete(order);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> dateOfOrders(String date) {
    Criteria crit = createEntityCriteria();
    Criterion paidORDone = Restrictions.or(Restrictions.eq("status_order", StatusOrderEnum.PAID),
        Restrictions.eq("status_order", StatusOrderEnum.DONE));
    Criterion dateOrder = Restrictions.eq("date", date);
    crit.add(paidORDone);
    crit.add(dateOrder);
    return (List<Orders>) crit.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> findAllNewOrders() {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("status_order", StatusOrderEnum.NEW));
    crit.addOrder(Order.desc("id"));
    return (List<Orders>) crit.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> findAllConfirmOrders() {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("status_order", StatusOrderEnum.DONE));
    crit.addOrder(Order.desc("id"));
    return (List<Orders>) crit.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> findAllPaidOrders() {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.in("status_order", StatusOrderEnum.PAID, StatusOrderEnum.CANCELEDAFTERPAID, StatusOrderEnum.COMPLETED));
    crit.addOrder(Order.desc("id"));
    return (List<Orders>) crit.list();
  }

}
