package com.example.Free_API_Only.DTOs;

import java.time.LocalDate;

public record MusicianRequest (String name, String skills, String link, String photo, LocalDate dateCreated) {

}
