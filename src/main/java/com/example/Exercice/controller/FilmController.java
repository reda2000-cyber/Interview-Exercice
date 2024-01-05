package com.example.Exercice.controller;


import com.example.Exercice.dto.FilmDTO;
import com.example.Exercice.exception.FilmNameDuplicationException;
import com.example.Exercice.request.FilmRequest;
import com.example.Exercice.servie.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private FilmService filmService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FilmDTO> createFilm(@RequestBody @Validated FilmRequest filmRequest) throws FilmNameDuplicationException {
        return filmService.createFilm(filmRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public   ResponseEntity<List<FilmDTO>> getAllFilms() {
        return filmService.getAllFilms();
    }
}
