package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "equipe_benevol")
public class EquipeBenevol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "benevol_id")
    private Integer benevol_id;

    @Column(name = "equipe_id")
    private Long equipe_id;


    @OneToOne
    @JoinColumn(name = "lecteur_id") // Nom de la colonne de la clé étrangère dans la table Lecteur
    private Lecteur lecteur;
}
