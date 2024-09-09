package com.example.feple.Controller;

import com.example.feple.Entity.FestivalEntity;
import com.example.feple.Repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/festival")
public class FestivalController {

    private final FestivalRepository festivalRepository;

    @PostMapping("/save")
    public void saveFestival(@RequestBody FestivalEntity festivalEntity) {
        festivalRepository.save(festivalEntity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FestivalEntity>> getAllFestival(){
        List<FestivalEntity> festivals = festivalRepository.findAll();
        if (festivals.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(festivals);
        }
    }
}
