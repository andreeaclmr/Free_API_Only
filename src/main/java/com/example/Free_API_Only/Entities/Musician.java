package com.example.Free_API_Only.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Musician {
    @Id
    private Long id;
    private String name;
    @Column
    private String skills;
    @Column
    private String portfolio_link;
    @Column
    private LocalDate dateCreated;
}

