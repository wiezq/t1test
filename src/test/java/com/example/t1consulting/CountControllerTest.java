package com.example.t1consulting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@WebMvcTest(CountController.class)
public class CountControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private StringService stringService;

  @Test
  public void testCountController() throws Exception {
    Map<Character, Integer> freq = new HashMap<>();
    freq.put('t', 2);
    freq.put('e', 1);
    freq.put('s', 1);

    when(stringService.charFrequence("test")).thenReturn(freq);

    mockMvc
        .perform(get("/api/v1/count").param("s", "test").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.t", is(2)))
        .andExpect(jsonPath("$.e", is(1)))
        .andExpect(jsonPath("$.s", is(1)));
  }
}
