package com.example.Exercice.mapper;

import com.example.Exercice.dto.FilmDTO;
import com.example.Exercice.entity.Film;
import com.example.Exercice.response.FilmResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class FilmMapper {

    public List<FilmResponse> filmToFilmsResponse(List<Film> films)
    {
        List<FilmResponse> filmResponses=new ArrayList<>();
        for (Film film: films)
            filmResponses.add(filmToFilmResponse(film));
        return filmResponses;
    }
    public FilmResponse filmToFilmResponse(Film film)
    {
        FilmResponse filmResponse = new FilmResponse();
        BeanUtils.copyProperties(film,filmResponse);
        return filmResponse;
    }
    public List<FilmDTO> filmToFilmDTO(List<Film> films)
    {
        List<FilmDTO> filmDTOS=new ArrayList<>();
        for (Film film : films)
            filmDTOS.add(filmToFilmDTO(film));
        return filmDTOS;
    }
    public FilmDTO filmToFilmDTO(Film film)
    {
        FilmDTO filmDTO=new FilmDTO();
        BeanUtils.copyProperties(film,filmDTO);
        return filmDTO;
    }
}
