package com.authentification.login.controller;


import com.authentification.login.DTO.DocumentDTO;
import com.authentification.login.service.auth.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Mediatheque/Document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping(path = "/save")

    public String saveDocument(@RequestBody DocumentDTO documentDTO)
    {
        String id = documentService.addDocument(documentDTO);
        return id;
    }

    @GetMapping(path = "/getAllDocuments")
    public List<DocumentDTO> getAllDocuments()
    {
        List<DocumentDTO>allDocuments = documentService.getAllDocuments();
        return allDocuments;
    }

    @PostMapping(path = "/update/{id}")
    public String updateDocument(@PathVariable("id") int id, @RequestBody DocumentDTO documentDTO) {
        String result = documentService.updateDocument(id, documentDTO);
        return result;
    }


    @DeleteMapping(path = "/deleteDocument/{id}")
    public String deleteDocument(@PathVariable(value = "id") int id)
    {
        boolean deleteDocument = documentService.deleteDocument(id);
        return "deleted";
    }

}