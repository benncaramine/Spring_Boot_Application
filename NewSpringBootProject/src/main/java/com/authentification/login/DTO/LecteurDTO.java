package com.authentification.login.DTO;


import com.authentification.login.entitiy.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LecteurDTO {
    private Integer lecteur_id;

    private User user;
}
