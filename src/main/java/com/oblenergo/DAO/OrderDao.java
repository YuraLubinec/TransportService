package com.oblenergo.DAO;

import com.oblenergo.model.Orders;

import java.util.List;

public interface OrderDao {

	Orders findById(int id);

	List<Orders> findAllItems();

	void save(Orders order);

	void delete(int id);

	List<Orders> dateOfOrders(String date);
	
	List<Orders> findAllNewOrders();

	List<Orders> findAllConfirmOrders();

	List<Orders> findAllPaidOrders();

}
