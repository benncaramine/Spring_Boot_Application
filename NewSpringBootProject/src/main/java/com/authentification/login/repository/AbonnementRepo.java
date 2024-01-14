package com.authentification.login.repository;

import com.authentification.login.entitiy.Abonnement;
import com.authentification.login.entitiy.Lecteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;



@EnableJpaRepositories
@Repository
public interface AbonnementRepo extends JpaRepository<Abonnement,Integer > {

    Abonnement findByLecteur(Lecteur lecteur);

}
