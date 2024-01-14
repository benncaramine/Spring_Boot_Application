package com.authentification.login.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbonnementDTO  {


    Long abonnementId;

    Date date_expiration;

    Date date_inscription;

    Long solde;



}
