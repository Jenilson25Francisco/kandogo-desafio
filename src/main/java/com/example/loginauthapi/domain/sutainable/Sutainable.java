package com.example.loginauthapi.domain.sutainable;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class Sutainable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private int points;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Category category;

}
