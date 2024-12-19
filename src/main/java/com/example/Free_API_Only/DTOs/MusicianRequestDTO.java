package com.example.Free_API_Only.DTOs;

import com.example.Free_API_Only.Entities.Manager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record MusicianRequestDTO(
        @NotBlank(message= "Name field can't be empty")
        String name,

        @NotBlank(message= "Skills field can't be empty")
        String skills,

        @NotBlank(message= "Link field can't be empty")
        String link,

        @NotBlank(message= "Photo field can't be empty")
        String photo,

        @NotNull(message= "Creation Date can't be null")
        LocalDate dateCreated
) {

}
