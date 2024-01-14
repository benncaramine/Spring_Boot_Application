package com.authentification.login.repository;

import com.authentification.login.entitiy.Emprunt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface EmpruntRepo extends JpaRepository<Emprunt,Integer > {
}
