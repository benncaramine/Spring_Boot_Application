package com.authentification.login.service.auth;

import com.authentification.login.DTO.MicroFilmDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MicroFilmService {
    ResponseEntity<String> addMicroFilm(MicroFilmDTO microFilmDTO);

    List<MicroFilmDTO> getAllMicroFilms();


    String updateMicroFilm(int id, MicroFilmDTO microFilmDTO);

    boolean deleteMicroFilm(int id) ;
}
