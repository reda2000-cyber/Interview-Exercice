package com.example.Exercice.servie;

import com.example.Exercice.dto.FilmDTO;
import com.example.Exercice.exception.FilmNameDuplicationException;
import com.example.Exercice.request.FilmRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FilmService {
    ResponseEntity<FilmDTO> createFilm(FilmRequest filmRequest) throws FilmNameDuplicationException;

    ResponseEntity<List<FilmDTO>> getAllFilms();
}
