package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResultAddModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int r_id;
    @Column(nullable = false)
    private String r_session;

    @Column(nullable = false)
    private String r_class;
    @Column(nullable = false)
    private  String r_roll;

    @Column(nullable = false)
    private int r_bangla;
    @Column(nullable = false)
    private int r_math;
    @Column(nullable = false)
    private int r_english;
    @Column(nullable = false)
    private int r_islam;
    @Column(nullable = false)
    private int r_scince;
    @Column(nullable = false)
    private  int r_social;

    private int r_totalmark;

    private double r_avg;

    private int r_gpa;

    private String r_grade;

    private String r_passFail;

    private String r_examcatagory;


    public int gettotalmark(){

        return r_bangla+r_english+r_math+r_scince+r_social+r_islam;
    }



    @ManyToOne
    @JoinColumn(name = "sid")
    private StudentAddModel studentAddModel;
}
