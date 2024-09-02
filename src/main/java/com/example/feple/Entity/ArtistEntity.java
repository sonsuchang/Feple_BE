package com.example.feple.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artist")
@Getter
@Setter
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true)
    private String name;

    @Column
    private String image_url;

    @ManyToMany
    @JoinTable(
            name = "artist_festival",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "festival_id")
    )
    private List<FestivalEntity> festivalList = new ArrayList<>();

    public void addFestival(FestivalEntity festival) {
        if (!festivalList.contains(festival)) {
            festivalList.add(festival);
            festival.addArtist(this);
        }
    }
}
