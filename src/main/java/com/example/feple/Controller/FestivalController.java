package com.example.feple.Controller;

import com.example.feple.Entity.FestivalEntity;
import com.example.feple.Service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.feple.DTO.FestivalRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/festival")
public class FestivalController {
    private final FestivalService festivalService;

    @PostMapping("/save")
    public ResponseEntity<FestivalEntity> saveFestival(@RequestBody FestivalRequest festivalRequest) {
        FestivalEntity festivalEntity = new FestivalEntity();
        festivalEntity.setFestival_name(festivalRequest.getFestivalName());
        festivalEntity.setDatetime(festivalRequest.getDatetime());
        festivalEntity.setPlace(festivalRequest.getPlace());
        festivalEntity.setTimetable_url(festivalRequest.getTimetableUrl());

        FestivalEntity savedFestival = festivalService.saveFestival(festivalEntity, festivalRequest.getArtistNames());
        return ResponseEntity.ok(savedFestival);
    }
}
