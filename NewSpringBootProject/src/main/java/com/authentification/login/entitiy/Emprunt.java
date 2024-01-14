package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "emprunt")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "emprunt_id")
    private Integer emprunt_id;

        // Autres champs spécifiques à Emprun

        @Column(name = "date_emprunt")
        Date date_emprunt;

        @Column(name = "date_retour")
        Date date_retour;

    @ManyToOne
    //@JoinColumn(name = "abonnement_id", referencedColumnName = "id")
    @JoinColumn(name = "abonnement_id")

    private Abonnement abonnement;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
