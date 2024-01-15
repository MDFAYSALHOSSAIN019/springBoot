package com.mdfaysalhossain.SMS.With.Maven.controller;

import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.service.StudentAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentAddController {

    @Autowired
    public StudentAddService studentAddService;



    public StudentAddController(StudentAddService studentAddService) {
        this.studentAddService = studentAddService;
    }

    @GetMapping("/student/stviewall")
    public String getallstudent(Model m) {
        List<StudentAddModel> stuList = studentAddService.getAllStudent();
        m.addAttribute("Allstudent", stuList);
        m.addAttribute("titel", "View Student");
        return "stView";
    }



    @GetMapping("/student/stform")
    public String saveform(Model m) {
        m.addAttribute("studentform", new StudentAddModel());
        return "stAdd";
    }

    @PostMapping("/student/stsave")
    public String savestudent(@ModelAttribute StudentAddModel studentAddModel) {


        studentAddModel.setStpassword("1234");
        studentAddModel.setStrole("3");
        studentAddService.saveStudent(studentAddModel);
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

    @RequestMapping("/student/stprofile/{id}")
    public String profilestudent(@PathVariable("id") int id, Model m){

        Optional<StudentAddModel> student=studentAddService.findById(id);
        m.addAttribute("studentprofile", student);

        return "stProfile";
    }


    @GetMapping("/student/view/{class}")
    public String viewStudentsByClass(@PathVariable String stclass, Model model) {
        List<StudentAddModel> students = studentAddService.findByClass(stclass);
        model.addAttribute("Allstudent", students);
        return "redirect:/student/stviewall"; // Replace with the actual view name
    }

}
