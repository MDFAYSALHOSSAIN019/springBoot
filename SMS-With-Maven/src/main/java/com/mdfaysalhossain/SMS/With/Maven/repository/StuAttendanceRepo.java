package com.mdfaysalhossain.SMS.With.Maven.repository;

import com.mdfaysalhossain.SMS.With.Maven.model.StuAttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuAttendanceRepo extends JpaRepository<StuAttendanceModel,Integer> {

    List<StuAttendanceModel> findByAid(int aid);
//    List<StuAttendanceModel> findByA_Class(String a_Class);


}
