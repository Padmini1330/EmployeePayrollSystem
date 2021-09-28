package EmployeePayrollSystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService 
{
    public static String PAYROLL_FILE_NAME = "payroll-file.txt";

    public void writeData(List<Employee> employeeList) 
    {
        StringBuffer empBuffer = new StringBuffer();
        employeeList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });

        try 
        {
            Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void printData() 
    {
        try 
        {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public long countEntries() 
    {
        long entries = 0;
        try 
        {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return entries;
    }

    public List<Employee> readData() 
    {
        List<Employee> employeeList = new ArrayList<Employee>();
        try 
        {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath())
                    .map(line -> line.trim())
                    .forEach(line -> System.out.println(line));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return employeeList;
    }
    
    public Payroll updatePayroll()
    {
        Payroll updatedpayroll;
        String query="select * from Employee e,Payroll p where p.employeeID=e.employeeID and e.employeeName=\"Jim\"";
        String updateQuery="update Payroll set basicPay=3000000 where employeeID in (select employeeID from Employee where employeeName=\"Jim\")";
        try 
        {
            Connection connection=DatabaseService.getConnection();
            System.out.println("connected");
            Statement statement=connection.createStatement();
            statement.executeUpdate(updateQuery);
            ResultSet resultSet=statement.executeQuery(query);
            resultSet.next();
                updatedpayroll =new Payroll(resultSet.getInt("employeeID"), resultSet.getString("basicPay"), resultSet.getString("deduction"), resultSet.getString("taxablePay"), resultSet.getString("incomeTax"), resultSet.getString("netPay"));
            System.out.println(updatedpayroll);
        }
        catch (Exception e) 
        {
            throw new DatabaseException(e.getMessage());
        }
        return updatedpayroll;
    }

    public List<Employee> readDataFromDB() 
    {
        List<Employee> employeeList = new ArrayList<Employee>();
        String query="select * from Employee e,Payroll p where p.employeeID=e.employeeID";
        try 
        {
        	System.out.println("Worked");            
        	Connection connection=DatabaseService.getConnection();
            System.out.println("connected");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
           
            while(resultSet.next()) 
            {
                employeeList.add(new Employee(resultSet.getInt("employeeID"),resultSet.getInt("departmentID"),resultSet.getInt("companyID"), resultSet.getString("employeeName"), resultSet.getString("gender"), resultSet.getString("address"), resultSet.getString("phoneNumber"), resultSet.getString("startDate")));
            }
            System.out.println(employeeList);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return  employeeList;
    }
}