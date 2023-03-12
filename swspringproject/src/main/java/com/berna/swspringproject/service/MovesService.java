package com.berna.swspringproject.service;

import com.berna.swspringproject.domain.Move;
import com.berna.swspringproject.repository.MovesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.berna.swspringproject.service.exceptions.ObjectNotFoundException;

import java.util.Optional;

@Service
public class MovesService {
    @Autowired
    private MovesRepository repo;

    public Iterable<Move> findAll() {
        return repo.findAll();
    }

    public Move findById(Long id){
        Optional<Move> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void insert(Move obj){
         repo.save(obj);
    }

    public Move update(Move obj){
        Move newObj = findById(obj.getId());
        updateData(obj, newObj);
        return repo.save(newObj);
    }

    private void updateData(Move obj, Move newObj){
        newObj.setName(obj.getName());
        newObj.setLevel(obj.getLevel());
        newObj.setType(obj.getType());
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
