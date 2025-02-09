package com.example.springbootdbconnection.controller;
import com.example.springbootdbconnection.dto.Employeedto;
import com.example.springbootdbconnection.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/getAllEmployee")
    public List<Employeedto> getEmployee() throws SQLException {
        return myService.getEmployeeSer();
    }
    @PostMapping("/addEmployee")
    public void addEmployeeCon(@RequestBody List<Employeedto> employeedto) throws SQLException{
        myService.addEmployeeSer(employeedto);
    }
    @PutMapping("/updateEmployee")
    public void updateEmployee() throws SQLException{
        myService.updateEmployeeSer();
    }
    @DeleteMapping("/deleteAllEmployee")
    public void deleteAllEmployee() throws SQLException{
        myService.deleteAllEmployee();
    }
}
