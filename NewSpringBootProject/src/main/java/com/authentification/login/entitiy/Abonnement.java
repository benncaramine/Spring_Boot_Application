package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "abonnement")
@Builder
public class Abonnement {

    @Id
    @Column(name = "abonnement_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer abonnementId;

    @Column(name = "date_expiration")
    Date date_expiration;

    @Column(name = "date_inscription")
    Date date_inscription;

    @Column(name = "solde",length = 50)
    Long solde;

    @OneToOne
    @JoinColumn(name = "lecteur_id") // Nom de la colonne de la clé étrangère dans la table Lecteur
    private Lecteur lecteur;


}
