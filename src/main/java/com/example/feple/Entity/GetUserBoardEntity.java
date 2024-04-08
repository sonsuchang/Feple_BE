package com.example.feple.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "GetUserBoard")
@Getter
@Setter
public class GetUserBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String nickname;

    @NonNull
    @Column
    private String postname;

    @NonNull
    @Column
    private String content;

    @Column
    private List<String> comments;

    @Column
    private Long heart = 0L;

    @Column
    private Long favorite = 0L;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datetime;
}
