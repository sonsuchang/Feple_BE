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
    private String artist_name;

    @ManyToMany(mappedBy = "participate_artists")
    private List<FestivalEntity> festival_list = new ArrayList<>();
}
