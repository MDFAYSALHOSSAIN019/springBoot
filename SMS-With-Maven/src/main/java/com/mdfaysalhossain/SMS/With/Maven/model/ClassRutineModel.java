package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ClassRutineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cr_id;

    private String cr_class;
    private String cr_day;

    private String  first_sub;
    private String  second_sub;
    private String  third_sub;
    private String  forth_sub;
    private String  fivth_sub;
    private String  six_sub;
    private String  seven_sub;

    private String  first_tea;
    private String  second_tea;
    private String  third_tea;
    private String  forth_tea;
    private String  fivth_tea;
    private String  six_tea;
    private String  seven_tea;


    private String cr_time1;
    private String cr_time2;
    private String cr_time3;
    private String cr_time4;
    private String cr_time5;
    private String cr_time6;
    private String cr_time7;

    @ManyToOne
    @JoinColumn(name="stu_id")
    private TeacherAddModel teacherAddModel;


}
