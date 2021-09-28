package EmployeePayrollSystem;

public class Department 
{
	public int department;
	public String departmentName;
	
	
	public Department(int department, String departmentName) 
	{
		super();
		this.department = department;
		this.departmentName = departmentName;
	}
	
	public int getDepartment() 
	{
		return department;
	}
	public String getDepartmentName() 
	{
		return departmentName;
	}
	public void setDepartment(int department) 
	{
		this.department = department;
	}
	public void setDepartmentName(String departmentName) 
	{
		this.departmentName = departmentName;
	}
	@Override
	public String toString() 
	{
		return "Department [department=" + department + ", departmentName=" + departmentName + "]";
	}
	
	
}
