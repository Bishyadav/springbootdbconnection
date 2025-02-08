package com.example.springbootdbconnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/getAllEmployee")
    public String getEmployee() throws SQLException {
        return myService.getEmployeeSer();
    }
    @PostMapping("/addEmployee")
    public void addEmployeeCon() throws SQLException{
        myService.addEmployeeSer();
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
