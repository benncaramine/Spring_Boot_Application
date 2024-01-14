package com.authentification.login.controller;

import com.authentification.login.DTO.MicroFilmDTO;
import com.authentification.login.service.auth.MicroFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Mediatheque/microfilm")
public class MicroFilmController {


    @Autowired
    private MicroFilmService microFilmService;

    @PostMapping(path = "/save")

    public ResponseEntity<String> saveMicroFilm(@RequestBody MicroFilmDTO microFilmDTO)
    {
        return microFilmService.addMicroFilm(microFilmDTO);
    }

    @GetMapping(path = "/getAllMicroFilms")
    public List<MicroFilmDTO> getAllMicroFilmss()
    {
        List<MicroFilmDTO> allMicroFilms = microFilmService.getAllMicroFilms();
        return allMicroFilms;
    }

    @PostMapping(path = "/update/{id}")
    public String updateMicroFilm(@PathVariable("id") int id, @RequestBody MicroFilmDTO microFilmDTO) {
        String result = microFilmService.updateMicroFilm(id, microFilmDTO);
        return result;
    }


    @DeleteMapping(path = "/deleteMicroFilm/{id}")
    public String deleteMicroFilm(@PathVariable(value = "id") int id)
    {
        boolean deleteMicroFilm = microFilmService.deleteMicroFilm(id);
        return "deleted";
    }

}
