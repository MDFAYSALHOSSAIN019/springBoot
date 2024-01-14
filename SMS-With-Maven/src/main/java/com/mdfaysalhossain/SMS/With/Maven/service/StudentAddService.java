package com.mdfaysalhossain.SMS.With.Maven.service;

import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.IStudentAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddService {

@Autowired
IStudentAddRepo studentAddRepo;

    @Autowired
    public StudentAddService(IStudentAddRepo studentAddRepo) {
        this.studentAddRepo = studentAddRepo;
    }



    public List<StudentAddModel> getAllStudent(){
        return studentAddRepo.findAll();
    }

    public void saveStudent(StudentAddModel st){
       studentAddRepo.save(st);
    }

    public void daletestudent(int id){
        studentAddRepo.deleteById(id);
    }

    public Optional<StudentAddModel> findById(int id){
        return studentAddRepo.findById(id);
    }




}
