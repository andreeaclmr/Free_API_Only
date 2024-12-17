package com.example.Free_API_Only.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column
    private String skills;
    @Column
    private String portfolio_link;
    @Column
    private LocalDate dateCreated;


    public Long getId() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPortfolio_link() {
        return portfolio_link;
    }

    public void setPortfolio_link(String portfolio_link) {
        this.portfolio_link = portfolio_link;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Musician(Long id, String name, String skills, String portfolio_link, LocalDate dateCreated) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.portfolio_link = portfolio_link;
        this.dateCreated = dateCreated;
    }

    public Musician() {}
}

