package com.authentification.login.service.auth;

import com.authentification.login.DTO.JournalDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JournalService {
    ResponseEntity<String> addJournal(JournalDTO journalDTO);

    List<JournalDTO> getAllJournals();


    String updateJournal(int id, JournalDTO journalDTO);

    boolean deleteJournal(int id) ;
}
