package com.example.Free_API_Only.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manager")

public class Manager {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String company;
    @Column (nullable = false)
    private String email;
    @Column (nullable = false)
    private String seeking_skills;

}
