package com.mdfaysalhossain.SMS.With.Maven.controller;

import com.mdfaysalhossain.SMS.With.Maven.model.ClassRutineModel;
import com.mdfaysalhossain.SMS.With.Maven.service.ClassRutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassRutineController {

    @Autowired
    ClassRutineService classRutineService;

    public ClassRutineController(ClassRutineService classRutineService) {
        this.classRutineService = classRutineService;
    }





    @GetMapping("/rutine/viewrutine")
    public String getallclassrut(Model m) {
        List<ClassRutineModel> rutList = classRutineService.getAllrutine();
        m.addAttribute("Allstudent", rutList);
        m.addAttribute("titel", "View Class Rutine");
        return "stClassRutineView";
    }


    @GetMapping("/rutine/rutform")
    public String saveform(Model m) {
        m.addAttribute("rutform", new ClassRutineModel());
        return "stClassRutineAdd";
    }

    @PostMapping("/rutine/rutsave")
    public String saverutine(@ModelAttribute ClassRutineModel classRutineModel) {
//        classRutineModel.setT_password("1234");
//        classRutineModel.setT_role("2");
        classRutineService.saverutine(classRutineModel);
        return "redirect:/rutine/viewrutine";
    }


//    @RequestMapping("/rutine/teprofile/{id}")
//    public String profileteacher(@PathVariable("id") int id, Model m){
//
//        Optional<ClassRutineModel> rutine=classRutineService.;
//        m.addAttribute("teacherprofile", teacher);
//
//        return "teProfile";
//    }


}
