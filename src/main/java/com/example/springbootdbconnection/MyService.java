package com.example.springbootdbconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MyService {
    @Autowired
    private Repository repository;
    public String getEmployeeSer() throws SQLException {
        return repository.getEmployeeRepo();
    }
    public void addEmployeeSer() throws SQLException{
        repository.addEmployeeRepo();
    }
    public void updateEmployeeSer() throws SQLException{
        repository.updateEmployeeRepo();
    }
    public void deleteAllEmployee() throws SQLException{
        repository.deleteAllEmployeeRepo();
    }
}
