package com.authentification.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface EquipeBenevol extends JpaRepository<com.authentification.login.entitiy.EquipeBenevol,Integer > {
}
