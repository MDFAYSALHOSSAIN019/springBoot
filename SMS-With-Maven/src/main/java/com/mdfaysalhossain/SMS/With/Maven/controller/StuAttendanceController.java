package com.mdfaysalhossain.SMS.With.Maven.controller;

<<<<<<< HEAD
=======
import com.mdfaysalhossain.SMS.With.Maven.model.ResultAddModel;
>>>>>>> 0906a4eff5597bba66ed8fe9420b105173125ff0
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
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 0906a4eff5597bba66ed8fe9420b105173125ff0

import java.util.List;

@Controller
public class StuAttendanceController {

    @Autowired
    public StuAttendanceRepo stuAttendanceRepo;

    @Autowired
    public StuAttendanceService stuAttendanceService;

    @Autowired
    public IStudentAddRepo iStudentAddRepo;

<<<<<<< HEAD

//    @GetMapping("/student/attview")
=======
    public StuAttendanceController(StuAttendanceRepo stuAttendanceRepo) {
        this.stuAttendanceRepo = stuAttendanceRepo;
    }

    //    @GetMapping("/student/attview")
>>>>>>> 0906a4eff5597bba66ed8fe9420b105173125ff0
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

<<<<<<< HEAD

=======
    @GetMapping("/student/attenviewbyclass/{aclass}")
    public String getAttenByClass(@PathVariable(name = "aclass", required = false) String aclass, Model model) {
        // Log the received rclass
        System.out.println("Received aclass: " + aclass);

        List<StudentAddModel> studentAtttList = iStudentAddRepo.findByStClass(aclass);

        // Log the resultList to see if it contains data
        System.out.println("AttenList size: " + studentAtttList.size());

        model.addAttribute("studentAtttList", studentAtttList);
        model.addAttribute("titel", "View result");

        model.addAttribute("selectedClass", aclass);
        return "stAttendanceAdd";
    }


    @GetMapping("/student/attenviewss")

    private String views(){

        return "stAttendanceView";
    }
>>>>>>> 0906a4eff5597bba66ed8fe9420b105173125ff0


}
