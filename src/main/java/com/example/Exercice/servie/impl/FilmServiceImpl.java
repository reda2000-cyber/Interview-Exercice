package com.example.Exercice.servie.impl;

import com.example.Exercice.dto.FilmDTO;
import com.example.Exercice.entity.Film;
import com.example.Exercice.exception.FilmNameDuplicationException;
import com.example.Exercice.mapper.FilmMapper;
import com.example.Exercice.request.FilmRequest;
import com.example.Exercice.servie.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Exercice.repository.FilmRepository;
import static com.example.Exercice.constant.ExceptionMessage.*;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;
    private FilmMapper filmMapper;

    @Override
    public ResponseEntity<FilmDTO> createFilm(FilmRequest filmRequest) throws FilmNameDuplicationException {
        if(filmRepository.findByPrimaryTitleIgnoreCase(filmRequest.getPrimaryTitle())!=null)
            throw new FilmNameDuplicationException(FILM_NAME_DUPLICATION);
        Film product=Film.builder()
                .primaryTitle(filmRequest.getPrimaryTitle())
                .originalTitle(filmRequest.getOriginalTitle())
                .startYear(filmRequest.getStartYear()).build();
        FilmDTO filmDTO = filmMapper.filmToFilmDTO(filmRepository.save(product));
        return new ResponseEntity<>(filmDTO,new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        List<FilmDTO> filmDTOS = filmMapper.filmToFilmDTO(filmRepository.findAll());
        return new ResponseEntity<>(filmDTOS,new HttpHeaders(), HttpStatus.ACCEPTED);
    }
}
