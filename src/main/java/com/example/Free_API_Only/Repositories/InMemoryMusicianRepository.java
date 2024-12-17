package com.example.Free_API_Only.Repositories;

import com.example.Free_API_Only.Entities.Musician;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMusicianRepository implements MusicianRepository {

    private final static List<Musician> musicianDB = new ArrayList<>();

    public InMemoryMusicianRepository() {
        musicianDB.add(new Musician("John Doe", "Guitar", "http://soundcloud.com"));
        musicianDB.add(new Musician("Jollenne Doe", "Vocals", "http://soundcloud.org"));
    }


}
