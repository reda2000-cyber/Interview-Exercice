package com.example.Exercice.exception;

public class FilmNameDuplicationException extends Exception{

    public FilmNameDuplicationException(String errorMessage) {
        super(errorMessage);
    }
}
