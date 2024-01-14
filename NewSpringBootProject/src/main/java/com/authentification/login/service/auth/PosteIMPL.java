package com.authentification.login.service.auth;

import com.authentification.login.entitiy.Poste;
import com.authentification.login.repository.PosteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteIMPL implements PosteService{


    @Autowired
    private PosteRepo posteRepo;

    @Override
    public ResponseEntity<List<Poste>> getAllPosts() {
        List<Poste> allPosts = posteRepo.findAll();
        return ResponseEntity.ok().body(allPosts);
    }
}
