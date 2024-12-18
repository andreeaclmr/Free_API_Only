package com.example.Free_API_Only.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class MusicianAcceptanceTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void createAMusician () throws Exception {
        String musicianRequest = """
                {
                "name": "Ana",
                "skills": "Guitar, Singing",
                "link": "http://johndoeportfolio.com",
                "photo": "http://photo.com",
                "dateCreated": "2024-12-17"
                }
                """;
mockMvc.perform(post("/post/musicians")
        .contentType(MediaType.APPLICATION_JSON));
        .content(musicianRequest);
        .andExpect(status());
    }

}