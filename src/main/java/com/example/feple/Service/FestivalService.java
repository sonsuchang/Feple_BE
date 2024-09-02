package com.example.feple.Service;

import com.example.feple.Entity.ArtistEntity;
import com.example.feple.Entity.FestivalEntity;
import com.example.feple.Repository.ArtistRepository;
import com.example.feple.Repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FestivalService {

    @Autowired
    private FestivalRepository festivalRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public FestivalEntity saveFestival(FestivalEntity festival, List<String> artistNames) {
        for (String artistName : artistNames) {
            Optional<ArtistEntity> artistOpt = artistRepository.findByName(artistName);
            artistOpt.ifPresent(festival::addArtist);
        }
        return festivalRepository.save(festival);
    }
}
