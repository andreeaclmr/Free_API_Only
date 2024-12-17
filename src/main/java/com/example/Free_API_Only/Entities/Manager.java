package com.example.Free_API_Only.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
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

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String seeking_skills;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeeking_skills() {
        return seeking_skills;
    }

    public void setSeeking_skills(String seeking_skills) {
        this.seeking_skills = seeking_skills;
    }

    public Manager(long id, String name, String company, String email, String seeking_skills) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.email = email;
        this.seeking_skills = seeking_skills;

    }
}