package com.server.maskara.entity;

import lombok.Getter;
import javax.persistence.*;

@Entity
@Getter
public class CollectionBox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTIONBOX_ID")
    private Long id;

    private String name;
    private String serialNumber;
    private String imgUrl;
    private String address;
    private String institutions;

    private Double latitude;
    private Double longitude;
}
