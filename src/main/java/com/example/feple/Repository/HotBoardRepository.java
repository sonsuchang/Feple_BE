package com.example.feple.Repository;

import com.example.feple.Entity.HotBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotBoardRepository extends JpaRepository<HotBoardEntity, Long> {
    List<HotBoardEntity> findTop4ByOrderByDatetimeDesc();
}
