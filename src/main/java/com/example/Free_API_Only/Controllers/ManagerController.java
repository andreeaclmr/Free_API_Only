package com.example.Free_API_Only.Controllers;

import com.example.Free_API_Only.Entities.Manager;
import com.example.Free_API_Only.Entities.Musician;
import com.example.Free_API_Only.Enum.Status;
import com.example.Free_API_Only.Exceptions.ResourceNotFoundException;
import com.example.Free_API_Only.Repositories.ManagerRepository;
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
public class ManagerController {

    @Autowired
    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @GetMapping("/get/managers")
    @Operation(
            summary = "Get all managers",
            description = "Retrieves a list of all managers from the database."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of managers retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return ResponseEntity.ok(managers);

    }


    @PostMapping("/post/managers")
    @Operation(
            summary = "Create a new manager",
            description = "Creates a new manager using the provided details."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Manager created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        if (manager.getName() == null || manager.getCompany() == null || manager.getEmail() == null || manager.getStatus() == null) {
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


    @GetMapping("/get/managers/id/{id}")
    @Operation(
            summary = "Get a manager by ID",
            description = "Retrieves the details of a manager by their ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Manager retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Manager not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    public ResponseEntity<Manager> getManagerById(@PathVariable long id) {
        Optional<Manager> manager = managerRepository.findById(id);
        if (manager.isPresent()) {
            return ResponseEntity.ok(manager.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/get/managers/status/{status}")
    @Operation(
            summary = "Get a manager by Status",
            description = "Retrieves the details of a manager by their Status."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Manager retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Manager not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    public ResponseEntity<List<Manager>> getManagerByStatus(@PathVariable Status status) {
        List<Manager> managers = managerRepository.findByStatus(status);
        return ResponseEntity.ok(managers);
    }

    @DeleteMapping("/del/managers/{id}")
    @Operation(
            summary = "Delete a manager",
            description = "Deletes a manager by their ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Manager deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Manager not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    public ResponseEntity<?> deleteManager(@PathVariable long id) {
        managerRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }



    @PutMapping("put/managers/{id}")
    @Operation(
            summary = "Update a manager",
            description = "Updates an existing manager's details by their ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Manager updated successfully"),
            @ApiResponse(responseCode = "404", description = "Manager not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

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


