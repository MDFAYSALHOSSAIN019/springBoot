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

    private  int a_class;

    private String a_roll;

    private   String a_Dates;


    private  String a_attendance;


}
