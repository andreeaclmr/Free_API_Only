package com.example.Free_API_Only.Repositories;

import com.example.Free_API_Only.Entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    static Optional<Manager> findbyid(long id) {
        return null;
    }
}
