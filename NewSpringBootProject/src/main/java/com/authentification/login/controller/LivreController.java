package com.authentification.login.controller;

import com.authentification.login.DTO.LivreDTO;
import com.authentification.login.service.auth.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Mediatheque/livre")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @PostMapping(path = "/save")

    public ResponseEntity<String> saveLivre(@RequestBody LivreDTO livreDTO)
    {
        return livreService.addLivre(livreDTO);
    }

    @GetMapping(path = "/getAllLivres")
    public List<LivreDTO> getAllLivres()
    {
        List<LivreDTO>allLivres = livreService.getAllLivres();
        return allLivres;
    }

    @PostMapping(path = "/update/{id}")
    public String updateLivre(@PathVariable("id") int id, @RequestBody LivreDTO livreDTO) {

        String result = livreService.updateLivre(id, livreDTO);
        return result;
    }


    @DeleteMapping(path = "/deleteLivre/{id}")
    public String deleteLivre(@PathVariable(value = "id") int id)
    {
        boolean deleteLivre = livreService.deleteLivre(id);
        return "deleted";
    }
}
