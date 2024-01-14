package com.authentification.login.DTO;


import com.authentification.login.entitiy.Abonnement;
import com.authentification.login.entitiy.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpruntDTO {
    private Integer emprunt_id;

    Date date_emprunt;

    Date date_retour;

    private Abonnement abonnement;

    private Document document;
}
