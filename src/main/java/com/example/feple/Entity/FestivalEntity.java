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

    @ManyToMany
    @JoinTable(
            name = "festival_artist",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<ArtistEntity> participate_artists = new ArrayList<>();

    @Column
    private String timetable_url;

    public void addArtist(ArtistEntity artist) {
        this.participate_artists.add(artist);
        artist.getFestival_list().add(this);
    }
}
