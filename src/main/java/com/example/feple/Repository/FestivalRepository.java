package com.example.feple.Repository;

import com.example.feple.Entity.FestivalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<FestivalEntity, Long> {
}
