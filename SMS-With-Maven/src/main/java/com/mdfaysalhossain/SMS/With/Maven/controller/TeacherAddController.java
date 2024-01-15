package com.mdfaysalhossain.SMS.With.Maven.controller;


import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.TeacherAddModel;
import com.mdfaysalhossain.SMS.With.Maven.service.TeacherAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TeacherAddController {


    @Autowired
    TeacherAddService teacherAddService;

    public TeacherAddController(TeacherAddService teacherAddService) {
        this.teacherAddService = teacherAddService;
    }

    @GetMapping("/teacher/viewteacher")
    public String getAllTeacher(Model m) {

        List<TeacherAddModel> teaList = teacherAddService.getAllteacher();
        m.addAttribute("teaList", teaList);
        m.addAttribute("title", "view Teacher");
        return "teView";
    }


    @GetMapping("/teacher/teform")
    public String saveform(Model m) {
        m.addAttribute("teacherform", new TeacherAddModel());
        return "teAdd";
    }

    @PostMapping("/teacher/tesave")
    public String saveteacher(@ModelAttribute TeacherAddModel teacherAddModel) {
        teacherAddModel.setT_password("1234");
        teacherAddModel.setT_role("2");
        teacherAddService.saveteacher(teacherAddModel);
        return "redirect:/teacher/viewteacher";
    }


    @RequestMapping("/teacher/teprofile/{id}")
    public String profileteacher(@PathVariable("id") int id, Model m){

        Optional<TeacherAddModel> teacher=teacherAddService.findbyId(id);
        m.addAttribute("teacherprofile", teacher);

        return "teProfile";
    }






}
