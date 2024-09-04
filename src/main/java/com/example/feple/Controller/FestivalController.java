package com.example.feple.Controller;

import com.example.feple.Entity.FestivalEntity;
import com.example.feple.Repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/festival")
public class FestivalController {
    private final FestivalRepository festivalRepository;

    @PostMapping("/save")
    public void saveFestival(@RequestBody FestivalEntity festivalEntity) {
        festivalRepository.save(festivalEntity);
    }
}
