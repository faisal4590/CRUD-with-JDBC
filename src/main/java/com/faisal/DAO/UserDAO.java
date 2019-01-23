package com.faisal.DAO;

import java.util.List;

import com.faisal.Model.Employee;

public interface UserDAO {

	boolean addUser(Employee user);

	boolean upadateUser(Employee user);

	boolean deleteUser(Employee user);
	
	float getMax(Employee user);

	Employee get(int userId);

	List<Employee> listAll();

}