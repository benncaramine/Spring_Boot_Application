package com.authentification.login.service.auth;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ConsultService {
    ResponseEntity<String> addConsult(Map<String, Long> RequestMap);

    ResponseEntity<String> finConsult(Map<String, Long> RequestMap);


}

