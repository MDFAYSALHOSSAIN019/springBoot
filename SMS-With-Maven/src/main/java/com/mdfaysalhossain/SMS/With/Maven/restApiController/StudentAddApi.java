package com.mdfaysalhossain.SMS.With.Maven.restApiController;

import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.UserModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.IStudentAddRepo;
import com.mdfaysalhossain.SMS.With.Maven.repository.IUserRepo;
import com.mdfaysalhossain.SMS.With.Maven.service.StudentAddService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentAddApi {

    long startTime;

    @Autowired
    JavaMailSender javaMailSender;

//    public StudentAddController(StudentAddService studentAddService) {
//        this.studentAddService = studentAddService;
//    }

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    public StudentAddService studentAddService;



    @Autowired
    private IStudentAddRepo iStudentAddRepo;

    @GetMapping("")
    public List<StudentAddModel> findAllStudent(){
     return studentAddService.getAllStudent();

    }
    @PostMapping("")
    public  void SaveStudent(@RequestBody StudentAddModel st){

        studentAddService.saveStudent(st);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable ("id") long id){
        boolean hasdata=iStudentAddRepo.existsById(id);
        if(hasdata){
            studentAddService.daletestudent(id);
            return new ResponseEntity<>("Data Are Delete successfully", HttpStatus.OK);
        }
        return  new ResponseEntity<>("data are not found",HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editStudent(@PathVariable("id") long id, @RequestBody StudentAddModel updatedStudent) {
        Optional<StudentAddModel> optionalStudent = studentAddService.findById(id);

        if (optionalStudent.isPresent()) {
            StudentAddModel existingStudent = optionalStudent.get();

            // Update the fields of the existing student with the new values
            existingStudent.setBatchId(updatedStudent.getBatchId());
            existingStudent.setSession(updatedStudent.getSession());
            existingStudent.setStClass(updatedStudent.getStClass());
            existingStudent.setStRoll(updatedStudent.getStRoll());
            existingStudent.setStfirstname(updatedStudent.getStfirstname());
            existingStudent.setStlastname(updatedStudent.getStlastname());
            existingStudent.setStemail(updatedStudent.getStemail());
            existingStudent.setStfathersname(updatedStudent.getStfathersname());
            existingStudent.setStmothersname(updatedStudent.getStmothersname());
            existingStudent.setStpassword(updatedStudent.getStpassword());
            existingStudent.setStdob(updatedStudent.getStdob());
            existingStudent.setStaddress(updatedStudent.getStaddress());
            existingStudent.setStgender(updatedStudent.getStgender());
            existingStudent.setStphone(updatedStudent.getStphone());
            existingStudent.setStPhoto(updatedStudent.getStPhoto());

            // Save the updated student
            studentAddService.saveStudent(existingStudent);

            return ResponseEntity.ok("Data has been updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Student with ID " + id + " not found");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id) {
        Optional<StudentAddModel> studentOptional = studentAddService.findById(id);
        return studentOptional.map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/class/{stclass}")
    public ResponseEntity<List<StudentAddModel>> viewStudentsByClass(@PathVariable String stclass) {
        List<StudentAddModel> students = studentAddService.findByClass(stclass);

        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(students);
        }
    }
}
