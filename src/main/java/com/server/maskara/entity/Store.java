package com.server.maskara.entity;

import javax.persistence.*;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
}