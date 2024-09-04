package com.example.feple.Entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class FestivalDetails {

    private String festivalName;
    private String place;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;
}
