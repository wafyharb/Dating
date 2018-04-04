package com.formation.dating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entities.Apparence;

@Repository
public interface ApparenceRepository extends JpaRepository<Apparence, Long> {

}
