package com.authentification.login.service.auth;

import com.authentification.login.JWT.JWTfilter;
import com.authentification.login.entitiy.*;
import com.authentification.login.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Map;

@Service
public class AchatIMPL implements AchatService {

    // Autres autowired fields
    @Autowired
    JWTfilter jwTfilter;

    @Autowired
    AbonnementRepo abonnementRepo;

    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    AchatRepo achatRepo;

    @Autowired
    DocumentService documentService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    LecteurRepo lecteurRepo;


    @Override
    public ResponseEntity<String> addAchat(Map<String, Long> requestMap) {
        if (jwTfilter.isUser()) {
            // Création d'un nouvel objet Achat
            Achat achat = new Achat();

            // Récupération de l'abonnement et du document à partir de leur ID
            User user = userRepo.findByEmailId(jwTfilter.getMailbyToken());
            Lecteur lecteur = lecteurRepo.findByUser(user);

            // Récupérer l'abonnement associé au lecteur
            Abonnement abonnement = abonnementRepo.findByLecteur(lecteur);
            Document document = documentRepo.getReferenceById(Math.toIntExact(requestMap.get("document_id")));

            // Vérification de la validité de l'abonnement
            Date currentDate = new Date(System.currentTimeMillis());

            // Comparaison de la date d'expiration avec la date actuelle
            if (abonnement != null && document != null   && abonnement.getDate_expiration() != null && abonnement.getDate_expiration().after(currentDate)) {
                if (document.getQuantite() > 0 && document.getPrix() < abonnement.getSolde()) {
                    // Mise à jour des quantités et du solde
                    abonnement.setSolde(abonnement.getSolde() - document.getPrix());
                    document.setQuantite_disponible(document.getQuantite_disponible() - 1);

                    // Attribution de l'abonnement et du document à l'achat
                    achat.setAbonnement(abonnement);
                    achat.setDocument(document);

                    // Enregistrement de l'achat dans le repository
                    achatRepo.save(achat);

                    ObjectMapper objectMapper = new ObjectMapper();
                    ObjectNode responseJson = objectMapper.createObjectNode();
                    responseJson.put("message", "L'achat a été effectué avec succès.");
                    responseJson.put("solde", abonnement.getSolde());

                    // Retourner la réponse JSON
                    return ResponseEntity.ok(responseJson.toString());                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Quantité insuffisante ou solde insuffisant.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'abonnement est invalide ou a expiré.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Utilisateur non autorisé.");
        }
    }
}