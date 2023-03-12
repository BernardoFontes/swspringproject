package com.berna.swspringproject.resources;

import com.berna.swspringproject.domain.Move;
import com.berna.swspringproject.service.MovesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/moves")
public class MovesResource {
    @Autowired
    private MovesService movesService;

    @GetMapping
    public ResponseEntity<Iterable<Move>> findAll(){
        Iterable<Move> list = movesService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Move> findById(@PathVariable Long id){
        Move move = movesService.findById(id);
        return ResponseEntity.ok().body(move);
    }

    @PostMapping
    public void insert(@RequestBody Move obj){
         movesService.insert(obj);
    }
}
