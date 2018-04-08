package com.formation.dating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
  Utilisateur findUtilisateurByEmailAndMotDePass(String email, String motDePAss);

Utilisateur findUtilisateurByEmail(String email);
}
