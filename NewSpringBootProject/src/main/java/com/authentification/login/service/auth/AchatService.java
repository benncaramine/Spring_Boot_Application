package com.authentification.login.service.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public interface AchatService {

    ResponseEntity<String> addAchat(Map<String, Long> RequestMap);}

