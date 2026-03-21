package com.university.studentapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnStudentForValidId() throws Exception {
        mockMvc.perform(get("/student/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Vamsi Krishna"))
                .andExpect(jsonPath("$.department").value("Computer Science"));
    }

    @Test
    void shouldReturnNotFoundForUnknownStudentId() throws Exception {
        mockMvc.perform(get("/student/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Student with ID 99 not found."))
                .andExpect(jsonPath("$.statusCode").value(404))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void shouldReturnBadRequestForInvalidIdFormat() throws Exception {
        mockMvc.perform(get("/student/abc"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid student ID format. Please provide a numeric ID."))
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.timestamp").exists());
    }
}
