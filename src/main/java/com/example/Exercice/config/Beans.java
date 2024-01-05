package com.example.Exercice.config;

import com.example.Exercice.entity.Film;
import com.example.Exercice.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    //@Autowired
    //private VaultTemplate vaultTemplate;
    @Bean
    CommandLineRunner start(FilmRepository repository){
        return args -> {
            //vaultTemplate.opsForVersionedKeyValue()

            repository.save(new Film(1L, "Hanger", "Game", 2002));
            repository.save(new Film(2L, "After", "Tomorrow", 2010));
            repository.save(new Film(3L, "Fast", "Furious", 2020));
            repository.findAll().forEach(c->{System.out.println(c.toString());});
        };
    }
}