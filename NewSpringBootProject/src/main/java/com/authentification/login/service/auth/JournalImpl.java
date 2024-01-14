package com.authentification.login.service.auth;

import com.authentification.login.DTO.JournalDTO;
import com.authentification.login.Exeption.Exeptions;
import com.authentification.login.JWT.JWTfilter;
import com.authentification.login.entitiy.Document;
import com.authentification.login.entitiy.Journal;
import com.authentification.login.repository.DocumentRepo;
import com.authentification.login.repository.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class JournalImpl<T> implements JournalService{

    @Autowired
    private JournalRepo journalRepo;

    @Autowired
    private JWTfilter jwTfilter;

    @Autowired
    private DocumentRepo documentRepo;


    @Override
    public ResponseEntity<String> addJournal(JournalDTO journalDTO) {

        // Create a new Document for the Livre
        if(jwTfilter.isEmploye()  ){


            Document document = new Document();

            document.setTitre(journalDTO.getDocument().getTitre());
            document.setEmpruntable(false);
            document.setType(journalDTO.getDocument().getType());
            document.setQuantite(journalDTO.getDocument().getQuantite());
            document.setConsultable(true);
            document.setPrix(journalDTO.getDocument().getPrix());
            document.setQuantite(journalDTO.getDocument().getQuantite());
            document.setQuantite_disponible(journalDTO.getDocument().getQuantite_disponible());

            // Save the Document to generate its ID
            documentRepo.save(document);

            // Create a new Livre with the generated Document
             Journal journal = new Journal();
             journal.setDocument(document);

            // Save the Livre with the associated Document
            journalRepo.save(journal);
        } else {
            return Exeptions.getResposeEntity("Vous n'avez pas l'acces !", HttpStatus.UNAUTHORIZED);
        }
        return Exeptions.getResposeEntity("L'enregistrement de document est bien effectué.", HttpStatus.OK);
    }


    @Override
    public List<JournalDTO> getAllJournals() {
        List<Journal> getJournals = journalRepo.findAll();
        List<JournalDTO> journalDTOList = new ArrayList<>();
        for (Journal a : getJournals) {
            JournalDTO journalDTO = new JournalDTO(
                    a.getJournal_id(),
                    a.getDocument()
            );

            journalDTOList.add(journalDTO);
        }
        return journalDTOList;
    }



    @Override
    public String updateJournal(int id, JournalDTO journalDTO) {
        if(journalRepo.existsById(id)){
            Journal journal = journalRepo.getById(id);
            journal.setDocument(journalDTO.getDocument());

            journalRepo.save(journal);
        }
        else{
            System.out.println("journal id do not exist");
        }
        return null;
    }

    @Override
    public boolean deleteJournal(int id) {
        if (journalRepo.existsById(id)) {
            journalRepo.deleteById(id); // Delete the journal by id
            return true;
        } else {
            System.out.println("journal does not exist");
            return false;
        }
    }
}
