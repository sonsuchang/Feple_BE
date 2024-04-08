package com.example.feple.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "User_Info")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String nickname;

    @NonNull
    @Column
    private String uid;

    @Column
    private List<String> follow_artist;

    @Column
    private Long post_num = 0L;

    @Column
    private Long comment_num = 0L;

    @Column
    private Long bookmark_num = 0L;

    @Column
    private Long level = 0L;
}
