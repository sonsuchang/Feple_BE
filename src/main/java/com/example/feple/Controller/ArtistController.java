package com.example.feple.Controller;

import com.example.feple.Entity.ArtistEntity;
import com.example.feple.Repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;

    @PostMapping("/save")
    public void saveArtist(@RequestBody ArtistEntity artistEntity) {
        artistRepository.save(artistEntity);
    }
}
