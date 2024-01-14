package com.authentification.login.controller;

import com.authentification.login.service.auth.AchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("Mediatheque/achat")
public class AchatController {

    @Autowired
    private AchatService achatService;

    @PostMapping(path = "/save")

    public ResponseEntity<String> saveAchat(@RequestBody Map<String,Long> RequestMap)
    {
        return achatService.addAchat(RequestMap);
    }
}
