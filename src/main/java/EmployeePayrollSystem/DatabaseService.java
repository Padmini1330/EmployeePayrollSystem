package EmployeePayrollSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseService 
{
       
	private PreparedStatement preparedStatement;
    private PreparedStatement updatePayrollStatement;
    private static DatabaseService employeePayrollDBService;
    private PreparedStatement employeeJoinedDate;
    private PreparedStatement mathFunctionStatement;
    List<Employee> employeeList;

    private DatabaseService() 
    {

    }

    public static DatabaseService getDBServiceInstance() 
    {
        if (employeePayrollDBService == null)
            employeePayrollDBService = new DatabaseService();
        return employeePayrollDBService;
    }

    public static Connection getConnection() throws SQLException 
    {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/AddressBookService?useSSL=false";
		String userName = "root";
		String password = "Padmini_1330";
		Connection connection;
		
		System.out.println("Connecting to the database : "+jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("Connection is Succcessfully Established!! "+connection);
		
		return connection;
	}


    public List<Employee> readEmployeeDataFromDB(String name)
    {
        if (preparedStatement == null)
        {
            this.preparedStatementToReadEmployeeData();
        }
        try 
        {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            employeeList = this.getCompleteEmployeeDataList(resultSet);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employeeList;
    }

    private List<Employee> getCompleteEmployeeDataList(ResultSet resultSet)
    {
    	employeeList = new ArrayList<>();
        try 
        {
            while (resultSet.next()) 
            {
                employeeList.add(new Employee(resultSet.getInt("employeeID"),
                		resultSet.getInt("departmentID"),
                		resultSet.getInt("companyID"), 
                		resultSet.getString("employeeName"), 
                		resultSet.getString("gender"), 
                		resultSet.getString("address"), 
                		resultSet.getString("phoneNumber"), 
                		resultSet.getDate("startDate").toLocalDate() ,
                		new Payroll(resultSet.getInt("employeeID"), 
                				resultSet.getString("basicPay"), 
                				resultSet.getString("deduction"), 
                				resultSet.getString("taxablePay"), 
                				resultSet.getString("incomeTax"), 
                				resultSet.getString("netPay")), 
                				new Company(resultSet.getInt("companyID"), 
                						resultSet.getString("companyName"))));
          
            }
        } 
        catch (Exception e) 
        {
            throw new DatabaseException(e.getMessage());
        }
        return employeeList;
    }

    private List<Employee> getEmployeeDataList(ResultSet resultSet) 
    {
    	employeeList = new ArrayList<>();
        try 
        {
            while (resultSet.next()) 
            {
            	employeeList.add(new Employee(
            			resultSet.getInt("employeeID"), 
            			resultSet.getInt("departmentID"), 
            			resultSet.getInt("customerID"), 
            			resultSet.getString("employeeName"), 
            			resultSet.getString("gender"), 
            			resultSet.getString("address"),
            			resultSet.getString("phoneNumber"),
            			resultSet.getDate("startDate").toLocalDate()));
            }
        } 
        catch (Exception e) 
        {
            throw new DatabaseException(e.getMessage());
        }
        return employeeList;
    }


    private void preparedStatementToReadEmployeeData()
    {
        try (Connection connection = this.getConnection()) 
        {
            String query = "select * from Employee e, Payroll p,Company c where e.employeeID=p.employeeID and e.companyID=c.companyID and employeeName= ?";
            preparedStatement = connection.prepareStatement(query);
        } 
        catch (Exception e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void preparedStatementToUpdatePayroll()
    {
        try 
        {
            Connection connection = this.getConnection();
            String updateQuery = "update Payroll set basicPay=? where employeeID in (select employeeID from employee where employeeName=?)";
            updatePayrollStatement = connection.prepareStatement(updateQuery);
        } 
        catch (Exception e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void preparedStatementToRetriveEmployeeInRange()
    {
        try 
        {
            Connection connection = this.getConnection();
            String query = "select * from Employee where startDate between ? and ?";
            employeeJoinedDate = connection.prepareStatement(query);
            
        } catch (Exception e) 
        {
        	
            throw new DatabaseException(e.getMessage());
        }
    }

    public void updatePayroll(String name, String basicPay)
    {
        if (updatePayrollStatement == null)
        {
            this.preparedStatementToUpdatePayroll();
        }
        try
        {
            updatePayrollStatement.setString(1, basicPay);
            updatePayrollStatement.setString(2, name);
            updatePayrollStatement.executeUpdate();
        } 
        catch (Exception e)
        {

            throw new DatabaseException(e.getMessage());
        }
    }


    public List<Employee> readEmployedJoinedRange(Date startDate, Date endDate) 
    {
        if (employeeJoinedDate == null) 
        {
            this.preparedStatementToRetriveEmployeeInRange();
        }
        try 
        {
            employeeJoinedDate.setDate(1, startDate);
            employeeJoinedDate.setDate(2, endDate);
            ResultSet resultSet = employeeJoinedDate.executeQuery();
            System.out.println(resultSet+"hi");
            return this.getEmployeeDataList(resultSet);
        } 
        catch (Exception e) 
        {
            throw new DatabaseException(e.getMessage());
        }
    }
    
    public void preparedStatementForMathFunctionStatement(String functionName) 
    {
        try 
        {
            Connection connection = this.getConnection();
            String sum = "SELECT sum(netPay) as result from Employee e,Payroll p where e.employeeID=p.employeeID and gender=? GROUP BY gender";
            String avg = "SELECT avg(netPay) as result from Employee e,Payroll p where e.employeeID=p.employeeID and gender=? GROUP BY gender";
            String min = "SELECT min(netPay) as result from Employee e,Payroll p where e.employeeID=p.employeeID and gender=? GROUP BY gender";
            String max = "SELECT max(netPay) as result from Employee e,Payroll p where e.employeeID=p.employeeID and gender=? GROUP BY gender";
            String count = "select count(*) as result from Employee e where gender=? group by gender";
            HashMap<String, String> functionMap = new HashMap<>();
            functionMap.put("sum", sum);
            functionMap.put("avg", avg);
            functionMap.put("min", min);
            functionMap.put("max", max);
            functionMap.put("count", count);
            mathFunctionStatement = connection.prepareStatement(functionMap.get(functionName));
        } 
        catch (Exception e) 
        {
            throw new DatabaseException(e.getMessage());
        }
    }

    public double getMathValueForGivenMathFunction(String function, String gender) 
    {
        this.preparedStatementForMathFunctionStatement(function);
        try 
        {
            mathFunctionStatement.setString(1, gender);
            ResultSet resultSet = mathFunctionStatement.executeQuery();
            resultSet.next();
            return resultSet.getDouble("result");
        } 
        catch (Exception e) 
        {
            throw new DatabaseException(e.getMessage());
        }
    }
}
