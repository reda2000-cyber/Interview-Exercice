package com.example.Exercice;

import com.example.Exercice.dto.FilmDTO;
import com.example.Exercice.request.FilmRequest;
import com.example.Exercice.servie.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
class FilmControllerTest {

	@MockBean
	private FilmService filmService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void createFilm() throws Exception {
		// Mock data
		FilmRequest filmRequest = new FilmRequest("Savage","Animal",2018);
		FilmDTO filmDTO = new FilmDTO(1L, "Last","Bullet",2020);

		// Mocking the service method
		when(filmService.createFilm(filmRequest)).thenReturn(new ResponseEntity<>(filmDTO, HttpStatus.CREATED));

		// Perform the request and assert the response
		mockMvc.perform(MockMvcRequestBuilders.post("/films")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(filmRequest)))
						.andExpect(MockMvcResultMatchers.status().isCreated())
						.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
						.andExpect(MockMvcResultMatchers.jsonPath("$.primaryTitle").value("Last"))
						.andExpect(MockMvcResultMatchers.jsonPath("$.originalTitle").value("Bullet"))
						.andExpect(MockMvcResultMatchers.jsonPath("$.startYear").value(2020));
	}

	@Test
	void getAllFilms() throws Exception {
		// Mock data
		FilmDTO film1 = new FilmDTO(1L, "Last", "Bullet", 2020);
		FilmDTO film2 = new FilmDTO(2L, "King", "Warrior", 2023);
		List<FilmDTO> films = Arrays.asList(film1, film2);

		// Mocking the service method
		when(filmService.getAllFilms()).thenReturn(new ResponseEntity<>(films, HttpStatus.ACCEPTED));

		// Perform the request and assert the response
		mockMvc.perform(MockMvcRequestBuilders.get("/films"))
				.andExpect(MockMvcResultMatchers.status().isAccepted())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].primaryTitle").value("Last"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].originalTitle").value("Bullet"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].startYear").value(2020))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].primaryTitle").value("King"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].originalTitle").value("Warrior"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].startYear").value(2023));
	}
}
