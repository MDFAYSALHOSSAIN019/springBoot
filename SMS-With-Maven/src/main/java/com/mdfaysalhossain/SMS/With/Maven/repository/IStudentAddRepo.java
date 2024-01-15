package com.mdfaysalhossain.SMS.With.Maven.repository;

import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentAddRepo extends JpaRepository<StudentAddModel,Integer> {

    List<StudentAddModel> findByStClass(String stClass);


}
