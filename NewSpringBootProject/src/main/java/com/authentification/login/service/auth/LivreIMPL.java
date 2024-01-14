package com.authentification.login.service.auth;

import com.authentification.login.DTO.LivreDTO;
import com.authentification.login.Exeption.Exeptions;
import com.authentification.login.JWT.JWTfilter;
import com.authentification.login.entitiy.Document;
import com.authentification.login.entitiy.Livre;
import com.authentification.login.repository.DocumentRepo;
import com.authentification.login.repository.LivreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class LivreIMPL implements LivreService{

    @Autowired
    private LivreRepo livreRepo;

    @Autowired
    private JWTfilter jwTfilter;

    @Autowired
    private DocumentRepo documentRepo;



    @Override
    public ResponseEntity<String> addLivre(LivreDTO livreDTO) {

        // Create a new Document for the Livre
        if(jwTfilter.isEmploye()  ){


            Document document = new Document();

            document.setTitre(livreDTO.getDocument().getTitre());
            document.setEmpruntable(true);
            document.setType(livreDTO.getDocument().getType());
            document.setQuantite(livreDTO.getDocument().getQuantite());
            document.setConsultable(true);
            document.setPrix(livreDTO.getDocument().getPrix());
            document.setQuantite(livreDTO.getDocument().getQuantite());
            document.setQuantite_disponible(livreDTO.getDocument().getQuantite_disponible());

            // Save the Document to generate its ID
            documentRepo.save(document);

            // Create a new Livre with the generated Document
            Livre livre = new Livre();
            livre.setAuteur(livreDTO.getAuteur());
            livre.setDocument(document);

            // Save the Livre with the associated Document
            livreRepo.save(livre);
        } else {
            return Exeptions.getResposeEntity("Vous n'avez pas l'acces !", HttpStatus.UNAUTHORIZED);
        }
        return Exeptions.getResposeEntity("L'enregistrement de document est bien effectué.", HttpStatus.OK);
    }


    @Override
    public List<LivreDTO> getAllLivres() {
        List<Livre> getLivres = livreRepo.findAll();
        List<LivreDTO> livreDTOList =  new ArrayList<>();
        for (Livre a:getLivres){
            LivreDTO livreDTO = new LivreDTO(
                    a.getLivre_id(),
                    a.getAuteur(),
                    a.getDocument()
            );

            livreDTOList.add(livreDTO);
        }
        return livreDTOList;    }

    @Override
    public String updateLivre(int id, LivreDTO livreDTO) {
        if(livreRepo.existsById(id)){
            Livre livre = livreRepo.getById(id);
            livre.setAuteur(livreDTO.getAuteur());
            livre.setDocument(livreDTO.getDocument());

            livreRepo.save(livre);
        }
        else{
            System.out.println("Livre id do not exist");
        }
        return null;
    }

    @Override
    public boolean deleteLivre(int id) {
        if(livreRepo.existsById(id)){
            livreRepo.deleteById(id);
        }
        else {
            System.out.println("livre doesnt exist");
        }
        return false;
    }
}
