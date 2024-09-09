package com.example.feple.Controller;

import com.example.feple.Entity.ArtistEntity;
import com.example.feple.Repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;

    @PostMapping("/save")
    public void saveArtist(@RequestBody ArtistEntity artistEntity) {
        artistRepository.save(artistEntity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArtistEntity>> getAllArtist(){
        List<ArtistEntity> artists = artistRepository.findAll();
        if (artists.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(artists);
        }
    }
}
