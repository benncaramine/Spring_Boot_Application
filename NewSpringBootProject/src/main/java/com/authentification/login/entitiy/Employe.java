package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "employe_id")
    private Integer employe_id;

    @OneToOne
    @JoinColumn(name = "user_id") // Nom de la colonne de la clé étrangère dans la table Lecteur
    private User user;
}
