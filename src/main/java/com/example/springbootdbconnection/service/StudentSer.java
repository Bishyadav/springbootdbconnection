package com.example.springbootdbconnection.service;

import com.example.springbootdbconnection.dto.Studentdto;
import com.example.springbootdbconnection.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
    //===========================================================================================================
@Service
public class StudentSer {
    @Autowired
    private StudentRepo studentRepo;
    public List<Studentdto> getService() throws SQLException{
        return studentRepo.getRepository();
    }
    //=========================================================
    public Studentdto getByIdService(int s_id) throws SQLException {
        return studentRepo.getByIdRepository(s_id);
    }
    //===========================================================================================================
    public void addStudentSer(Studentdto studentdto) throws SQLException{
        studentRepo.addStudentRepo(studentdto);
    }
    //===========================================================================================================
    public void updateStudenteSer(Studentdto studentdto) throws  SQLException{
        studentRepo.updateStudentRepo(studentdto);
    }
    //==========================================================================================================
        public void deleteByIdSer(int s_id) throws SQLException{
        studentRepo.deleteByIdRepo(s_id);
        }
        //================================================================================
        public void deleteStudentSer() throws SQLException{
        studentRepo.deleteStudentRepo();
        }
}
