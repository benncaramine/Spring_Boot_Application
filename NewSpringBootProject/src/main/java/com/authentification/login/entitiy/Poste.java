package com.authentification.login.entitiy;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import java.util.Date;


@NamedQuery(name = "Poste.GetPosteLibre",query = "select P from Poste P where P.etat=true ")

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "Poste_id")
    private Integer posteId;

    @Column(name = "numero")

    private int numero;

    @Column(name="etat")
    private boolean etat;

    @Column(name = "date_consult")
    private Date dateConsult;

    @Column(name = "date_expiration")
    private Date dateExpiration;

    @ManyToOne
    @JoinColumn(name = "abonnement_id")
    private Abonnement abonnement;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
