package com.authentification.login.controller;

import com.authentification.login.service.auth.EmpruntIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/emprunts")
public class EmpruntController {


    private final EmpruntIMPL empruntService;

    @Autowired
    public EmpruntController(EmpruntIMPL empruntService) {
        this.empruntService = empruntService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmprunt(@RequestBody Map<String,Long> RequestMap) {
        return empruntService.addEmprunt(RequestMap);
    }
}
