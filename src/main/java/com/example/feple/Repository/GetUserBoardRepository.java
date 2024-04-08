package com.example.feple.Repository;

import com.example.feple.Entity.GetUserBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GetUserBoardRepository extends JpaRepository<GetUserBoardEntity, Long> {
    List<GetUserBoardEntity> findTop4ByOrderByDatetimeDesc();
}
