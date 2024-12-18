package com.example.Free_API_Only.Repositories;

import com.example.Free_API_Only.Entities.Manager;
import com.example.Free_API_Only.Enum.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    List<Manager> findByStatus(Status status);
}
