package com.mdfaysalhossain.SMS.With.Maven.controller;


import com.mdfaysalhossain.SMS.With.Maven.model.ResultAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.service.ResultService;
import com.mdfaysalhossain.SMS.With.Maven.service.StudentAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ResultController {

    @Autowired
    public ResultService resultService;

    public ResultController(ResultService resultService) {

        this.resultService = resultService;
    }





    @GetMapping("/result/resviewall")
    public String getallresult(Model m) {
        List<ResultAddModel> resList = resultService.getAllResult();
        m.addAttribute("resultList", resList);
        m.addAttribute("titel", "View result");
        return "stResultView";
    }



    @GetMapping("/result/resform")
    public String saveform(Model m) {
        m.addAttribute("resultform", new ResultAddModel() );
        return "stResultAdd";
    }

    @PostMapping("/result/ressave")
    public String saveresult(@ModelAttribute ResultAddModel resultAddModel) {
//
//        int totalMarks = resultAddModel.gettotalmark();
//        resultAddModel.setR_totalmark(totalMarks);

        resultService.saveresult(resultAddModel);
    return "redirect:/student/stviewall";
    }

//    @GetMapping("/student/stprofile")
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

//    @RequestMapping("/student/stprofile/{id}")
//    public String profilestudent(@PathVariable("id") int id, Model m){
//
//        Optional<StudentAddModel> student=studentAddService.findById(id);
//        m.addAttribute("studentprofile", student);
//
//        return "stProfile";
//    }
//
//
//    @GetMapping("/student/view/{stclass}")
//    public String viewStudentsByClass(@PathVariable String stclass, Model model) {
//        List<StudentAddModel> students = studentAddService.findByClass(stclass);
//        model.addAttribute("Allstudent", students);
//        return "redirect:/student/stviewall"; // Replace with the actual view name
//    }




}
