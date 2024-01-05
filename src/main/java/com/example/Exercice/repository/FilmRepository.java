package com.example.Exercice.repository;

import com.example.Exercice.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {

    Film findByPrimaryTitleIgnoreCase(String primaryTitle);
}
