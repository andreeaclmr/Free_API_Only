package com.example.Free_API_Only.Controllers;

import com.example.Free_API_Only.DTOs.MusicianRequestDTO;
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
    public ResponseEntity<Musician> createMusician(@RequestBody MusicianRequestDTO musicianRequestDTO) {
        //Mapping Request DTO to Entity

        Musician musician = new Musician(musicianRequestDTO.name(), musicianRequestDTO.skills(), musicianRequestDTO.link(), musicianRequestDTO.photo(), musicianRequestDTO.dateCreated());
        Musician savedMusician = musicianRepository.save(musician);
        return new ResponseEntity<>(musician, HttpStatus.CREATED);
    }

    // Get Musicians by ID
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Musician> getMusicianById(@PathVariable Long id) {
        Optional<Musician> musician = musicianRepository.findById(id);

        // mapping Entity to Response DTO
        if (musician.isPresent()) {
            return new ResponseEntity<>(musician.get(), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a Musician
    @DeleteMapping("/del/musicians/{id}")
    public ResponseEntity<?> deleteMusician(@PathVariable long id) {
        musicianRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    // Update a Musician
    @PutMapping("put/musicians/{id}")
    public ResponseEntity<Musician> updateMusician(@PathVariable long id, @RequestBody Musician musician) {
        try {
            Optional<Musician> existingMusician = musicianRepository.findById(id);
            if (existingMusician.isPresent()) {
                Musician updatedMusician = existingMusician.get();
                updatedMusician.setName(musician.getName());
                updatedMusician.setSkills(musician.getSkills());
                updatedMusician.setPhoto(musician.getPhoto());
                updatedMusician.setLink(musician.getLink());
                updatedMusician.setDateCreated(musician.getDateCreated());
            Musician savedMusician = musicianRepository.save(updatedMusician);
            return ResponseEntity.ok(savedMusician);

        } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
    }
    }

