package com.mdfaysalhossain.SMS.With.Maven.service;

import com.mdfaysalhossain.SMS.With.Maven.model.ClassRutineModel;
import com.mdfaysalhossain.SMS.With.Maven.model.TeacherAddModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.IClassRutineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRutineService {

    @Autowired
    IClassRutineRepo iClassRutineRepo;

    public ClassRutineService(IClassRutineRepo iClassRutineRepo) {
        this.iClassRutineRepo = iClassRutineRepo;
    }

    public List<ClassRutineModel> getAllrutine(){

        return iClassRutineRepo.findAll();
    }


    public void  saverutine(ClassRutineModel te){

        iClassRutineRepo.save(te);
    }

    public void deletebyid(int id){

        iClassRutineRepo.deleteById(id);
    }

    public Optional<ClassRutineModel> findbyId(int id){

        return iClassRutineRepo.findById(id);
    }
}
