package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.Position;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PositionManager {
    public Position addPosition(Position position);
    public boolean deletePosition(Position position);
    public boolean deletePositionById(Integer id);
    public boolean updatePosition(Position position);
    public Position findPosition(Position position);
    public Position findPositionById(Integer id);
    public List<Position> getAllPositions();
    public Page<Position> getAllPositions(int page, int taille);
    public Page<Position> searchPositions(String keyword, int page, int taille);
}
