package com.faisal.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.faisal.DatabaseUtil.DBOperations;
import com.faisal.Model.Employee;
import com.faisal.Model.Order;
import com.faisal.Service.UserDAOImplementation;

import lombok.NonNull;

public class OrderDAOTest {

	@Test
	public void testInsertOrderSQL() {
		Order order = new Order();

		order.setEmp_id(3);
		order.setOrder_name("Fantasy");
		order.setOrder_quantity(3);
		order.setOrder_price(6534);

		UserDAOImplementation ud = new UserDAOImplementation();

		assertEquals(true, ud.addOrder(order));
	}

	@Test
	public void testInnerJoin() throws SQLException {
		Order order = new Order();
		DBOperations db = new DBOperations();

		UserDAOImplementation ud = new UserDAOImplementation();

		db.innerJoinOrder();
		assertEquals(true, ud.innerJoin());
	}

	@Test
	public void testOuterJoin() throws SQLException {
		Order order = new Order();
		DBOperations db = new DBOperations();

		UserDAOImplementation ud = new UserDAOImplementation();

		db.outerJoinOrder();
		assertEquals(true, ud.outerJoin());
	}

	@Test
	public void testLeftJoin() throws SQLException {
		Order order = new Order();
		DBOperations db = new DBOperations();

		UserDAOImplementation ud = new UserDAOImplementation();

		db.leftJoinOrder();
		assertEquals(true, ud.leftJoin());
	}

	@Test
	public void testRightJoin() throws SQLException {
		Order order = new Order();
		DBOperations db = new DBOperations();

		UserDAOImplementation ud = new UserDAOImplementation();

		db.rightJoinOrder();
		assertEquals(true, ud.rightJoin());
	}

	@Test
	public void testFullJoin() throws SQLException {
		Order order = new Order();
		DBOperations db = new DBOperations();

		UserDAOImplementation ud = new UserDAOImplementation();

		db.fullJoinOrder();
		assertEquals(true, ud.fullJoin());
	}

	@Test
	public void testSelfJoin() throws SQLException {
		Order order = new Order();
		DBOperations db = new DBOperations();

		UserDAOImplementation ud = new UserDAOImplementation();

		db.selfJoinOrder();
		assertEquals(true, ud.selfJoin());
	}

	@Test
	public void testWildCards() throws SQLException {
		Order order = new Order();
		DBOperations db = new DBOperations();

		UserDAOImplementation ud = new UserDAOImplementation();

		db.wildCardsOrder();
		assertEquals(true, ud.wildCards());
	}

}
