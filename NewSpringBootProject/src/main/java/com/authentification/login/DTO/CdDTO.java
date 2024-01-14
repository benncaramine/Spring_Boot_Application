package com.authentification.login.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.authentification.login.entitiy.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CdDTO {
    private Integer cd_id;

    private Document document;
}
