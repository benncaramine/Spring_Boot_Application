package com.authentification.login.entitiy;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "document")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Document {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
        @Column(name = "document_id")
        private Integer document_id;

        @Column(name = "titre")
        private String titre;

        @Column(name = "type")
        private String type;

        @Column(name = "prix")
        private Long prix;

        @Column(name = "consultable")
        private Boolean consultable;

        @Column(name = "empruntable")
        private Boolean empruntable;

        @Column(name = "quantite")
        private Integer quantite;

        @Column(name = "quantite_disponible")
        private Integer quantite_disponible;

}
