package com.mdfaysalhossain.SMS.With.Maven.restApiController;


import com.mdfaysalhossain.SMS.With.Maven.model.ResultAddModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.IResultRepo;
import com.mdfaysalhossain.SMS.With.Maven.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultApi {


    @Autowired
    private IResultRepo resultRepo;

    @Autowired
    private ResultService resultService;

    @GetMapping("")
    public List<ResultAddModel> findAllResult() {
        return resultService.getAllResult();
    }

    @PostMapping("")
    public ResponseEntity<String> saveResult(@RequestBody ResultAddModel result) {
        resultService.saveresult(result);
        return ResponseEntity.ok("Result saved successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable("id") long id) {
        if (resultRepo.existsById(id)) {
           resultService.daleteresult(id);
            return ResponseEntity.ok("Result deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Result with ID " + id + " not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editResult(@PathVariable("id") long id, @RequestBody ResultAddModel updatedResult) {
        Optional<ResultAddModel> optionalResult = resultService.findById(id);

        if (optionalResult.isPresent()) {
            ResultAddModel existingResult = optionalResult.get();

            // Update the fields of the existing result with the new values
            existingResult.setRsession(updatedResult.getRsession());
            existingResult.setRclass(updatedResult.getRclass());
            existingResult.setRbatchid(updatedResult.getRbatchid());
            existingResult.setRroll(updatedResult.getRroll());
            existingResult.setRbangla(updatedResult.getRbangla());
            existingResult.setRmath(updatedResult.getRmath());
            existingResult.setRenglish(updatedResult.getRenglish());
            existingResult.setRislam(updatedResult.getRislam());
            existingResult.setRscince(updatedResult.getRscince());
            existingResult.setRsocial(updatedResult.getRsocial());
            existingResult.setRtotalmark(updatedResult.getRtotalmark());
            existingResult.setRavg(updatedResult.getRavg());
            existingResult.setRgpa(updatedResult.getRgpa());
            existingResult.setRgrade(updatedResult.getRgrade());
            existingResult.setRpassFail(updatedResult.getRpassFail());
            existingResult.setRexamcatagory(updatedResult.getRexamcatagory());

            // Save the updated result
            resultRepo.save(existingResult);

            return ResponseEntity.ok("Result updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Result with ID " + id + " not found");
        }
    }
}
