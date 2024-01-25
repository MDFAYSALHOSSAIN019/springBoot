package com.mdfaysalhossain.SMS.With.Maven.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SyllabusModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int syid;

    private  String sclass;

    private String subject;

    private  String pageNo;

    private  String discription;
}
