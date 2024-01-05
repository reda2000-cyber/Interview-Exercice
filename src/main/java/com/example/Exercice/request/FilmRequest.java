package com.example.Exercice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmRequest {
    @NotNull @NotEmpty @NotBlank @Size(min = 1)
    private String primaryTitle;
    @NotNull
    private String originalTitle;
    @NotNull
    private  Integer startYear;
}
