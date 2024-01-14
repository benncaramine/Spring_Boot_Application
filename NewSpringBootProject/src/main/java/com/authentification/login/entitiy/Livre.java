package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "livre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "livre_id")
    private Integer livre_id;

    // Autres champs spécifiques à Emprun

    @Column(name = "auteur")
    String auteur;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;


}
