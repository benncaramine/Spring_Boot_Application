package com.authentification.login.service.auth;

import com.authentification.login.JWT.JWTfilter;
import com.authentification.login.entitiy.*;
import com.authentification.login.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

@Service

public class ConsultIMPL implements  ConsultService{
    // Autres autowired fields
    @Autowired
    JWTfilter jwTfilter;
    @Autowired
    AbonnementRepo abonnementRepo;
    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ConsultRepo consultRepo;

    @Autowired
    LecteurRepo lecteurRepo;


    @Autowired
    PosteRepo posteRepo;
    @PersistenceContext
    private EntityManager entityManager; // Injectez l'EntityManager
    @Override
    public ResponseEntity<String> addConsult(Map<String, Long> RequestMap) {
        // Check if the user is authorized
        if (true) {
            // Create a new Consult object
            Consult consult = new Consult();

            User user = userRepo.findByEmailId(jwTfilter.getMailbyToken());
            Lecteur lecteur = lecteurRepo.findByUser(user);

            // Récupérer l'abonnement associé au lecteur
            Abonnement abonnement = abonnementRepo.findByLecteur(lecteur);


            Document document = documentRepo.getReferenceById(Math.toIntExact(RequestMap.get("document_id")));

            // Check the validity of the Abonnement
            Date currentDate = new Date(System.currentTimeMillis());
            Date sqlCurrentDate = new Date(currentDate.getTime());

            if (abonnement != null && abonnement.getDate_expiration().after(sqlCurrentDate)) {
                if (document.getConsultable()) {
                    document.setConsultable(false);

                    LocalDate dateEmprunt = LocalDate.now();
                    LocalDate dateRetour = dateEmprunt.plusDays(1);

                    consult.setDate_consult(Date.valueOf(dateEmprunt));
                    consult.setDate_expiration(Date.valueOf(dateRetour));
                    consult.setAbonnement(abonnement);
                    consult.setDocument(document);

                    if (document.getType().equals("microfilm")) {
                        TypedQuery<Poste> query = entityManager.createNamedQuery("Poste.GetPosteLibre", Poste.class);
                        query.setMaxResults(1);
                        Poste poste;

                        try {
                            poste = query.getSingleResult();
                            if (poste != null) {
                                poste.setDateConsult(consult.getDate_consult());
                                poste.setDateExpiration(consult.getDate_expiration());
                                poste.setAbonnement(abonnement);
                                poste.setDocument(document);
                                poste.setEtat(false);
                                posteRepo.save(poste);
                                consultRepo.save(consult);
                                return ResponseEntity.ok("La consultation a été enregistrée avec succès.");
                            } else {
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aucun poste libre n'est disponible.");
                            }
                        } catch (NoResultException e) {
                            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aucun poste libre n'est disponible.");
                        }
                    } else {
                        consultRepo.save(consult);
                        return ResponseEntity.ok("La consultation a été enregistrée avec succès.");
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ce document est déjà consulté par un autre utilisateur.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'abonnement est invalide ou a expiré.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non autorisé.");
        }
    }


    @Override
    public ResponseEntity<String> finConsult(Map<String, Long> RequestMap) {


        return null;
    }
}
