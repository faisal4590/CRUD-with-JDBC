package com.faisal.DatabaseUtil;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		String insertSQL = "INSERT INTO [dbo].[faisal.employee]"
				+ "(EMP_NAME, EMP_SALARY, EMP_COUNTRY, EMP_CITY, EMP_ZIPCODE) VALUES" + "(?,?,?,?,?)";

		PreparedStatement preparedStatement = initialize().prepareStatement(insertSQL);

		preparedStatement.setString(1, emp.getEmp_name());
		preparedStatement.setFloat(2, emp.getEmp_salary());
		preparedStatement.setString(3, emp.getEmp_country());
		preparedStatement.setString(4, emp.getEmp_city());
		preparedStatement.setString(5, emp.getEmp_zipCode());

		// execute insert SQL stetement
		preparedStatement.execute();

	}

	public void updateEmployee(Employee emp) throws SQLException {
		String updateSQL = "UPDATE [dbo].[faisal.employee]"
				+ " SET EMP_NAME = ?, EMP_SALARY = ?, EMP_COUNTRY=?, EMP_CITY=?," + "EMP_ZIPCODE=? WHERE EMP_ID = ?";

		PreparedStatement preparedStatement = initialize().prepareStatement(updateSQL);

		// set the preparedstatement parameters
		preparedStatement.setString(1, emp.getEmp_name());
		preparedStatement.setFloat(2, emp.getEmp_salary());
		preparedStatement.setString(3, emp.getEmp_country());
		preparedStatement.setString(4, emp.getEmp_city());
		preparedStatement.setString(5, emp.getEmp_zipCode());
		preparedStatement.setInt(6, emp.getEmp_id());

		// execute insert SQL stetement
		preparedStatement.execute();
	}

	public void deleteEmployee(Employee emp) throws SQLException {
		String deleteSQL = "DELETE [dbo].[faisal.employee] WHERE EMP_ID = ?";

		PreparedStatement preparedStatement = initialize().prepareStatement(deleteSQL);
		// set the preparedstatement parameters
		preparedStatement.setInt(1, emp.getEmp_id());

		preparedStatement.execute();

	}

	public float getMaxSalary(Employee emp) throws SQLException
	{
		String getMaxSQL = "SELECT MAX(EMP_SALARY) FROM [dbo].[faisal.employee]";

		ResultSet rs = initialize().createStatement().executeQuery(getMaxSQL);
		float maxSalary = 0;
		while(rs.next())
		{
			maxSalary = (float) rs.getDouble("emp_salary");
		}
		
		return maxSalary;
	}
	
	public void displayAll() throws SQLException {
		String selectSQL = "SELECT * FROM [dbo].[faisal.employee]";

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
