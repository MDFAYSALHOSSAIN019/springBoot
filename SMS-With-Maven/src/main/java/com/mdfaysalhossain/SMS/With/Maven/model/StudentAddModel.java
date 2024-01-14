package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentAddModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    @Column(nullable = true)
    private String batchId;
    @Column(nullable = true)
    private String session;

    @Column(nullable = true)
    private String stClass;

    @Column(nullable = true)
    private String stRoll;

    @Column(nullable = true)
    private String stfirstname;

    private String stlastname;

    @Column(nullable = true)
    private String stemail;

    private String stfathersname;

    private String stmothersname;

    private String stpassword;

    private String strole;

    private String stdob;
    private String staddress;

    private String stgender;

    private String stphone;

    private  Long stPhoto;

    }
