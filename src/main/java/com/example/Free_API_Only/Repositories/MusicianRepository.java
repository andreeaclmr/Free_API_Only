package com.example.Free_API_Only.Repositories;

import com.example.Free_API_Only.Entities.Musician;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicianRepository {
    List<Musician> findAll();

}
