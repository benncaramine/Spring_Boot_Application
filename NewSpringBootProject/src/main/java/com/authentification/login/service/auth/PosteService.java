package com.authentification.login.service.auth;

import com.authentification.login.entitiy.Poste;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PosteService {

    ResponseEntity<List<Poste>> getAllPosts();
}
