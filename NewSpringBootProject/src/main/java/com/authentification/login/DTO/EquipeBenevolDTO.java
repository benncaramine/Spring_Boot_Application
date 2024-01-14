package com.authentification.login.DTO;

import com.authentification.login.entitiy.Lecteur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipeBenevolDTO {
    private Integer benevol_id;

    private Long equipe_id;

    private Lecteur lecteur;

}
