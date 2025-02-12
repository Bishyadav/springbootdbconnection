package com.example.springbootdbconnection.controller;

import com.example.springbootdbconnection.dto.Studentdto;
import com.example.springbootdbconnection.service.StudentSer;
import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
//==============================================================================================================
@RestController
public class StudentCon {
    @Autowired
    private StudentSer studentSer;
    @GetMapping("/getAllstudent")
    public List<Studentdto> getController() throws SQLException{
        return studentSer.getService();
    }
//===============================================================================================================

    @PostMapping("/addStudent")
    public void addStudentCon(@RequestBody List<Studentdto> studentdto) throws SQLException{
        studentSer.addStudentSer(studentdto);
    }
    //==========================================================================================================
    @PutMapping("/updateStudent")
    public void updateStudentSCon() throws SQLException{
        studentSer.updateStudenteSer();
    }
    //===========================================================================================================
    @DeleteMapping("/deleteAllRecord")
    public void deleteStudentCon()throws SQLException{
        studentSer.deleteStudentSer();
    }
}
