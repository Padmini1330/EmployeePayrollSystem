package EmployeePayrollSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
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
	        long size = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO, "Ross").size();
	        System.out.println(size);
	        Assert.assertEquals(1, size);
	    }

	    @Test
	    public void whenBasicPay_IsUpdated_ReturnsCorrectValues() 
	    {
	        String name = "Jim";
	        String basicPay = "3000";
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        List<Employee> employeeList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO, name);
	        employeePayrollService.updatePayroll(name, basicPay);
	        boolean result = employeePayrollService.compareUpdateSync(name);
	        Assert.assertTrue(result);
	    }
	    
	    @Test
	    public void givenDateRange_WhenCorrect_RetrieveEmployeesWhoJoinedInTheGivenRange() 
	    {
	        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
	        LocalDate startDate = LocalDate.of(2021, 4, 19);
	        LocalDate endDate = LocalDate.of(2021, 12, 19);
	        List<Employee> employeeList = employeePayrollService.readEmployeeJoinedInRange(startDate, endDate);
	        System.out.println(employeeList.size());
	        Assert.assertEquals(3, employeeList.size());
	    }

}