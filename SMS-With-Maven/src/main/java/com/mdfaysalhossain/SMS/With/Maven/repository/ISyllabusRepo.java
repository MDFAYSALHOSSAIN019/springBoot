package com.mdfaysalhossain.SMS.With.Maven.repository;

import com.mdfaysalhossain.SMS.With.Maven.model.SyllabusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISyllabusRepo extends JpaRepository<SyllabusModel, Integer> {



}
