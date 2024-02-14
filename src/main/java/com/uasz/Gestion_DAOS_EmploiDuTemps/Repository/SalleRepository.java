package com.uasz.Gestion_DAOS_EmploiDuTemps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Salle;


@Repository
/**
 * SalleRepository
 */
public interface SalleRepository extends JpaRepository<Salle,Long>{

    
}