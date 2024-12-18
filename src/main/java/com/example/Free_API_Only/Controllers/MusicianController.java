package com.example.Free_API_Only.Controllers;

import com.example.Free_API_Only.DTOs.MusicianRequestDTO;
import com.example.Free_API_Only.DTOs.MusicianResponseDTO;
import com.example.Free_API_Only.Entities.Musician;
import com.example.Free_API_Only.Repositories.MusicianRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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



    @GetMapping("/get/musicians")
    @Operation(
            summary = "Get all musicians",
            description = "Retrieves a list of all musicians in the database."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of musicians retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Musician>> getAllMusicians() {
        List<Musician> musicians = musicianRepository.findAll();
        return ResponseEntity.ok(musicians);

    }


    @PostMapping("/post/musicians")
    @Operation(
            summary = "Create a new musician",
            description = "Creates a new musician using the provided request body."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Musician created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Musician> createMusician(@RequestBody MusicianRequestDTO musicianRequestDTO
    ) {

        Musician musician = new Musician(
                musicianRequestDTO.name(),
                musicianRequestDTO.skills(),
                musicianRequestDTO.link(),
                musicianRequestDTO.photo(),
                musicianRequestDTO.dateCreated()
        );
        Musician savedMusician = musicianRepository.save(musician);
        return new ResponseEntity<>(musician, HttpStatus.CREATED);
    }


    @GetMapping("/get/id/{id}")
    @Operation(
            summary = "Get a musician by ID",
            description = "Retrieves the details of a musician by their ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Musician retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Musician not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    public ResponseEntity<Musician> getMusicianById(@PathVariable Long id) {
        Optional<Musician> musician = musicianRepository.findById(id);
        if (musician.isPresent()) {
            return new ResponseEntity<>(musician.get(), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/del/musicians/{id}")
    @Operation(
            summary = "Delete a musician",
            description = "Deletes a musician by their ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Musician deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Musician not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })


    public ResponseEntity<?> deleteMusician(@PathVariable long id) {
        musicianRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }


    @PutMapping("put/musicians/{id}")

    @Operation(
            summary = "Update a musician",
            description = "Updates an existing musician's details by their ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Musician updated successfully"),
            @ApiResponse(responseCode = "404", description = "Musician not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

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

