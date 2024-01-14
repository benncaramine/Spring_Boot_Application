package com.authentification.login.service.auth;

import com.authentification.login.JWT.JWTfilter;
import com.authentification.login.entitiy.*;
import com.authentification.login.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

@Service
public class EmpruntIMPL implements EmpruntService {

    // Autres autowired fields
@Autowired
JWTfilter jwTfilter;
@Autowired
AbonnementRepo abonnementRepo;
@Autowired
DocumentRepo documentRepo;

@Autowired
EmpruntRepo empruntRepo;

    @Autowired
    UserRepo userRepo;


    @Autowired
    LecteurRepo lecteurRepo;

    @Override
    public ResponseEntity<String> addEmprunt(Map<String, Long> RequestMap) {
        //log.info("dans add emprunt{}", RequestMap);

        if (jwTfilter.isUser() ) {
            // Création d'un nouvel objet Emprunt
            Emprunt emprunt = new Emprunt();

            // Récupération de l'abonnement et du document à partir de leur ID
            User user = userRepo.findByEmailId(jwTfilter.getMailbyToken());
            Lecteur lecteur = lecteurRepo.findByUser(user);

            // Récupérer l'abonnement associé au lecteur
            Abonnement abonnement = abonnementRepo.findByLecteur(lecteur);            Document document = documentRepo.getReferenceById(Math.toIntExact(RequestMap.get("document_id")));

            // Vérification de la validité de l'abonnement
            Date currentDate = new Date(System.currentTimeMillis());

            // Convertir la date actuelle en java.sql.Date si nécessaire
            Date sqlCurrentDate = new Date(currentDate.getTime());


              // Compare the expiration date with the current date
            if (abonnement != null  && abonnement.getDate_expiration().after(sqlCurrentDate)) {

                if(document.getEmpruntable()){

                    document.setEmpruntable(false);
                    // Calcul de la date de retour (30 jours après la date d'emprunt)
                    LocalDate dateEmprunt = LocalDate.now();
                    LocalDate dateRetour = dateEmprunt.plusDays(28);

                    // Mise à jour des dates d'emprunt et de retour de l'emprunt
                    emprunt.setDate_emprunt(Date.valueOf(dateEmprunt));
                    emprunt.setDate_retour(Date.valueOf(dateRetour));

                    // Attribution de l'abonnement et du document à l'emprunt
                    emprunt.setAbonnement(abonnement);
                    emprunt.setDocument(document);

                    // Enregistrement de l'emprunt dans le repository
                    empruntRepo.save(emprunt);

                    return ResponseEntity.ok("L'emprunt a été ajouté avec succès.");
                }else{
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ce document est deja emprunté.");
                }

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'abonnement est invalide ou a expiré.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non autorisé.");
        }
    }

}