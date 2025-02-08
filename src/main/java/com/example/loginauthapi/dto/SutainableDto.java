package com.example.loginauthapi.dto;

import com.example.loginauthapi.domain.sutainable.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class SutainableDto {

    private String id;
    private String title;
    private String description;
    private int points;
    private Category category;
    private OffsetDateTime created_at;

}
