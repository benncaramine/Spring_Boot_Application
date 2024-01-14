package com.authentification.login.DTO;

import com.authentification.login.entitiy.Abonnement;
import com.authentification.login.entitiy.Document;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PosteDTO {


    private Integer Poste_id;


    private int numero;





    Date date_consult;


    Date date_expiration;




    @ManyToOne
    //@JoinColumn(name = "abonnement_id", referencedColumnName = "id")
    @JoinColumn(name = "abonnement_id")

    private Abonnement abonnement;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
