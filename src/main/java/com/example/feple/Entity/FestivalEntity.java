package com.example.feple.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Festival")
@Getter
@Setter
public class FestivalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String festival_name;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;

    @Column
    private String place;

    @ManyToMany(mappedBy = "festivalList", cascade = CascadeType.PERSIST)
    private List<ArtistEntity> participate_artist = new ArrayList<>();

    @Column
    private String timetable_url;

    public void addArtist(ArtistEntity artist) {
        if (!participate_artist.contains(artist)) {
            participate_artist.add(artist);
            artist.addFestival(this);
        }
    }
}
