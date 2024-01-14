package com.authentification.login.DTO;


import com.authentification.login.entitiy.Abonnement;
import com.authentification.login.entitiy.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultDTO {
    private Integer consult_id;


    private Abonnement abonnement;


    private Document document;
}
