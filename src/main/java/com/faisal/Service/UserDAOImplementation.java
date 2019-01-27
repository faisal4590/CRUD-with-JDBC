package com.faisal.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.faisal.DAO.OrderDAO;
import com.faisal.DAO.UserDAO;
import com.faisal.DatabaseUtil.DBOperations;
import com.faisal.Model.Employee;
import com.faisal.Model.Order;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDAOImplementation implements UserDAO,OrderDAO {
	
	static Logger logger = Logger.getLogger(UserDAOImplementation.class.getName());
	
	@Override
	public boolean addUser(Employee user) {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.insertEmployee(user);
			log.info("Employee added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("User is not added, Please try again, " + e.getMessage());
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
			log.info("Employee updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("User is not updated, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean deleteUser(Employee user) {

		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.deleteEmployee(user);
			log.info("Employee deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("User is not deleted, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public Employee searchUserByID(int userId) {
		// TODO Auto-generated method stub
		
		DBOperations dbOperations = new DBOperations();

		try {
			Employee emp = dbOperations.getEmployee(userId);
			log.info("Employee has been found.");
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//logger.warning("User is not found, Please try again, " + e.getMessage());
			log.warn("User is not found, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		return null; ///jodi employee na pay
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
			log.info("Successfully got the max salary");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Failed to get the max salary");
			e.printStackTrace();
		}

		return maxSalary;
	}
	
	@Override
	public float getMin(Employee user) {
		DBOperations dbOperations = new DBOperations();
		float minSalary= 0;
		try {
			minSalary = dbOperations.getMinSalary(user);
			log.info("Successfully got the min salary");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Failed to get the min salary" + e.getMessage());
			e.printStackTrace();
		}

		return minSalary;
	}
	
	@Override
	public float getSecondMax(Employee user) {
		DBOperations dbOperations = new DBOperations();
		float secondMaxSalary= 0;
		try {
			secondMaxSalary = dbOperations.getSecondMaxSalary(user);
			log.info("Successfully got the 2nd max salary");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Faled to the 2nd max salary, " + e.getMessage());
			e.printStackTrace();
		}

		return secondMaxSalary;
	}
	
	@Override
	public float getSecondMin(Employee user) {
		DBOperations dbOperations = new DBOperations();
		float secondMinSalary= 0;
		try {
			secondMinSalary = dbOperations.getSecondMinSalary(user);
			log.info("Successfully got the 2nd min salary");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Failed to the 2nd min salary, " + e.getMessage());
			e.printStackTrace();
		}

		return secondMinSalary;
	}
	
	@Override
	public ArrayList<Employee> getTopThree() {

		DBOperations dbo = new DBOperations();
		try {
			log.info("Successfully got the top three Employee");
			return dbo.getTopThree();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Failed to get thetop three Employee");
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public float getAvg(Employee user) {
		DBOperations dbOperations = new DBOperations();
		float avg= 0;
		try {
			avg = dbOperations.getAvgSalary(user);
			log.info("Successfully got the average salary");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Failed to get the average salary," + e.getMessage());
			e.printStackTrace();
		}

		return avg;
	}

	//Implementing orderDAO
	
	@Override
	public boolean addOrder(Order order) {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.insertOrder(order);
			log.info("Order added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Order is not added, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean innerJoin() {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.innerJoinOrder();
			log.info("Inner join performed successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Inner join is not performed successfully, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean outerJoin() {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.outerJoinOrder();
			log.info("Outer join performed successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Outer join is not performed successfully, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean leftJoin() {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.outerJoinOrder();
			log.info("Left join performed successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Left join is not performed successfully, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean rightJoin() {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.rightJoinOrder();
			log.info("Right join performed successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Right join is not performed successfully, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean fullJoin() {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.fullJoinOrder();
			log.info("Full join performed successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Full join is not performed successfully, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean selfJoin() {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.selfJoinOrder();
			log.info("Self join performed successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Self join is not performed successfully, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean wildCards() {
		DBOperations dbOperations = new DBOperations();

		try {
			dbOperations.wildCardsOrder();
			log.info("Wildcards performed successfully");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.warn("Wildcards is not performed successfully, Please try again, " + e.getMessage());
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}


	
}
