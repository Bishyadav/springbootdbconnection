package com.example.springbootdbconnection;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.springframework.beans.factory.annotation.Value;

import java.net.StandardSocketOptions;
import java.sql.*;

@org.springframework.stereotype.Repository
public class Repository {
    @Value("${spring.datasource.url}")
    private  String url;
     @Value("${spring.datasource.username}")
     private String user;
     @Value("${spring.datasource.password}")
      private String password;
    public String getEmployeeRepo() throws SQLException {

       StringBuffer result= new StringBuffer();
        Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                Statement statement=connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");

                StringBuilder names = new StringBuilder();
                while (resultSet.next()) {
                    // Retrieve the "name" column value
                    Integer ids=Integer.valueOf(resultSet.getInt("id"));
                    String name = resultSet.getString("name");
                    Long salary= Long.valueOf(resultSet.getInt("sal"));

                    names.append(ids).append("  ").append(name).append("  ").append(salary).append("\n"); // Append names to a StringBuilder
                }
               // boolean res=statement.execute(resultSet.toString());
                //ResultSet rs=statement.getResultSet();
               return String.valueOf(names);
            } else {
                System.out.println("Failed to connect to the database.");
                return "failed to connect";
            }
    }
    public void addEmployeeRepo() throws SQLException{
        Connection connection=DriverManager.getConnection(url,user,password);
        if (connection!=null){
            Statement statement=connection.createStatement();
            statement.execute("INSERT INTO EMP VALUES(11,'raj',29000)");
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

