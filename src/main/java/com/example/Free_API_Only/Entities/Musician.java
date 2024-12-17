package com.example.Free_API_Only.Entities;

public class Musician {
    private String name;
    private String skills;
    private String portfolio_link;
    private String portfolio_picture;

    public Musician(String name, String skills, String portfolio_link, String portfolio_picture) {
        this.name = name;
        this.skills = skills;
        this.portfolio_link = portfolio_link;
        this.portfolio_picture = portfolio_picture;
    }

    public String getName(String name) {
        return name;
    }

    public String getSkills(String skills) {
        return this.skills;
    }

    public String getPortfolio_link(String portfolio_link) {
        return this.portfolio_link;
    }

    public String getPortfolio_picture(String portfolio_picture) {
        return this.portfolio_picture;
    }
}

