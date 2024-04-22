package com.example.feple.Controller;

import com.example.feple.Entity.FestivalEntity;
import com.example.feple.Repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/festival")
public class FestivalController {
    private final FestivalRepository festivalRepository;

    @GetMapping("/")
    public ResponseEntity<List<FestivalEntity>> getFestivalInfo(){
        List<FestivalEntity> festivalinfo = festivalRepository.findAll();
        if (festivalinfo.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(festivalinfo);
        }
    }

}