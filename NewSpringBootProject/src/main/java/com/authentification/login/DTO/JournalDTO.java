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
public class JournalDTO {
    private  Integer journal_id;

    private Document document;
}
