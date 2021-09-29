package EmployeePayrollSystem;

public class Payroll 
{
	public int employeeID;
	public int basicPay;
	public int deduction;
	public int taxablePay;
	public int incomeTax;
	public int netPay;
	
	
	public Payroll(int employeeID, int basicPay, int deduction, int taxablePay, int incomeTax,
			int netPay) 
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
	public int getBasicPay()
	{
		return basicPay;
	}
	public int getDeduction()
	{
		return deduction;
	}
	public int getTaxablePay() 
	{
		return taxablePay;
	}
	public int getIncomeTax()
	{
		return incomeTax;
	}
	public int getNetPay()
	{
		return netPay;
	}
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}
	public void setBasicPay(int basicPay) 
	{
		this.basicPay = basicPay;
	}
	public void setDeduction(int deduction)
	{
		this.deduction = deduction;
	}
	public void setTaxablePay(int taxablePay) 
	{
		this.taxablePay = taxablePay;
	}
	public void setIncomeTax(int incomeTax) 
	{
		this.incomeTax = incomeTax;
	}
	public void setNetPay(int netPay) 
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
