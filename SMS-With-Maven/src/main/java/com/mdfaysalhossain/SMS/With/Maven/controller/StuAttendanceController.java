package com.mdfaysalhossain.SMS.With.Maven.controller;

import com.mdfaysalhossain.SMS.With.Maven.model.StuAttendanceModel;
import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.TeacherAddModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.IStudentAddRepo;
import com.mdfaysalhossain.SMS.With.Maven.repository.StuAttendanceRepo;
import com.mdfaysalhossain.SMS.With.Maven.service.StuAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StuAttendanceController {

    @Autowired
    public StuAttendanceRepo stuAttendanceRepo;

    @Autowired
    public StuAttendanceService stuAttendanceService;

    @Autowired
    public IStudentAddRepo iStudentAddRepo;


//    @GetMapping("/student/attview")
//    public String getAttClass(String a_class, Model m){
//        List<StuAttendanceModel> attList=stuAttendanceRepo.findByA_Class(a_class);
//        m.addAttribute("attList" ,attList);
//
//
//
//        return "stAttendanceView";
//    }


    @GetMapping("/student/attform")
    public String attform(Model m){
        List<StudentAddModel> studentList=iStudentAddRepo.findAll();
        m.addAttribute("student",new StudentAddModel());

        m.addAttribute("studentList",studentList);

        m.addAttribute("Attendance",new StuAttendanceModel());

        return "stAttendanceAdd";
    }




}
