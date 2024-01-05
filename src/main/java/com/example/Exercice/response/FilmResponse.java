package com.example.Exercice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmResponse {
    private Long id;
    private String primaryTitle;
    private String originalTitle;
    private Integer startYear;
}

