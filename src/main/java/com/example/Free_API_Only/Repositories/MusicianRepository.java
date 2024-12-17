package com.example.Free_API_Only.Repositories;

import com.example.Free_API_Only.Entities.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {
    static Optional<Musician> findbyname(String name) {
        return null;
    }
}
