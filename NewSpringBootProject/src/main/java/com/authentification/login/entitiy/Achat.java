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
@Table(name = "achat")
public class Achat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment;
    @Column(name = "achat_id")
    private Integer achat_id;

    @Column(name = "date_achat")
    Date date_achat;

    @ManyToOne
    //@JoinColumn(name = "abonnement_id", referencedColumnName = "id")
    @JoinColumn(name = "abonnement_id")

    private Abonnement abonnement;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;


}
