package com.med.humanressourcesmanagement.service;

import com.med.humanressourcesmanagement.dao.entities.Position;
import com.med.humanressourcesmanagement.dao.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManagerImplementation implements PositionManager{
    @Autowired
    PositionRepository positionRepository;
    @Override
    public Position addPosition(Position position) {
        try{
            return positionRepository.save(position);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean deletePosition(Position position) {
        try{
            positionRepository.delete(position);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePositionById(Integer id) {
        try{
            positionRepository.delete(positionRepository.findById(id).get());
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean updatePosition(Position position) {
        try{
            positionRepository.save(position);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Override
    public Position findPosition(Position position) {
        try{
            return positionRepository.findById(position.getId()).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Position findPositionById(Integer id) {
        try{
            return positionRepository.findById(id).get();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Position> getAllPositions() {
        try{
            return positionRepository.findAll();
        }catch(Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Page<Position> getAllPositions(int page, int taille) {
        return positionRepository.findAll(PageRequest.of(page,taille));
    }

    @Override
    public Page<Position> searchPositions(String keyword, int page, int taille) {
        return positionRepository.findPositionByNameContaining(keyword,PageRequest.of(page,taille));
    }
}
