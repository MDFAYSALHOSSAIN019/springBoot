package com.mdfaysalhossain.SMS.With.Maven.restApiController;

import com.mdfaysalhossain.SMS.With.Maven.model.ExamRutineModel;
import com.mdfaysalhossain.SMS.With.Maven.model.SubjectModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.ExamRutineRepo;
import com.mdfaysalhossain.SMS.With.Maven.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examrutine")
@CrossOrigin("*")
public class ExamRutineApi {

    @Autowired
    private ExamRutineRepo examRutineRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @GetMapping("")
    public List<ExamRutineModel> getallExam() {
        return examRutineRepo.findAll();
    }

    @PostMapping("")
    public ExamRutineModel saveExamRutine(@RequestBody ExamRutineModel examRutineModel) {

        List<SubjectModel> subjectList = subjectRepo.findAll();

        return examRutineRepo.save(examRutineModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExamRutine(@PathVariable("id") long id) {
        boolean hasData = examRutineRepo.existsById(id);
        if (hasData) {
            examRutineRepo.deleteById(id);
            return new ResponseEntity<>("Data Are Delete successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Data are not found", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> editExamRutine(@PathVariable("id") long id, @RequestBody ExamRutineModel updatedExamRutine) {
        Optional<ExamRutineModel> optionalExamRutine = examRutineRepo.findById(id);

        if (optionalExamRutine.isPresent()) {
            ExamRutineModel existingExamRutine = optionalExamRutine.get();

            // Update the fields of the existing exam routine with the new values
            existingExamRutine.setExClass(updatedExamRutine.getExClass());
            existingExamRutine.setExSubject(updatedExamRutine.getExSubject());
            existingExamRutine.setExdate(updatedExamRutine.getExdate());
            existingExamRutine.setExTime(updatedExamRutine.getExTime());

            // Save the updated exam routine
            examRutineRepo.save(existingExamRutine);

            return ResponseEntity.ok("Exam routine updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Exam routine with ID " + id + " not found");
        }
    }

}
