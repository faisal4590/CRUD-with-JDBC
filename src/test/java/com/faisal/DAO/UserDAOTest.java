package com.faisal.DAO;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.faisal.DatabaseUtil.DBOperations;
import com.faisal.Model.Employee;
import com.faisal.Service.UserDAOImplementation;

import lombok.NonNull;

public class UserDAOTest {

	@Test
	public void testInsertSQL() {
		Employee emp = new Employee();
		emp.setEmp_name("Tamim Iqbal");
		emp.setEmp_salary((@NonNull float) 313222);
		emp.setEmp_country("Bangladesh");
		emp.setEmp_city("Comilla");
		emp.setEmp_zipCode("+863");

		UserDAOImplementation ud = new UserDAOImplementation();

		assertEquals(true, ud.addUser(emp));
	}

	@Test
	public void testUpdateSQL() {
		Employee emp = new Employee();
		emp.setEmp_name("Faisal Ibna Aziz");
		emp.setEmp_salary((@NonNull float) 423638);
		emp.setEmp_country("Bangladesh");
		emp.setEmp_city("Dhaka");
		emp.setEmp_zipCode("+880");
		emp.setEmp_id(2);

		UserDAOImplementation ud = new UserDAOImplementation();

		assertEquals(true, ud.upadateUser(emp));
	}

	@Test
	public void testDeleteSQL() {
		Employee emp = new Employee();
		emp.setEmp_id(1);
		UserDAOImplementation ud = new UserDAOImplementation();

		assertEquals(true, ud.deleteUser(emp));
	}

	@Test
	public void testGetMaxSalary() {
		Employee emp = new Employee();
		UserDAOImplementation ud = new UserDAOImplementation();
		float value = 423638;
		assertEquals((int) value, (int) ud.getMax(emp));
	}

	@Test
	public void testGetMinSalary() {
		Employee emp = new Employee();
		UserDAOImplementation ud = new UserDAOImplementation();
		float value = (float) 78638.3125;
		assertEquals((int) value, (int) ud.getMin(emp));
	}

	@Test
	public void testGetSecondMaxSalary() {
		Employee emp = new Employee();
		UserDAOImplementation ud = new UserDAOImplementation();
		float value = (float) 423638;
		assertEquals((int) value, (int) ud.getSecondMax(emp));
	}

	@Test
	public void testGetSecondMinSalary() {
		Employee emp = new Employee();
		UserDAOImplementation ud = new UserDAOImplementation();
		float value = (float) 313222;
		assertEquals((int) value, (int) ud.getSecondMin(emp));
	}

	@Test
	public void testTopThree() throws SQLException {
		UserDAOImplementation employeeDAO = new UserDAOImplementation();
		ArrayList<Employee> list = employeeDAO.getTopThree();
		assertEquals(new Employee(2, "Faisal Ibna Aziz ", 423638, "Bangladesh", "Dhaka", "+880"), list.get(0));
	}

	@Test
	public void testAvg() {
		Employee emp = new Employee();
		UserDAOImplementation ud = new UserDAOImplementation();
		float value = (float) 205596;
		assertEquals((int) value, (int) ud.getAvg(emp));
	}

	@Test
	public void testSearchUser() {
		Employee emp = new Employee(2, "Faisal Ibna Aziz", 423638.0, "Bangladesh", "Dhaka", "+880");
		UserDAOImplementation ud = new UserDAOImplementation();

		assertEquals(emp, ud.searchUserByID(2));
	}

	@Test
	public void show() throws SQLException {
		DBOperations dbOperations = new DBOperations();
		dbOperations.displayAll(); // dbOperations.getTopThree();

		dbOperations.storedProcedureExample();
	}

}
