package com.authentification.login.service.auth;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmpruntService {

    ResponseEntity<String> addEmprunt(Map<String, Long> RequestMap);}
