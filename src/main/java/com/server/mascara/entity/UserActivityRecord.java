package com.server.mascara.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserActivityRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTIVITY_RECORD_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COLLECTIONBOX_ID")
    private CollectionBox collectionBox;

    private LocalDateTime date;
    private int maskCount;
}
