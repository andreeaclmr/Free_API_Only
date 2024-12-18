package com.example.Free_API_Only.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MusicianResponseDTO(
        String name,
        String skills,
        String link,
        String photo,
        LocalDate dateCreated
) {}
