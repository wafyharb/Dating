package com.formation.dating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entities.Situation;

@Repository
public interface SituationRepository extends JpaRepository<Situation, Long> {

}
