package com.example.Free_API_Only.Repositories;

import com.example.Free_API_Only.Entities.Musician;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMusicianRepository implements MusicianRepository {

    private final static List<Musician> musicianDB = new ArrayList<>();


    @Override
    public List<Musician> findAll() {
        return List.of();
    }
}
