package com.authentification.login.controller;

import com.authentification.login.DTO.CdDTO;
import com.authentification.login.service.auth.CdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Mediatheque/cd")
public class CdController {
    @Autowired
    private CdService cdService;

    @PostMapping(path = "/save")

    public ResponseEntity<String> saveCd(@RequestBody CdDTO cdDTO)
    {
        return cdService.addCd(cdDTO);
    }

    @GetMapping(path = "/getAllCds")
    public List<CdDTO> getAllCds()
    {
        List<CdDTO>allCds = cdService.getAllCds();
        return allCds;
    }

    @PostMapping(path = "/update/{id}")
    public String updateCd(@PathVariable("id") int id, @RequestBody CdDTO cdDTO) {
        String result = cdService.updateCd(id, cdDTO);
        return result;
    }


    @DeleteMapping(path = "/deleteCd/{id}")
    public String deleteCd(@PathVariable(value = "id") int id) {
        boolean deleteCd = cdService.deleteCd(id);
        if (deleteCd) {
            return "deleted";
        } else {
            return "failed to delete";
        }
    }
}
