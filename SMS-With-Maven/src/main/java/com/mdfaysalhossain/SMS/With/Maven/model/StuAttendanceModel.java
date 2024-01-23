package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StuAttendanceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;


//    @ManyToOne
//    @JoinColumn(name = "sid", referencedColumnName = "sid")
//    private StudentAddModel student;

    private  String aclass;

    private String aroll;

    private   String aDates;


    private  String aattendance;


    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "sid")
    private StudentAddModel student;

}
