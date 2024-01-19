package com.mdfaysalhossain.SMS.With.Maven.service;

import com.mdfaysalhossain.SMS.With.Maven.model.ResultAddModel;
import com.mdfaysalhossain.SMS.With.Maven.model.StudentAddModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.IResultRepo;
import com.mdfaysalhossain.SMS.With.Maven.repository.IStudentAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ResultService {


    @Autowired
    IResultRepo iResultRepo;



    public ResultService(IResultRepo iResultRepo) {
        this.iResultRepo = iResultRepo;
    }



    public List<ResultAddModel> getAllResult(){
        return iResultRepo.findAll();
    }

    public void saveresult(ResultAddModel res){
        iResultRepo.save(res);
    }

    public void daleteresult(int id){
        iResultRepo.deleteById(id);
    }

    public Optional<ResultAddModel> findById(int id){
        return iResultRepo.findById(id);
    }


//    public List<ResultAddModel> findByClass(String r_Class) {
//        return iResultRepo.findByR_Class(r_Class);
//
//    }

    ResultAddModel resultAddModel;

    public   void  totalmark(){

        int totalmarks= resultAddModel.getR_bangla()+ resultAddModel.getR_english()+ resultAddModel.getR_math()+resultAddModel.getR_islam()+resultAddModel.getR_scince()+resultAddModel.getR_social();

    }




}
