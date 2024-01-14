package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.*;

@Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "admin_id")
    private Integer admin_id;

    @OneToOne
    @JoinColumn(name = "user_id") // Nom de la colonne de la clé étrangère dans la table Lecteur
    private User user;
}
