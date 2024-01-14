package com.authentification.login.repository;

import com.authentification.login.entitiy.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepo extends JpaRepository<Poste, Integer> {
}
