package com.authentification.login.JWT;

import com.authentification.login.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Service
public class UtilisateurDetails implements UserDetailsService {

     @Autowired
    UserRepo userRepo;

     private com.authentification.login.entitiy.User userEntity;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       userEntity=userRepo.findByEmailId(username);
       if(!Objects.isNull(userEntity))
           return new User(userEntity.getEmail(),userEntity.getPassword(),new ArrayList<>());
       else
           throw new UsernameNotFoundException("User not found");
    }

    public com.authentification.login.entitiy.User getUserEntity(){
        return userEntity;
    }
}
