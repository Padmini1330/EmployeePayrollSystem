package EmployeePayrollSystem;

public class Company 
{
	public int companyID;
	public String companyName;
	
	
	public Company(int companyID, String companyName)
	{
		super();
		this.companyID = companyID;
		this.companyName = companyName;
	}
	public int getCompanyID() 
	{
		return companyID;
	}
	public String getCompanyName() 
	{
		return companyName;
	}
	public void setCompanyID(int companyID) 
	{
		this.companyID = companyID;
	}
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}
	@Override
	public String toString() 
	{
		return "Company [companyID=" + companyID + ", companyName=" + companyName + "]";
	}
		
}
