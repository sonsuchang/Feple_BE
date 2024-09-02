package com.example.feple.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FestivalRequest {
    private String festivalName;
    private LocalDateTime datetime;
    private String place;
    private String timetableUrl;
    private List<String> artistNames;
}
