package com.example.Free_API_Only.Repositories;

import com.example.Free_API_Only.Entities.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {

}
