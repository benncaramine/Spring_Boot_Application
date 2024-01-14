package com.authentification.login.service.auth;

import com.authentification.login.DTO.DocumentDTO;

import java.util.List;

public interface DocumentService {

    String addDocument(DocumentDTO documentDTO);

    List<DocumentDTO> getAllDocuments();

    String updateDocument(int id,DocumentDTO documentDTO);

    boolean deleteDocument(int id);
}
