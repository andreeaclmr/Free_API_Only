package com.example.Free_API_Only.Controllers;

import com.example.Free_API_Only.Entities.Musician;
import com.example.Free_API_Only.Repositories.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MusicianController {

    @Autowired
    private final MusicianRepository musicianRepository;

    public MusicianController(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }


    // Get All Musicians
    @GetMapping("/get/musicians")
    public ResponseEntity<List<Musician>> getAllMusicians() {
        List<Musician> musicians = musicianRepository.findAll();
        return ResponseEntity.ok(musicians);

    }

    // Create One Musician
    @PostMapping("/post/musicians")
    public ResponseEntity<Musician> createMusician(@RequestBody Musician musician) {
        Musician savedMusician = musicianRepository.save(musician);
        return new ResponseEntity<>(musician, HttpStatus.CREATED);
    }

    // Get Musicians by Name -- not working
    @GetMapping("/get/{name}")
    public ResponseEntity<Musician> getMusicianByName(@PathVariable String name) {
        Optional<Musician> musician = MusicianRepository.findByName(name);
        if (musician.isPresent()) {
            return ResponseEntity.ok(musician.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

/*
    // Edit a Musician
    @PutMapping("/put/musicians/{id}")
*/


    // Delete a Musician
    @DeleteMapping("/del/musicians/{id}")
    public ResponseEntity<?> deleteMusician(@PathVariable long id) {
        musicianRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

   /*  @PutMapping("put/musicians/{id}")
    public ResponseEntity<Musician> updateMusician(@PathVariable long id, @RequestBody Musician musician) {
        try {
            Optional<Musician> existingMusician = musicianRepository.findById(id);
            if (existingMusician.isPresent()) {
                Musician updatedMusician = existingMusician.get();
                updatedMusician.setName(musician.getName());
                updatedMusician.getSkills(musician.getSkills());
                updatedMusician.setPortfolio_link(musician.getPortfolio_link());
                updatedMusician.setDateCreated(musician.getDateCreated());
            Musician savedMusician = musicianRepository.save(updatedMusician);
            return ResponseEntity.ok(savedMusician);

        } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
    } */
    }

