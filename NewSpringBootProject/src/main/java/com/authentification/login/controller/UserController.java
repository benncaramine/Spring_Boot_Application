package com.authentification.login.controller;

import com.authentification.login.DTO.MailStructure;
import com.authentification.login.Exeption.Exeptions;
import com.authentification.login.entitiy.User;
import com.authentification.login.service.MailService;
import com.authentification.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/user")

public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping(path = "/enregistrerLecteur")
    //Map : représente une structure de données qui associe des clés à des valeurs
    public ResponseEntity<String> enregistrerLecteur(@RequestBody(required = true)Map<String,String> RequestMap){

        try{
            return userservice.enregistrer(RequestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Exeptions.getResposeEntity("les donnees sont echouees",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(path = "/enregistrerEmploye")
    //Map : représente une structure de données qui associe des clés à des valeurs
    public ResponseEntity<String> enregistrerEmploye(@RequestBody(required = true)Map<String,String> RequestMap){

        try{
            return userservice.enregistrerEmploye(RequestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Exeptions.getResposeEntity("les donnees sont echouees",HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody (required = true) Map<String,String> RequestMap){
        try {
            return userservice.login(RequestMap);
        }catch (Exception e){

            e.printStackTrace();
        }
        return Exeptions.getResposeEntity("les donnees sont echouees",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<User>> getAllUser(){
        try {
            return userservice.getAllUser();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<User>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @GetMapping(path = "/getdemandes")
    public ResponseEntity<List<User>> getAllDeamndes(){
        try {
            return userservice.getdemandes();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<User>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody (required = true) Map<String,String> RequestMap){
        try {
            return userservice.update(RequestMap);
        }catch (Exception e){
            e.printStackTrace();

            return Exeptions.getResposeEntity("les donnees sont echouees",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/changePasswd")

    public ResponseEntity<String> changePasswd(@RequestBody (required = true) Map<String,String> RequestMap){
        try {
            return userservice.changePasswd(RequestMap);
        }catch (Exception e){
            e.printStackTrace();
            return Exeptions.getResposeEntity("les donnees sont echouees",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(path = "/motDePaseeOublie")
    public ResponseEntity<String> motDePaseeOublie(@RequestBody (required = true) Map<String,String> RequestMap){
        try {
            return userservice.motDePaseeOublie(RequestMap);
        }catch (Exception e){
            e.printStackTrace();
            return Exeptions.getResposeEntity("les donnees sont echouees",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Autowired
    private MailService mailService;


    @PostMapping(path = "/mail/{mail}")
    public String sendmail(@PathVariable String mail, @RequestBody MailStructure mailStructure){
        mailService.sendMail(mail,mailStructure);
        return "yes";
    }
}
