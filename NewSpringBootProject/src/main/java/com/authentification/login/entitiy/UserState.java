package com.authentification.login.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserState {

    private Long Id;

    private String username;

    private String email;

    private String status;

    public Long getId() {
        return Id;
    }


    public UserState(Long Id, String username, String email, String status) {
        this.Id = Id;
        this.username = username;
        this.email = email;
        this.status = status;
    }

    public void setId(Long id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
