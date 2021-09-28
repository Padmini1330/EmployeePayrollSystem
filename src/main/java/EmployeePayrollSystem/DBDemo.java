package EmployeePayrollSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;


public class DBDemo 
{

	private static void listdrivers() 
	{
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) 
		{
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("	"+driverClass.getClass().getName());
		}
	}

	public static void main(String[] args) 
	{

		String jdbcURL = "jdbc:mysql://localhost:3306/AddressBookService?useSSL=false";
		String userName = "root";
		String password = "Padmini_1330";
		Connection connection;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded !");
		}
		catch(ClassNotFoundException e)
		{
			throw new IllegalStateException("Cannot Find The Driver in the Classpath !", e);
		}

		listdrivers();

		try {
			System.out.println("Connecting to the database : "+jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("Connection is Successful!! "+connection);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
