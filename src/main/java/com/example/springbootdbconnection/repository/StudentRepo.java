package com.example.springbootdbconnection.repository;

import com.example.springbootdbconnection.dto.Employeedto;
import com.example.springbootdbconnection.dto.Studentdto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    @Value("${spring.datasource.url}")
    private  String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    //=============================================================================================================
    public List<Studentdto> getRepository() throws SQLException{
        List<Studentdto> listrepo=new ArrayList<>(0);
       Connection con= DriverManager.getConnection(url,user,password);
        if(con!=null){
            Statement statement=con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()){
                Integer s_ids= resultSet.getInt("s_id");
                String s_name = resultSet.getString("s_name");
                String s_address=resultSet.getString("s_address");
                Studentdto studentdto=new Studentdto(s_ids,s_name,s_address);
                listrepo.add(studentdto);
            }
        return listrepo;
        }
        else {
            System.out.println("Student Details not found");
            return null;
        }

    }
    //==========================================================================
    public Studentdto getByIdRepository(int s_id) throws SQLException {
        Studentdto student = null;
        String query = "SELECT * FROM student WHERE s_id = ?";

        // Use try-with-resources to manage resources automatically
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            // Set the parameter value for the query
            preparedStatement.setInt(1, s_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve data from the result set
                    int id = resultSet.getInt("s_id");
                    String s_name = resultSet.getString("s_name");
                    String s_address = resultSet.getString("s_address");

                    // Initialize and return the Studentdto object
                    student = new Studentdto(s_id, s_name, s_address);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching student details: " + e.getMessage());
        }

        return student;
    }

    //===============================================================================================================
    //Add data in table using
    public void addStudentRepo(Studentdto studentdto) throws SQLException{
            Connection connection=DriverManager.getConnection(url,user,password);
            if (connection!=null) {

                String query = "INSERT INTO student (s_id, s_name, s_address) VALUES (?, ?, ?)";
                //for (Studentdto st : studentdto) {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, studentdto.getId());
                    preparedStatement.setString(2, studentdto.getName());
                    preparedStatement.setString(3, studentdto.getAddress());
                    preparedStatement.execute();
            }
            else {
                System.out.println("DataBase connection is Not Found");
            }
        }
        //=====================================================================================================
        public void updateStudentRepo(Studentdto studentdto) throws SQLException{
            Connection connection=DriverManager.getConnection(url,user,password);
            if(connection!=null) {
                //Statement statement = connection.createStatement();
                //statement.execute("UPDATE student SET s_name=?,s_address=? WHERE s_id=?");
                PreparedStatement preparedStatement=connection.prepareStatement("UPDATE student SET s_name=?,s_address=? WHERE s_id=?");

                preparedStatement.setString(1, studentdto.getName());
                preparedStatement.setString(2, studentdto.getAddress());
                preparedStatement.setInt(3, studentdto.getId());
                preparedStatement.execute();
            }
            else {
                System.out.println("DataBase Connection is not found");
            }
        }
        //=======================================================================================================
    public void deleteStudentRepo() throws SQLException{
        Connection connection=DriverManager.getConnection(url,user,password);
        if (connection!=null){
             Statement statement=connection.createStatement();
             statement.execute("delete from student");
        }
        else {
            System.out.println("Data of student is not exist in table");
        }
    }
    //===============================================================================
    public void deleteByIdRepo(int s_id) throws SQLException{
        Connection connection=DriverManager.getConnection(url,user,password);
        if (connection!=null){
            Statement statement=connection.createStatement();
            //statement.execute("delete from student where id=?");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where s_id=?");
            preparedStatement.setInt(1,s_id);
            preparedStatement.execute();

        }
        else {
            System.out.println("Data of student is not exist in table");
        }
    }
    }
