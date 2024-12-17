package com.example.Free_API_Only.Controllers;

import com.example.Free_API_Only.Entities.Musician;
import com.example.Free_API_Only.Repositories.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MusicianController {

    @Autowired
    private MusicianRepository musicianRepository;

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



    }

