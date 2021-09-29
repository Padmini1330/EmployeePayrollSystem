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
	        long entries = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO).size();
	    }

	    @Test
	    public void readFromEmployeePayroll_readGivenEmployee() 
	    {
	        long size = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO, "Ross").size();
	        System.out.println(size);
	        Assert.assertEquals(1, size);
	    }

	    @Test
	    public void whenBasicPay_IsUpdated_ReturnsCorrectValues() 
	    {
	        String name = "Jim";
	        int basicPay = 3000;
	        List<Employee> employeeList = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO, name);
	        employeePayrollService.updatePayroll(name, basicPay);
	        boolean result = employeePayrollService.compareUpdateSync(name);
	        Assert.assertTrue(result);
	    }
	    
	    @Test
	    public void givenDateRange_WhenCorrect_RetrieveEmployeesWhoJoinedInTheGivenRange() 
	    {
	        LocalDate startDate = LocalDate.of(2021, 4, 19);
	        LocalDate endDate = LocalDate.of(2021, 12, 19);
	        List<Employee> employeeList = employeePayrollService.readEmployeeJoinedInRange(startDate, endDate);
	        System.out.println(employeeList.size());
	        Assert.assertEquals(3, employeeList.size());
	    }
	    
	    @Test
	    public void givenMathFunctionSum_WhenCorrect_RetrieveTheResult() 
	    {
	        int result=employeePayrollService.getMathValueForGivenMathFunction("sum","F");
	        System.out.println(result);
	    }
	    
	    @Test
	    public void givenMathFunctionMin_WhenCorrect_RetrieveTheResult() 
	    {
	        int result=employeePayrollService.getMathValueForGivenMathFunction("min","M");
	        System.out.println(result);
	    }
	    
	    @Test
	    public void givenMathFunctionMax_WhenCorrect_RetrieveTheResult() 
	    {
	        int result=employeePayrollService.getMathValueForGivenMathFunction("max","F");
	        System.out.println(result);
	    }
	    
	    @Test
	    public void givenMathFunctionAvg_WhenCorrect_RetrieveTheResult() 
	    {
	        int result=employeePayrollService.getMathValueForGivenMathFunction("avg","M");
	        System.out.println(result);
	    }
	    
	    @Test
	    public void givenNewEmployeePayrollData_WhenCorrect_InsertToEmployeeAndPayrollTable()
	    {
	        Employee employee=new Employee(4,100,500,"padmini","F","Bangalore","9898989",LocalDate.of(2021,3,13));
	        Payroll updatedPayroll=employeePayrollService.insertEmployeePayrollValues(employee,20000);
	        boolean result = employeePayrollService.compareEmployeePayrollInsertSync(employee.getEmployeeName(),updatedPayroll);
	        Assert.assertTrue(result);
	    }
	    

	    @Test
	    public void givenNewEmployeePayrollData_WhenCorrect_InsertToEmployeeDepartmentAndPayrollTable()
	    {
	        Employee employee=new Employee(4,100,500,"padmini","F","Bangalore","9898989",LocalDate.of(2021,3,13));
	        Department department = new Department(100,"engineer");
	        employee.setDepartmentList(List.of(department));
	        Payroll updatedPayroll=employeePayrollService.insertEmployeePayrollValues(employee,20000);
	        boolean result = employeePayrollService.compareEmployeePayrollInsertSync(employee.getEmployeeName(),updatedPayroll);
	        Assert.assertTrue(result);
	    }
	    
	    @Test
	    public void givenEmployeeName_WhenProper_DeleteEmployeeBySettingIsActiveToFalse() 
	    {
	        boolean result = employeePayrollService.deleteEmployee("Ross");
	        Assert.assertFalse(result);
	    }

}