package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "resultSheetTable")
public class ResultAddModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rid;
    @Column(nullable = false)
    private String rsession;

    @Column(nullable = false)
    private String rclass;

    @Column(nullable = false)
    private String rbatchid;

    @Column(nullable = false)
    private  String rroll;

    @Column(nullable = false)
    private int rbangla;
    @Column(nullable = false)
    private int rmath;
    @Column(nullable = false)
    private int renglish;
    @Column(nullable = false)
    private int rislam;
    @Column(nullable = false)
    private int rscince;
    @Column(nullable = false)
    private  int rsocial;

    private int rtotalmark;

    private double ravg;

    private double rgpa;

    private String rgrade;

    private String rpassFail;

    private String rexamcatagory;





//    @ManyToOne
//    @JoinColumn(name = "sid")
//    private StudentAddModel studentAddModel;

//    @OneToOne
//    @JoinColumn(name = "stRoll", referencedColumnName = "stRoll")
//    private StudentAddModel student;

//    @ManyToOne
//    @JoinColumn(name = "st_roll", referencedColumnName = "st_roll") // Specify the name of the foreign key column
//    private StudentAddModel student;


}
