package com.authentification.login.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {

    private Integer document_id;

    private String titre;

    private String type;

    private Long prix;

    private Boolean consultable;

    private Boolean empruntable;

    private Integer quantite;

    private Integer quantite_disponible;
}
