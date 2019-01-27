package com.faisal.DAO;
import com.faisal.Model.Order;

public interface OrderDAO {

	boolean addOrder(Order order);
	
	boolean innerJoin();
	
	boolean outerJoin();
	
	boolean leftJoin();
	
	boolean rightJoin();
	
	boolean fullJoin();
	
	boolean selfJoin();
	
	boolean wildCards();
}
