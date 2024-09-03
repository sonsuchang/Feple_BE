package com.example.feple.Controller;

import com.example.feple.DTO.FestivalRequest;
import com.example.feple.Entity.ArtistEntity;
import com.example.feple.Entity.FestivalEntity;
import com.example.feple.Repository.ArtistRepository;
import com.example.feple.Repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/festival")
public class FestivalController {
    @Autowired
    private FestivalRepository festivalRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @PostMapping("/save")
    public ResponseEntity<FestivalEntity> saveFestival(@RequestBody FestivalRequest festivalRequest) {
        FestivalEntity festivalEntity = new FestivalEntity();
        festivalEntity.setFestival_name(festivalRequest.getFestivalName());
        festivalEntity.setDatetime(festivalRequest.getDatetime());
        festivalEntity.setPlace(festivalRequest.getPlace());
        festivalEntity.setTimetable_url(festivalRequest.getTimetableUrl());

        for (String artistName : festivalRequest.getArtistNames()) {
            Optional<ArtistEntity> artistOpt = artistRepository.findByName(artistName);
            artistOpt.ifPresent(festivalEntity::addArtist);
        }

        FestivalEntity savedFestival = festivalRepository.save(festivalEntity);;

        for (String artistName : festivalRequest.getArtistNames()) {
            Optional<ArtistEntity> artistOpt = artistRepository.findByName(artistName);
            if (artistOpt.isPresent()) {
                ArtistEntity artist = artistOpt.get();
                artist.addFestival(festivalEntity);
                artistRepository.save(artist);
            }
        }
        return ResponseEntity.ok(savedFestival);
    }
}
