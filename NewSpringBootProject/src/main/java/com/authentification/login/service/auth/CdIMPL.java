package com.authentification.login.service.auth;

import com.authentification.login.DTO.CdDTO;
import com.authentification.login.Exeption.Exeptions;
import com.authentification.login.JWT.JWTfilter;
import com.authentification.login.entitiy.Cd;
import com.authentification.login.entitiy.Document;
import com.authentification.login.repository.CdRepo;
import com.authentification.login.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service



public class CdIMPL<T> implements CdService{
    @Autowired
    private CdRepo cdRepo;

    @Autowired
    private JWTfilter jwTfilter;

    @Autowired
    private DocumentRepo documentRepo;



    @Override
    public ResponseEntity<String> addCd(CdDTO cdDTO) {
        // Create a new Document for the Livre
        if(jwTfilter.isEmploye()  ){


            Document document = new Document();

            document.setTitre(cdDTO.getDocument().getTitre());
            document.setEmpruntable(true);
            document.setType(cdDTO.getDocument().getType());
            document.setQuantite(cdDTO.getDocument().getQuantite());
            document.setConsultable(false);
            document.setPrix(cdDTO.getDocument().getPrix());
            document.setQuantite(cdDTO.getDocument().getQuantite());
            document.setQuantite_disponible(cdDTO.getDocument().getQuantite_disponible());

            // Save the Document to generate its ID
            documentRepo.save(document);

            // Create a new Livre with the generated Document
            Cd cd =  new Cd();
            cd.setDocument(document);

            // Save the Livre with the associated Document
            cdRepo.save(cd);
        } else {
            return Exeptions.getResposeEntity("Vous n'avez pas l'acces !", HttpStatus.UNAUTHORIZED);
        }
        return Exeptions.getResposeEntity("L'enregistrement de document est bien effectué.", HttpStatus.OK);

    }

    @Override
    public List<CdDTO> getAllCds() {
        List<Cd> getCds = cdRepo.findAll();
        List<CdDTO> cdDTOList = new ArrayList<>();
        for (Cd a : getCds) {
            CdDTO cdDTO = new CdDTO(
                    a.getCd_id(),
                    a.getDocument()
            );

            cdDTOList.add(cdDTO);
        }
        return cdDTOList;
    }

    @Override
    public String updateCd(int id, CdDTO cdDTO) {
        if(cdRepo.existsById(id)){
            Cd cd = cdRepo.getById(id);
            cd.setDocument(cdDTO.getDocument());

            cdRepo.save(cd);
        }
        else{
            System.out.println("cd id do not exist");
        }
        return null;
    }

    @Override
    public boolean deleteCd(int id) {
        if(cdRepo.existsById(id)){
            SimpleJpaRepository<T, Integer> cd = null;
            cd.deleteById(id);
        }
        else {
            System.out.println("cd doesnt exist");
        }
        return false;    }
}
