package com.authentification.login.DTO;

import com.authentification.login.entitiy.Enum.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int id;
    private String email;
    private String name;
    private UserRole role;
}
