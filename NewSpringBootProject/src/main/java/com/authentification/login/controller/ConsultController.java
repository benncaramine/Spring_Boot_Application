package com.authentification.login.controller;

import com.authentification.login.service.auth.ConsultIMPL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/consult")
public class ConsultController {

    private final ConsultIMPL consultIMPL;

    public ConsultController(ConsultIMPL consultIMPL) {
        this.consultIMPL = consultIMPL;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addConsult(@RequestBody Map<String,Long> RequestMap) {
        return consultIMPL.addConsult(RequestMap);
    }
}
