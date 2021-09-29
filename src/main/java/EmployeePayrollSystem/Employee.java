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
	public LocalDate startDate;
    private Payroll payroll;
    private Company company;

   
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
			String phoneNumber, LocalDate startDate) {
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
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", departmentID=" + departmentID + ", companyID=" + companyID
				+ ", employeeName=" + employeeName + ", gender=" + gender + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", startDate=" + startDate + ", payroll=" + payroll + ", company=" + company + "]";
	}

    
}
	

