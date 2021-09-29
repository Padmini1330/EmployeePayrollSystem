package EmployeePayrollSystem;

import java.time.LocalDate;
import java.util.List;

public class Employee 
{
	public int employeeID;
	public int departmentID;
	public int companyID;
	public String employeeName;
	public String gender;
	public String address;
	public String phoneNumber;
	public LocalDate startDate;
    private Payroll payroll;
    private Company company;
    
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    private List<Department> departmentList;
    
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

	public LocalDate getStartDate()
	{
		return startDate;
	}

	public Company getCompany()
	{
		return company;
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

	public void setStartDate(LocalDate startDate)
	{
		this.startDate = startDate;
	}

	public void setCompany(Company company) 
	{
		this.company = company;
	}

	public Payroll getPayroll() 
    {
        return payroll;
    }

    public void setPayroll(Payroll payroll) 
    {
        this.payroll = payroll;
    }

    public Employee(int id, int deptID,int companyID,String name, String gender, String address, String phoneNumber, LocalDate startDate,Payroll payroll,Company company)
    {
        this.employeeID = id;
        this.departmentID = deptID;
        this.companyID = companyID;
        this.employeeName = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.payroll=payroll;
        this.company=company;

    }

	public Employee(int employeeID, int departmentID, int companyID, String employeeName, String gender, String address,
			String phoneNumber, LocalDate startDate) 
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

	

	@Override
	public String toString() 
	{
		return "Employee [employeeID=" + employeeID + ", departmentID=" + departmentID + ", companyID=" + companyID
				+ ", employeeName=" + employeeName + ", gender=" + gender + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", startDate=" + startDate + ", payroll=" + payroll + ", company=" + company + "]";
	}

    
}
	

