package com.authentification.login.DTO;

import com.authentification.login.entitiy.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MicroFilmDTO {
    private Integer micro_id;

    private Document document;
}
