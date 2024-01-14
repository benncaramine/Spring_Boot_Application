package com.authentification.login.service;

import com.authentification.login.entitiy.User;
import com.authentification.login.entitiy.UserState;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserServiceImp {

       ResponseEntity<String> enregistrer(Map<String,String> RequestMap);

       ResponseEntity<String> enregistrerEmploye(Map<String,String> RequestMap);

       ResponseEntity<String> login(Map<String,String> RequestMap);


       ResponseEntity<List<User>> getAllUser();

       ResponseEntity<List<User>> getdemandes();

       ResponseEntity<String> update(Map<String,String> RequestMap);

       ResponseEntity<String> changePasswd(Map<String,String> RequestMap);

       ResponseEntity<String> motDePaseeOublie(Map<String,String> RequestMap);



}
