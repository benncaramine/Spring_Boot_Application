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
@Table(name = "consult")
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "consult_id")
    private Integer consult_id;



    @Column(name = "date_consult")
    Date date_consult;

    @Column(name = "date_expiration")
    Date date_expiration;




    @ManyToOne
    //@JoinColumn(name = "abonnement_id", referencedColumnName = "id")
    @JoinColumn(name = "abonnement_id")

    private Abonnement abonnement;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;




}
