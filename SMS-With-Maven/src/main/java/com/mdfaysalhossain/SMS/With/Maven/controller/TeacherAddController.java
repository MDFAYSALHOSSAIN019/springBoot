package com.mdfaysalhossain.SMS.With.Maven.controller;


import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.TeacherAddModel;
import com.mdfaysalhossain.SMS.With.Maven.service.TeacherAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class TeacherAddController {


    @Autowired
    TeacherAddService teacherAddService;

    public TeacherAddController(TeacherAddService teacherAddService) {
        this.teacherAddService = teacherAddService;
    }

    @GetMapping("/teacher/viewteracher")
    public String getAllTeacher(Model m){

        List<TeacherAddModel> teaList=teacherAddService.getAllteacher();
        m.addAttribute("teaList",teaList);
        m.addAttribute("title","view Teacher");
        return "teView";
    }


    @GetMapping("/teacher/teform")
    public String saveform(Model m) {
        m.addAttribute("teacherform",new TeacherAddModel());
        return "teAdd";
    }

    @PostMapping("/teacher/tesave")
    public String saveteacher(@ModelAttribute TeacherAddModel teacherAddModel) {
        teacherAddModel.setT_password("1234");
        teacherAddModel.setT_role("2");
       teacherAddService.saveteacher(teacherAddModel);
        return "redirect:/teacher/viewteracher";
    }



//    @GetMapping("/teacher/teprofile")
//    public String studentProfile(@PathVariable("id") int studentId, Model model) {
//        // Retrieve the student by ID from the service or repository
//        Optional<StudentAddModel> studentprofile = studentAddService.findById(studentId);
//
//        // Check if the student is found
//        if (studentprofile != null) {
//            model.addAttribute("studentProfile", studentprofile);
//            model.addAttribute("title", "View Student Profile");
//            return "stProfile";
//        } else {
//            // Handle case where student with the given ID is not found
//            // You might want to redirect to an error page or handle it differently
//            return "studentNotFound";
//        }
//    }






}
