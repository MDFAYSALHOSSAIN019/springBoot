package com.mdfaysalhossain.SMS.With.Maven.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "studentTable")
@Builder
public class StudentAddModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;

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

//    @Column(name = "stPhoto", unique = false, nullable = false, length = 100000)
//    private byte[] stPhoto;

    private  String stPhoto;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private UserModel user;


//    @OneToMany
//    @MapKeyColumn(name = "pid")
//    private List<PaymentModel> paymentModel;

    }


