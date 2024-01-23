package com.mdfaysalhossain.SMS.With.Maven.service;

import com.mdfaysalhossain.SMS.With.Maven.model.StuAttendanceModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.StuAttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuAttendanceService {

    @Autowired
    StuAttendanceRepo stuAttendanceRepo;

//    public List<StuAttendanceModel> getAttendanceByClasss(String a_class){
//        return stuAttendanceRepo.findByA_Class(a_class);
//    }


    public StuAttendanceModel saveAttendance(StuAttendanceModel att){
        return stuAttendanceRepo.save(att);
    }


    public void deleteAttendance(int id){
        stuAttendanceRepo.deleteById(id);
    }

    public void getById(int aid){
      stuAttendanceRepo.findById(aid);
    }


    public List<StuAttendanceModel> getAttendanceByClass(String aclass) {
        return stuAttendanceRepo.findByAClass(aclass);
    }

}
