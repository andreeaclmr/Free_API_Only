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
    private String link;
    @Column
    private String photo;
    @Column
    private LocalDate dateCreated;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idManager", nullable = true)
    private Manager manager;


    public Musician(String name, String skills, String link, String photo, LocalDate dateCreated) {
        this.name = name;
        this.skills = skills;
        this.link = link;
        this.photo = photo;
        this.dateCreated = dateCreated;
    }


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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Musician(Long id, String name, String skills, String link, String photo, LocalDate dateCreated) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.link = link;
        this.photo = photo;
        this.dateCreated = dateCreated;
    }

    public Musician() {}
}

