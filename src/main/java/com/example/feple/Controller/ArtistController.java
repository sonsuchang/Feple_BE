package com.example.feple.Controller;

import com.example.feple.Entity.ArtistEntity;
import com.example.feple.Repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistRepository artistRepository;

    @PostMapping("/save")
    public ResponseEntity<ArtistEntity> saveArtist(@RequestBody Map<String, String> requestData) {
        String artistName = requestData.get("name");

        if (artistName == null || artistName.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // 새로운 ArtistEntity 생성 및 저장
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setName(artistName);
        ArtistEntity savedArtist = artistRepository.save(artistEntity);

        return ResponseEntity.ok(savedArtist);
    }
}
