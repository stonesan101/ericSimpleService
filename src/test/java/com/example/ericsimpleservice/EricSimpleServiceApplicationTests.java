package com.example.ericsimpleservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EricSimpleServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void getBooks() throws Exception {
        // Implement test logic for getBooks() method in BookController
        mockMvc.perform(get("/books")).andExpect(status().isOk()).andExpect(content().contentType("application/json")).andExpect(jsonPath("$").isArray());
    }

    @Test
    void createBook() throws Exception {
        // Implement test logic for createBook() method in BookController
        String newBookJson = "{ \"title\": \"Test Book\", \"author\": \"Test Author\", \"price\": 19.99 }";

        mockMvc.perform(post("/books").contentType("application/json").content(newBookJson)).andExpect(status().isCreated()).andExpect(jsonPath("$.id").exists()).andExpect(jsonPath("$.title").value("Test Book")).andExpect(jsonPath("$.author").value("Test Author")).andExpect(jsonPath("$.price").value(19.99));
    }

}
