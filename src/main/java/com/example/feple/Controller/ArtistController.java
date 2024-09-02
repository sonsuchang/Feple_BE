package com.example.feple.Controller;

import com.example.feple.Entity.ArtistEntity;
import com.example.feple.Repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;

    @PostMapping("/save")
    public ResponseEntity<ArtistEntity> saveArtist(@RequestBody ArtistEntity artistEntity) {
        ArtistEntity savedArtist = artistRepository.save(artistEntity);
        return ResponseEntity.ok(savedArtist);
    }
}
