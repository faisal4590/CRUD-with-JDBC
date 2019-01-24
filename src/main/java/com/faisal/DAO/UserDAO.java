package com.faisal.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.faisal.Model.Employee;

public interface UserDAO {

	boolean addUser(Employee user);

	boolean upadateUser(Employee user);

	boolean deleteUser(Employee user);
	
	float getMax(Employee user);
	
	float getMin(Employee user);
	
	float getSecondMax(Employee user);

	float getSecondMin(Employee user);
	
	ArrayList<Employee> getTopThree();
	
	float getAvg(Employee user);
	
	Employee searchUserByID(int userId);

	List<Employee> listAll();

}