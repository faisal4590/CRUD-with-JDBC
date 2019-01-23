package com.faisal.Service;

import java.sql.SQLException;
import java.util.List;

import com.faisal.DAO.UserDAO;
import com.faisal.DatabaseUtil.DBOperations;
import com.faisal.Model.Employee;

public class UserDAOImplementation implements UserDAO {

	@Override
	public boolean addUser(Employee user) {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.insertEmployee(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean upadateUser(Employee user) {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.updateEmployee(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean deleteUser(Employee user) {

		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.deleteEmployee(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public Employee get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getMax(Employee user) {
		DBOperations dbOperations = new DBOperations();
		float maxSalary= 0;
		try {
			maxSalary = dbOperations.getMaxSalary(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return maxSalary;
	}

}
