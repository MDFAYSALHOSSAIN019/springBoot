package com.mdfaysalhossain.SMS.With.Maven.service;

import com.mdfaysalhossain.SMS.With.Maven.model.ResultAddModel;
import com.mdfaysalhossain.SMS.With.Maven.repository.IResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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




    ResultAddModel resultAddModel;

    public   void  totalmark(){

        int totalmarks= resultAddModel.getRbangla()+ resultAddModel.getRenglish()+ resultAddModel.getRmath()+resultAddModel.getRislam()+resultAddModel.getRscince()+resultAddModel.getRsocial();

    }

<<<<<<< HEAD
//    public List<ResultAddModel> findByClass(String rClass) {
//        return iResultRepo.findBy(rClass);
//    }
=======
//    public List<ResultAddModel> findByRClass(String rClass) {
//        return iResultRepo.findByRclass(rClass);
//    }

    public List<ResultAddModel> findByRClass(String rClass) {
>>>>>>> 0906a4eff5597bba66ed8fe9420b105173125ff0

        return iResultRepo.findByRclass(rClass);
    }

}
