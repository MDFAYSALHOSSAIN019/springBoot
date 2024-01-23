package com.mdfaysalhossain.SMS.With.Maven.repository;

import com.mdfaysalhossain.SMS.With.Maven.model.ResultAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IStudentAddRepo extends JpaRepository<StudentAddModel,Integer> {

    @Query("SELECT c FROM StudentAddModel c WHERE c.stClass = :stClass")
    List<StudentAddModel> findByStClass(@RequestParam("stClass") String stClass);


}
