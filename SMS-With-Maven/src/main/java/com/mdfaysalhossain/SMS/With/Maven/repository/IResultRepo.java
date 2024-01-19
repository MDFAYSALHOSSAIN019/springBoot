package com.mdfaysalhossain.SMS.With.Maven.repository;


import com.mdfaysalhossain.SMS.With.Maven.model.ResultAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IResultRepo  extends JpaRepository<ResultAddModel,Integer> {

//    List<ResultAddModel> findByR_Class(String r_Class);

}
