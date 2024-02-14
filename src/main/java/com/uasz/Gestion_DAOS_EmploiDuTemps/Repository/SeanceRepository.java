package com.uasz.Gestion_DAOS_EmploiDuTemps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;


/**
 * SeanceRepository
 */
@Repository
public interface SeanceRepository extends JpaRepository<Seance,Long>{

    
}