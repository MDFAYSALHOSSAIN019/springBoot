package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TeacherInfoTable")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherAddModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    @Column(nullable = false)
    private String t_name;

    @Column(unique = true, nullable = false)
    private String t_email;

    @Column(nullable = false)
    private String t_password;

    private String t_phone;

    private String t_fathersname;

    private String t_mothersname;

    private String t_gender;

    private String t_dob;

    private String t_joiningDate;

    private String t_salary;

    private  String t_role;

    private String t_pic;

    private String t_cv;

    private String t_designation;




}
