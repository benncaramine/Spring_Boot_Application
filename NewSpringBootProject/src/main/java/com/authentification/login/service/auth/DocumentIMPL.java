package com.authentification.login.service.auth;

import com.authentification.login.DTO.DocumentDTO;
import com.authentification.login.entitiy.Document;
import com.authentification.login.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class DocumentIMPL implements DocumentService{

    @Autowired
    private DocumentRepo documentRepo;

    @Override
    public String addDocument(DocumentDTO documentDTO) {


        Document document = new Document(
                documentDTO.getDocument_id(),
                documentDTO.getTitre(),
                documentDTO.getType(),
                documentDTO.getPrix(),
                documentDTO.getConsultable(),
                documentDTO.getEmpruntable(),
                documentDTO.getQuantite(),
                documentDTO.getQuantite_disponible()
        );

        documentRepo.save(document);
        return document.getTitre();
    }

    @Override
    public List<DocumentDTO> getAllDocuments() {
        List<Document> documents = documentRepo.findAll();
        return documents.stream()
                .map(document -> new DocumentDTO(
                        document.getDocument_id(),
                        document.getTitre(),
                        document.getType(),
                        document.getPrix(),
                        document.getConsultable(),
                        document.getEmpruntable(),
                        document.getQuantite(),
                        document.getQuantite_disponible()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public String updateDocument(int id, DocumentDTO documentDTO) {
        if(documentRepo.existsById(id)){
            Document document = documentRepo.getById(id);
                    document.setTitre(documentDTO.getTitre());
            document.setType(documentDTO.getType());
                    document.setPrix(documentDTO.getPrix());
                    document.setConsultable( documentDTO.getConsultable());
                    document.setEmpruntable(documentDTO.getEmpruntable());
                    document.setQuantite(documentDTO.getQuantite());
                    document.setQuantite_disponible(documentDTO.getQuantite_disponible());

            documentRepo.save(document);
        }
        else{
            System.out.println("Document id do not exist");
        }
        return null;
    }

    @Override
    public boolean deleteDocument(int id) {
        if(documentRepo.existsById(id)) {
            documentRepo.deleteById(id);
            return true; // retourne true si la suppression est réussie
        } else {
            System.out.println("Document does not exist");
            return false; // retourne false si le document n'existe pas
        }
    }

}
