package com.authentification.login.controller;

import com.authentification.login.entitiy.Poste;
import com.authentification.login.service.auth.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/posts")

public class PostController {

    @Autowired
    PosteService posteService;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Poste>> getAllPosts(){

       return  posteService.getAllPosts();
           }

}
