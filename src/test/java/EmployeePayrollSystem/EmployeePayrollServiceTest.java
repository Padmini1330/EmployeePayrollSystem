package EmployeePayrollSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;

public class EmployeePayrollServiceTest 
{
	EmployeePayrollService employeePayrollService=null; 
	
	@Before
	public void setUp() throws Exception
	{
		employeePayrollService = new EmployeePayrollService();
	}
	
    @Test
    public void givenFilesOnReading_ShouldMatchEmployeeCount() 
    {
        long entries = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
    }

    @Test
    public void whenReadFromEmployeePayroll_ShouldReturnProperRecordSize() 
    {
        long size = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        Assert.assertEquals(3, size);
    }
    
    @Test
    public void WhenEmployeePayroll_isUpdated_ShouldReturnProperValues() 
    {
        try 
        {
            Payroll actualPayroll = employeePayrollService.updatePayroll();
            Payroll expectedPayroll = new Payroll(1, "3000000","3000","1000" ,"500" ,"25000");
            Assert.assertEquals(expectedPayroll.toString(), actualPayroll.toString());
        } 
        catch (DatabaseException e) 
        {
            e.printStackTrace();
        }
    }

}