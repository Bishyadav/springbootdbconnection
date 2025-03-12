package com.example.springbootdbconnection.controller;

import com.example.springbootdbconnection.dto.Studentdto;
import com.example.springbootdbconnection.service.StudentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
//==============================================================================================================
@RestController
public class StudentCon {
    @Autowired
    private StudentSer studentSer;
    @CrossOrigin(origins = "http://localhost:5176")
    @GetMapping("/getAllstudent")
    public List<Studentdto> getController() throws SQLException{
        return studentSer.getService();
    }
    //========================================================================================
    @CrossOrigin(origins = "http://localhost:5176")
    @GetMapping("/getById/{s_id}")
    public Studentdto getByIdController(@PathVariable("s_id") int s_id) throws SQLException {
        return studentSer.getByIdService(s_id);
    }
        //================================================================================
        @CrossOrigin(origins = "http://localhost:5176")
        @DeleteMapping("/deleteById/{s_id}")
        public void deleteByIdCon(@PathVariable("s_id") int s_id) throws SQLException {
            studentSer.deleteByIdSer(s_id);
        }

//===============================================================================================================
    @CrossOrigin(origins = "http://localhost:5176")
    @PostMapping("/addStudent")
    public void addStudentCon(@RequestBody Studentdto studentdto) throws SQLException{
        studentSer.addStudentSer(studentdto);
    }
    //==========================================================================================================
    @PutMapping("/updateStudent")
    public void updateStudentSCon(@RequestBody Studentdto studentdto) throws SQLException{
        studentSer.updateStudenteSer(studentdto);
    }
    //===========================================================================================================

    @CrossOrigin(origins = "http://localhost:5176")
    @DeleteMapping("/deleteAllRecord")
    public void deleteStudentCon()throws SQLException{
        studentSer.deleteStudentSer();
    }
}
