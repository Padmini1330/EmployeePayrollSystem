package EmployeePayrollSystem;

import java.time.LocalDate;

public class Employee 
{
	public int employeeID;
	public int departmentID;
	public int companyID;
	public String employeeName;
	public String gender;
	public String address;
	public String phoneNumber;
	public String startDate;
	
	
	
	public Employee(int employeeID, int departmentID, int companyID, String employeeName, String gender, String address,
			String phoneNumber, String startDate) 
	{
		super();
		this.employeeID = employeeID;
		this.departmentID = departmentID;
		this.companyID = companyID;
		this.employeeName = employeeName;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
	}
	


	public Employee(int id, String name) 
	{
		this.employeeID=id;
		this.employeeName=name;
	}



	public int getEmployeeID() 
	{
		return employeeID;
	}
	public int getDepartmentID() 
	{
		return departmentID;
	}
	public int getCompanyID() 
	{
		return companyID;
	}
	public String getEmployeeName() 
	{
		return employeeName;
	}
	public String getGender()
	{
		return gender;
	}
	public String getAddress() 
	{
		return address;
	}
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}
	public void setDepartmentID(int departmentID) 
	{
		this.departmentID = departmentID;
	}
	public void setCompanyID(int companyID) 
	{
		this.companyID = companyID;
	}
	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	@Override
	public String toString() 
	{
		return "Employee [employeeID=" + employeeID + ", departmentID=" + departmentID + ", companyID=" + companyID
				+ ", employeeName=" + employeeName + ", gender=" + gender + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", startDate=" + startDate + "]";
	}
	
	
}
