package com.example.springbootdbconnection.repository;

import com.example.springbootdbconnection.dto.Employeedto;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.springframework.beans.factory.annotation.Value;

import java.net.StandardSocketOptions;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @Value("${spring.datasource.url}")
    private  String url;
     @Value("${spring.datasource.username}")
     private String user;
     @Value("${spring.datasource.password}")
      private String password;
    public List<Employeedto> getEmployeeRepo() throws SQLException {

       List<Employeedto> employees= new ArrayList<>(0);
        Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                Statement statement=connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");

                while (resultSet.next()) {
                    // Retrieve the "name" column value
                    Integer ids=Integer.valueOf(resultSet.getInt("id"));
                    String name = resultSet.getString("name");
                    Long salary= Long.valueOf(resultSet.getInt("sal"));
                    Employeedto emp=new Employeedto(ids,name,salary);
                    employees.add(emp);
                }

               return employees;
            } else {
                System.out.println("Failed to connect to the database.");
                return null;
            }
    }
    public void addEmployeeRepo(List<Employeedto> employeedto) throws SQLException{
        Connection connection=DriverManager.getConnection(url,user,password);
        if (connection!=null){
//            Statement statement=connection.createStatement();
//            statement.execute("INSERT INTO EMP VALUES(11,'raj',29000)");
            String query = "INSERT INTO EMP (id, name, sal) VALUES (?, ?, ?)";
            for(Employeedto emp:employeedto) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, emp.getId());
                preparedStatement.setString(2, emp.getName());
                preparedStatement.setLong(3, emp.getSalary());
                preparedStatement.executeUpdate();
            }
        }
        else {
            System.out.println("DataBase connection is Not Found");
        }
    }
    public void updateEmployeeRepo() throws SQLException{
        Connection connection=DriverManager.getConnection(url,user,password);
        if(connection!=null) {
            Statement statement = connection.createStatement();
             statement.execute("UPDATE EMP SET NAME='TEJASH' WHERE ID=103");
        }
        else {
            System.out.println("DataBase Connection is not found");
        }
    }
    public void deleteAllEmployeeRepo() throws SQLException{
        Connection connection=DriverManager.getConnection(url,user,password);
        if (connection!=null){
            Statement statement=connection.createStatement();
            statement.execute("TRUNCATE TABLE EMP");
        }
        else {
            System.out.println("DataBase connection is not found");
        }
    }
}

