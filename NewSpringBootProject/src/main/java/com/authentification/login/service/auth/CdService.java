package com.authentification.login.service.auth;

import com.authentification.login.DTO.CdDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface CdService {
    ResponseEntity<String> addCd(CdDTO cdDTO);

    List<CdDTO> getAllCds();

    String updateCd(int id,CdDTO cdDTO);

      boolean deleteCd(int id) ;
}
