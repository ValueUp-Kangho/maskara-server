package com.server.mascara.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_RECORD_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    private String storeName;
    private int usedPoint;
    private LocalDateTime date;
}
