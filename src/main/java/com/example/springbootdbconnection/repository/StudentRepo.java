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
                Integer s_ids=Integer.valueOf(resultSet.getInt("s_id"));
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
    //===============================================================================================================
    //Add data in table using
    public void addStudentRepo(List<Studentdto> studentdto) throws SQLException{
            Connection connection=DriverManager.getConnection(url,user,password);
            if (connection!=null){

                String query = "INSERT INTO student (s_id, s_name, s_address) VALUES (?, ?, ?)";
                for(Studentdto st:studentdto) {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, st.getId());
                    preparedStatement.setString(2, st.getName());
                    preparedStatement.setString(3, st.getAddress());
                    preparedStatement.execute();
                }
            }
            else {
                System.out.println("DataBase connection is Not Found");
            }
        }
        //=====================================================================================================
        public void updateStudentRepo() throws SQLException{
            Connection connection=DriverManager.getConnection(url,user,password);
            if(connection!=null) {
                Statement statement = connection.createStatement();
                statement.execute("UPDATE student SET s_name='TEJASH',s_address='orkhar' WHERE s_ID=0");
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
    }
