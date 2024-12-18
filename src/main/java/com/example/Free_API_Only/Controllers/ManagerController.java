package com.example.Free_API_Only.Controllers;

import com.example.Free_API_Only.Entities.Manager;
import com.example.Free_API_Only.Entities.Musician;
import com.example.Free_API_Only.Exceptions.ResourceNotFoundException;
import com.example.Free_API_Only.Repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ManagerController {

    @Autowired
    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    // Get All Managers // no funciona
    @GetMapping("/get/managers")
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return ResponseEntity.ok(managers);

    }

    // Create One Manager
    @PostMapping("/post/managers")
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        if (manager.getName() == null || manager.getCompany() == null || manager.getEmail() == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        try {
            Manager savedManager = managerRepository.save(manager);
            return new ResponseEntity<>(savedManager, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get Managers by id // no funciona
    @GetMapping("/get/managers/id/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable long id) {
        Optional<Manager> manager = managerRepository.findById(id);
        if (manager.isPresent()) {
            return ResponseEntity.ok(manager.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a Manager
    @DeleteMapping("/del/managers/{id}")
    public ResponseEntity<?> deleteManager(@PathVariable long id) {
        managerRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }


    // Update a Manager // no funciona
    @PutMapping("put/managers/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable long id, @RequestBody Manager manager) {
        try {
            Optional<Manager> existingManager = managerRepository.findById(id);
            if (existingManager.isPresent()) {
                Manager updatedManager = existingManager.get();
                updatedManager.setName(manager.getName());
                updatedManager.setEmail(manager.getEmail());
                updatedManager.setSeeking_skills(manager.getSeeking_skills());
                Manager savedManager = managerRepository.save(updatedManager);
                return ResponseEntity.ok(savedManager);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }}


