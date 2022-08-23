package com.server.mascara.entity;

import javax.persistence.*;

@Entity
public class CollectionBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTIONBOX_ID")
    private Long id;

    private String serialNumber;
    private String address;
    private String institutions;
}
