package com.formation.dating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entities.CentreInteret;

@Repository
public interface CentreInteretRepository extends JpaRepository<CentreInteret, Long>  {

}
