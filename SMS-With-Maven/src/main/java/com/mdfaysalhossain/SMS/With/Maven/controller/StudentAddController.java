package com.mdfaysalhossain.SMS.With.Maven.controller;

import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.service.StudentAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentAddController {

    @Autowired
    public StudentAddService studentAddService;

    long startTime;

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

    @GetMapping("/student/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("sid") int id) throws IOException {
        Optional<StudentAddModel> userOptional = studentAddService.findById(id);

        if (userOptional.isPresent()) {
            StudentAddModel student = userOptional.get();

            // Assuming user.getImage() contains the file name
            String uploadDirectory = "src/main/resources/static/assets/imagess/student/";
            String fileName =student.getStPhoto();
            String filePath = Paths.get(uploadDirectory, fileName).toString();

            try {
                Path path = Paths.get(filePath);
                byte[] imageBytes = Files.readAllBytes(path);

                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + path.getFileName().toString())
                        .body(imageBytes);
            } catch (IOException e) {
                // Handle exceptions, log, or return an error response
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/student/stform")
    public String saveform(Model m ) {
        m.addAttribute("studentform", new StudentAddModel());
        return "stAdd";
    }

    @PostMapping("/student/stsave")
    public String savestudent(@ModelAttribute @Validated StudentAddModel studentAddModel, BindingResult result, @RequestParam("stPhoto") MultipartFile image) throws IOException, SQLException{

        long s=System.currentTimeMillis();
        startTime =s+20l;

        if (!image.isEmpty()) {
            byte[] bytes = image.getBytes();
            String originalFilename = image.getOriginalFilename();

            // Generate a timestamp to make the filename unique
            long timestamp = System.currentTimeMillis();

            // Extract file extension from the original filename
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

            // Create a new unique filename using timestamp
            String newFileName = "student_image_" + timestamp + fileExtension;

            studentAddModel.setStPhoto(newFileName);

            // Save the image to the specified directory
            String uploadDirectory = "src/main/resources/static/assets/imagess/student/";
            Path uploadPath = Paths.get(uploadDirectory);

            // Create the directory if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(newFileName);
            Files.write(filePath, bytes);
        }


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


    @GetMapping("/student/view/{stclass}")
    public String viewStudentsByClass(@PathVariable String stclass, Model model) {
        List<StudentAddModel> students = studentAddService.findByClass(stclass);
        model.addAttribute("Allstudent", students);
        return "redirect:/student/stviewall"; // Replace with the actual view name
    }



    @RequestMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentAddService.daletestudent(id);
        return "redirect:/student/stviewall";
    }

    @RequestMapping("/student/editstudent/{id}")
    public String editstudent(@PathVariable("id") int id, Model m) {
        Optional<StudentAddModel> student = studentAddService.findById(id);
        m.addAttribute("studentedit", student);
        return "edituser";
    }

}
