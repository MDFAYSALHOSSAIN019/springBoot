package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "examRutineTable")
public class ExamRutineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exid;

    private String exClass;

    private String exSubject;

    private String exdate;

    private String exTime;


    @OneToMany
    private List<SubjectModel> subjectModel;



}
