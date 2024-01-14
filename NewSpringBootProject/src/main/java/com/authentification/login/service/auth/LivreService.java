package com.authentification.login.service.auth;

import com.authentification.login.DTO.LivreDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LivreService {
    ResponseEntity<String> addLivre(LivreDTO livreDTO);

    List<LivreDTO> getAllLivres();

    String updateLivre(int id,LivreDTO livreDTO);

    boolean deleteLivre(int id);
}
