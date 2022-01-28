package org.jmc.testing.spring.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.jmc.testing.spring.controller.SampleController.ID;
import static org.jmc.testing.spring.controller.SampleController.NAME;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

  @Autowired MockMvc mvc; // Mock external call to REST Controller

  @Test
  @SneakyThrows
  void getSampleTest() {

    mvc.perform(get("/api/v1/samples").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", equalTo(ID)))
        .andExpect(jsonPath("$.name", equalTo(NAME)));
  }
}
