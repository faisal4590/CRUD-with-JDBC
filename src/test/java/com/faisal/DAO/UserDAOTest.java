package com.faisal.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.faisal.DatabaseUtil.DBOperations;
import com.faisal.Model.Employee;
import com.faisal.Service.UserDAOImplementation;

import lombok.NonNull;

public class UserDAOTest {

	/*
	 * @Test public void testInsertSQL() { Employee emp = new Employee();
	 * emp.setEmp_name("Mushfiqur Rahim"); emp.setEmp_salary((@NonNull float)
	 * 423638); emp.setEmp_country("Bangladesh"); emp.setEmp_city("Sylhet");
	 * emp.setEmp_zipCode("+640");
	 * 
	 * UserDAOImplementation ud = new UserDAOImplementation();
	 * 
	 * assertEquals(true, ud.addUser(emp)); }
	 * 
	 * @Test public void testUpdateSQL() { Employee emp = new Employee();
	 * emp.setEmp_name("Faisal Ibna Aziz"); emp.setEmp_salary((@NonNull float)
	 * 423638); emp.setEmp_country("Bangladesh"); emp.setEmp_city("Dhaka");
	 * emp.setEmp_zipCode("+880"); emp.setEmp_id(2);
	 * 
	 * UserDAOImplementation ud = new UserDAOImplementation();
	 * 
	 * assertEquals(true, ud.upadateUser(emp)); }
	 * 
	 * @Test public void testDeleteSQL() { Employee emp = new Employee();
	 * emp.setEmp_id(1); UserDAOImplementation ud = new UserDAOImplementation();
	 * 
	 * assertEquals(true, ud.deleteUser(emp)); }
	 */

	@Test
	public void testGetMaxSalary() {
		Employee emp = new Employee();
		UserDAOImplementation ud = new UserDAOImplementation();
		float value = 423638;
		assertEquals(value, ud.getMax(emp));
	}

	@Test
	public void show() throws SQLException {
		DBOperations dbOperations = new DBOperations();
		dbOperations.displayAll();
		// dbOperations.createTable();
	}

}
