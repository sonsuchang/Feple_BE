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
    private String name;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;

    @Column
    private String place;

    @ElementCollection
    @CollectionTable(name = "festival_artists", joinColumns = @JoinColumn(name = "festival_id"))
    @Column(name = "artist")
    private List<String> participate_artist = new ArrayList<>();

    @Column
    private String imgUrl;
}
