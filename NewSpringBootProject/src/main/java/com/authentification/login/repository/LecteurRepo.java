package com.authentification.login.repository;

import com.authentification.login.entitiy.Lecteur;
import com.authentification.login.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface LecteurRepo extends JpaRepository<Lecteur,Long> {
    Lecteur findByUser(User user);
}
