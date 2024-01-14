package com.authentification.login.DTO;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

}
