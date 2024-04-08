package com.example.feple.Repository;

import com.example.feple.Entity.FreeBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FreeBoardRepository extends JpaRepository<FreeBoardEntity, Long> {
    List<FreeBoardEntity> findTop4ByOrderByDatetimeDesc();
}
