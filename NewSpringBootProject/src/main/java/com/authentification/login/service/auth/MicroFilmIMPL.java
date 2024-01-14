package com.authentification.login.service.auth;

import com.authentification.login.DTO.MicroFilmDTO;
import com.authentification.login.Exeption.Exeptions;
import com.authentification.login.JWT.JWTfilter;
import com.authentification.login.entitiy.Document;
import com.authentification.login.entitiy.MicroFilm;
import com.authentification.login.repository.DocumentRepo;
import com.authentification.login.repository.MicroFilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MicroFilmIMPL <T> implements MicroFilmService{
    @Autowired
    private MicroFilmRepo microFilmRepo;

    @Autowired
    private JWTfilter jwTfilter;

    @Autowired
    private DocumentRepo documentRepo;


    @Override
    public ResponseEntity<String> addMicroFilm(MicroFilmDTO microFilmDTO) {

        // Create a new Document for the Livre
        if(jwTfilter.isEmploye()  ){


            Document document = new Document();

            document.setTitre(microFilmDTO.getDocument().getTitre());
            document.setEmpruntable(false);
            document.setType(microFilmDTO.getDocument().getType());
            document.setQuantite(microFilmDTO.getDocument().getQuantite());
            document.setConsultable(true);
            document.setPrix(microFilmDTO.getDocument().getPrix());
            document.setQuantite(microFilmDTO.getDocument().getQuantite());
            document.setQuantite_disponible(microFilmDTO.getDocument().getQuantite_disponible());

            // Save the Document to generate its ID
            documentRepo.save(document);

            // Create a new Livre with the generated Document
            MicroFilm microFil =  new MicroFilm();
            microFil.setDocument(document);

            // Save the Livre with the associated Document
            microFilmRepo.save(microFil);
        } else {
            return Exeptions.getResposeEntity("Vous n'avez pas l'acces !", HttpStatus.UNAUTHORIZED);
        }
        return Exeptions.getResposeEntity("L'enregistrement de document est bien effectué.", HttpStatus.OK);
    }

    @Override
    public List<MicroFilmDTO> getAllMicroFilms() {
        List<MicroFilm> getMicroFilms = microFilmRepo.findAll();
        List<MicroFilmDTO> MicroFilmDTOList = new ArrayList<>();
        for (MicroFilm a : getMicroFilms) {
            MicroFilmDTO microFilmDTO = new MicroFilmDTO(
                    a.getMicro_id(),
                    a.getDocument()
            );

            MicroFilmDTOList.add(microFilmDTO);
        }
        return MicroFilmDTOList;
    }



    @Override
    public String updateMicroFilm(int id, MicroFilmDTO microFilmDTO) {
        if(microFilmRepo.existsById(id)){
            MicroFilm microFilm = microFilmRepo.getById(id);
            microFilm.setDocument(microFilmDTO.getDocument());

            microFilmRepo.save(microFilm);
        }
        else{
            System.out.println("microFilm id do not exist");
        }
        return null;
    }

    @Override
    public boolean deleteMicroFilm(int id) {
        if (microFilmRepo.existsById(id)) {
            microFilmRepo.deleteById(id); // Delete the journal by id
            return true;
        } else {
            System.out.println("microFilm does not exist");
            return false;
        }
    }
}
