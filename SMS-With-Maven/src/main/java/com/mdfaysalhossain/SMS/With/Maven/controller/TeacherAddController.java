package com.mdfaysalhossain.SMS.With.Maven.controller;


import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.TeacherAddModel;
import com.mdfaysalhossain.SMS.With.Maven.service.TeacherAddService;
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
public class TeacherAddController {


    @Autowired
    TeacherAddService teacherAddService;

    long startTime;

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


    @GetMapping("/teacher/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("tid") int id) throws IOException {
        Optional<TeacherAddModel> userOptional = teacherAddService.findbyId(id);

        if (userOptional.isPresent()) {
            TeacherAddModel teacher = userOptional.get();

            // Assuming user.getImage() contains the file name
            String uploadDirectory = "src/main/resources/static/assets/imagess/teacher/";
            String fileName =teacher.getTphoto();
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

    @PostMapping("/teacher/tesave")
    public String saveteacher(@ModelAttribute @Validated TeacherAddModel teacherAddModel, BindingResult result, @RequestParam("tphoto") MultipartFile image) throws IOException, SQLException {

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
            String newFileName = "teacher_image_" + timestamp + fileExtension;

            teacherAddModel.setTphoto(newFileName);

            // Save the image to the specified directory
            String uploadDirectory = "src/main/resources/static/assets/imagess/teacher/";
            Path uploadPath = Paths.get(uploadDirectory);

            // Create the directory if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(newFileName);
            Files.write(filePath, bytes);
        }

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

    @RequestMapping("/teacher/delete/{id}")
    public String deleteteacher(@PathVariable("id") int id) {
        teacherAddService.deletebyid(id);
        return "redirect:/teacher/viewteacher";
    }




}
