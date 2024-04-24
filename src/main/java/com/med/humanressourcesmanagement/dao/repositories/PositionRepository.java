package com.med.humanressourcesmanagement.dao.repositories;

import com.med.humanressourcesmanagement.dao.entities.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Page<Position> findPositionByNameContaining(String keyword, Pageable pageable);
}
