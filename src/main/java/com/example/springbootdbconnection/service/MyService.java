package com.example.springbootdbconnection.service;

import com.example.springbootdbconnection.dto.Employeedto;
import com.example.springbootdbconnection.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MyService {
    @Autowired
    private Repository repository;
    public List<Employeedto> getEmployeeSer() throws SQLException {
        return repository.getEmployeeRepo();
    }
    //============================================================================================================
    public void addEmployeeSer(List<Employeedto> employeedto) throws SQLException{
        repository.addEmployeeRepo(employeedto);
    }
    //==============================================================================================================
    public void updateEmployeeSer() throws SQLException{
        repository.updateEmployeeRepo();
    }
    //=================================================================================================================
    public void deleteAllEmployee() throws SQLException{
        repository.deleteAllEmployeeRepo();
    }
}
