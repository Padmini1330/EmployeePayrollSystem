package EmployeePayrollSystem;

public class Payroll 
{
	public int employeeID;
	public String basicPay;
	public String deduction;
	public String taxablePay;
	public String incomeTax;
	public String netPay;
	
	
	public Payroll(int employeeID, String basicPay, String deduction, String taxablePay, String incomeTax,
			String netPay) 
	{
		super();
		this.employeeID = employeeID;
		this.basicPay = basicPay;
		this.deduction = deduction;
		this.taxablePay = taxablePay;
		this.incomeTax = incomeTax;
		this.netPay = netPay;
	}
	
	public int getEmployeeID() 
	{
		return employeeID;
	}
	public String getBasicPay()
	{
		return basicPay;
	}
	public String getDeduction()
	{
		return deduction;
	}
	public String getTaxablePay() 
	{
		return taxablePay;
	}
	public String getIncomeTax()
	{
		return incomeTax;
	}
	public String getNetPay()
	{
		return netPay;
	}
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}
	public void setBasicPay(String basicPay) 
	{
		this.basicPay = basicPay;
	}
	public void setDeduction(String deduction)
	{
		this.deduction = deduction;
	}
	public void setTaxablePay(String taxablePay) 
	{
		this.taxablePay = taxablePay;
	}
	public void setIncomeTax(String incomeTax) 
	{
		this.incomeTax = incomeTax;
	}
	public void setNetPay(String netPay) 
	{
		this.netPay = netPay;
	}
	@Override
	public String toString() 
	{
		return "Payroll [employeeID=" + employeeID + ", basicPay=" + basicPay + ", deduction=" + deduction
				+ ", taxablePay=" + taxablePay + ", incomeTax=" + incomeTax + ", netPay=" + netPay + "]";
	}
	
	
}
