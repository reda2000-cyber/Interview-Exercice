package com.example.Exercice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmDTO {
    private Long id;
    private String primaryTitle;
    private String originalTitle;
    private Integer startYear;
}