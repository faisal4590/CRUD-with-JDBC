package com.faisal.DAO;
import com.faisal.Model.Order;

public interface OrderDAO {

	boolean addOrder(Order order);
	
	boolean innerJoin();
}
