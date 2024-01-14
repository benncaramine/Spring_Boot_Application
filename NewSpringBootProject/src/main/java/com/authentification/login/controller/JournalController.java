package com.authentification.login.controller;

import com.authentification.login.DTO.JournalDTO;
import com.authentification.login.service.auth.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Mediatheque/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping(path = "/save")

    public ResponseEntity<String> saveJournal(@RequestBody JournalDTO journalDTO)
    {
        return journalService.addJournal(journalDTO);

    }

    @GetMapping(path = "/getAllJournaux")
    public List<JournalDTO> getAllDocuments()
    {
        List<JournalDTO> allJournals = journalService.getAllJournals();
        return allJournals;
    }

    @PostMapping(path = "/update/{id}")
    public String updateJournal(@PathVariable("id") int id, @RequestBody JournalDTO journalDTO) {
        String result = journalService.updateJournal(id, journalDTO);
        return result;
    }


    @DeleteMapping(path = "/deleteJournal/{id}")
    public String deleteJournal(@PathVariable(value = "id") int id)
    {
        boolean deleteJournal = journalService.deleteJournal(id);
        return "deleted";
    }
}
