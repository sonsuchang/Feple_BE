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
    private String imgUrl;

    @ElementCollection
    @CollectionTable(name = "artists_songs", joinColumns = @JoinColumn(name = "artist_id"))
    @Column(name = "song")
    private List<String> songs = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "artist_festival_details", joinColumns = @JoinColumn(name = "artist_id"))
    private List<FestivalDetails> festivalDetails = new ArrayList<>();
}
