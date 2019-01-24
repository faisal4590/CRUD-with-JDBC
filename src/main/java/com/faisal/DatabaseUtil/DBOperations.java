package com.faisal.DatabaseUtil;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.faisal.Model.Employee;

public class DBOperations {

	public Connection initialize() {
		DBConnection conn = DBConnection.getInstance();
		Connection dbConnection = conn.getConnection();
		return dbConnection;
	}

	public void createTable() throws SQLException {

		String createTableSQL = "CREATE TABLE [dbo].[anotherTable]";
		PreparedStatement preparedStatement = initialize().prepareStatement(createTableSQL);
		preparedStatement.execute();

	}

	public void insertEmployee(Employee emp) throws SQLException {

		String insertSQL = "INSERT INTO [dbo].[faisal_employee]"
				+ "(EMP_NAME, EMP_SALARY, EMP_COUNTRY, EMP_CITY, EMP_ZIPCODE) VALUES" + "(?,?,?,?,?)";

		PreparedStatement preparedStatement = initialize().prepareStatement(insertSQL);

		preparedStatement.setString(1, emp.getEmp_name());
		preparedStatement.setDouble(2, emp.getEmp_salary());
		preparedStatement.setString(3, emp.getEmp_country());
		preparedStatement.setString(4, emp.getEmp_city());
		preparedStatement.setString(5, emp.getEmp_zipCode());

		// execute insert SQL stetement
		preparedStatement.execute();

	}

	public void updateEmployee(Employee emp) throws SQLException {
		String updateSQL = "UPDATE [dbo].[faisal_employee]"
				+ " SET EMP_NAME = ?, EMP_SALARY = ?, EMP_COUNTRY=?, EMP_CITY=?," + "EMP_ZIPCODE=? WHERE EMP_ID = ?";

		PreparedStatement preparedStatement = initialize().prepareStatement(updateSQL);

		// set the preparedstatement parameters
		preparedStatement.setString(1, emp.getEmp_name());
		preparedStatement.setDouble(2, emp.getEmp_salary());
		preparedStatement.setString(3, emp.getEmp_country());
		preparedStatement.setString(4, emp.getEmp_city());
		preparedStatement.setString(5, emp.getEmp_zipCode());
		preparedStatement.setInt(6, emp.getEmp_id());

		// execute insert SQL stetement
		preparedStatement.execute();
	}

	public void deleteEmployee(Employee emp) throws SQLException {
		String deleteSQL = "DELETE [dbo].[faisal_employee] WHERE EMP_ID = ?";

		PreparedStatement preparedStatement = initialize().prepareStatement(deleteSQL);
		// set the preparedstatement parameters
		preparedStatement.setInt(1, emp.getEmp_id());

		preparedStatement.execute();

	}

	public float getMaxSalary(Employee emp) throws SQLException {
		// String getMaxSQL = "SELECT MAX(emp_salary) FROM dbo.Faisal_Employee";
		String getMaxSQL = "SELECT max(emp_salary) as maxsal FROM [dbo].[Faisal_Employee]";

		ResultSet rs = initialize().createStatement().executeQuery(getMaxSQL);
		float maxSalary = 0;
		while (rs.next()) {
			maxSalary = rs.getFloat("maxsal");
		}

		return maxSalary;
	}

	public float getMinSalary(Employee emp) throws SQLException {
		// String getMaxSQL = "SELECT MAX(emp_salary) FROM dbo.Faisal_Employee";
		String getMaxSQL = "SELECT min(emp_salary) as minsal FROM [dbo].[Faisal_Employee]";

		ResultSet rs = initialize().createStatement().executeQuery(getMaxSQL);
		float minSalary = 0;
		while (rs.next()) {
			minSalary = rs.getFloat("minsal");
		}

		return minSalary;
	}

	public float getSecondMaxSalary(Employee emp) throws SQLException {

		String getSecondMaxSQL = "SELECT MAX(emp_salary) as empSecondMaxsal "
				+ "FROM [dbo].[faisal_employee] where emp_salary"
				+ " < (Select MAX(emp_salary) FROM [dbo].[faisal_employee])";

		ResultSet rs = initialize().createStatement().executeQuery(getSecondMaxSQL);
		float secondMax = 0;
		while (rs.next()) {
			secondMax = rs.getFloat("empSecondMaxsal");
		}

		return secondMax;
	}

	public float getSecondMinSalary(Employee emp) throws SQLException {

		String getSecondMinSQL = "SELECT MIN(emp_salary) as empSecondMinsal "
				+ "FROM [dbo].[faisal_employee] where emp_salary"
				+ " > (Select MIN(emp_salary) FROM [dbo].[faisal_employee])";

		ResultSet rs = initialize().createStatement().executeQuery(getSecondMinSQL);
		float secondMin = 0;
		while (rs.next()) {
			secondMin = rs.getFloat("empSecondMinsal");
		}

		return secondMin;
	}

	public ArrayList<Employee> getTopThree() throws SQLException {
		String getTopThreeSQL = "SELECT TOP 3 emp_id as empid, emp_name as empname,emp_salary as empsal, "
				+ "emp_country as empcountry, emp_city as empcity, emp_zipcode as empzip FROM [dbo].[Faisal_Employee]";

		ResultSet rs = initialize().createStatement().executeQuery(getTopThreeSQL);

		ArrayList<Employee> employeeList = new ArrayList<>();
		
		while (rs.next()) {
			int id = rs.getInt("empid");
			String name = rs.getString("empname");
			int salary =rs.getInt("empsal");
			String country = rs.getString("empcountry");
			String city = rs.getString("empcity");
			String zipcode = rs.getString("empzip");
			Employee emp = new Employee(id, name, salary, country, city, zipcode);
			employeeList.add(emp);
		}
		return employeeList;
	}

	public float getAvgSalary(Employee emp) throws SQLException {
		String getMaxSQL = "SELECT AVG(emp_salary) as avgsal FROM [dbo].[Faisal_Employee]";

		ResultSet rs = initialize().createStatement().executeQuery(getMaxSQL);
		float avgSal = 0;
		while (rs.next()) {
			avgSal = rs.getFloat("avgsal");
		}

		return avgSal;
	}
	
	public Employee getEmployee(int empID) throws SQLException
	{
		String getEmployeeSQL = "SELECT * FROM [dbo].[faisal_employee] WHERE EMP_ID = ?";
		
		PreparedStatement preparedStatement = initialize().prepareStatement(getEmployeeSQL);
		// set the preparedstatement parameters
		preparedStatement.setInt(1, empID);
		
		ResultSet rs = preparedStatement.executeQuery();

		
		while(rs.next())
		{
			String empName = rs.getString("emp_name");
			double salary = rs.getDouble("emp_salary");
			String country = rs.getString("emp_country");
			String city = rs.getString("emp_city");
			String zipCode = rs.getString("emp_zipcode");
			return new Employee(empID, empName,salary,country,city,zipCode);
		}
		
		return null;//jodi employee na pay tahole null return korteci
	}
	
	public void displayAll() throws SQLException {
		String selectSQL = "SELECT * FROM [dbo].[faisal_employee]";

		ResultSet rs = initialize().createStatement().executeQuery(selectSQL);

		while (rs.next()) {
			// Retrieve by column name
			String empName = rs.getString("emp_name");
			double salary = rs.getDouble("emp_salary");
			String country = rs.getString("emp_country");
			String city = rs.getString("emp_city");
			String zipCode = rs.getString("emp_zipcode");

			// Display values
			System.out.println("Name: " + empName + ", Salary: " + salary + ", Country: " + country + ", City: " + city
					+ ", Zip code : " + zipCode);

		}

	}

}
