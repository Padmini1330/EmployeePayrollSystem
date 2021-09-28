package EmployeePayrollSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

public class EmployeePayrollServiceTest 
{
	EmployeePayrollService employeePayrollService=null; 
	
	@Before
	public void setUp() throws Exception
	{
		employeePayrollService = new EmployeePayrollService();
	}
	

	    @Test
	    public void givenFilesOnReadingFromFilesShouldMatchEmployeeCount() 
	    {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        long entries = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO).size();
	    }

	    @Test
	    public void readFromEmployeePayroll_readGivenEmployee() 
	    {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        long size = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO, "Jim").size();
	        Assert.assertEquals(1, size);
	    }

	    @Test
	    public void whenBasicPay_IsUpdated_ReturnsCorrectValues() 
	    {
	        String name = "Jim";
	        String basicPay = "300";
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        List<Employee> employeeList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO, name);
	        employeePayrollService.updatePayroll(name, basicPay);
	        boolean result = employeePayrollService.compareUpdate(name);
	        Assert.assertTrue(result);
	    }

}