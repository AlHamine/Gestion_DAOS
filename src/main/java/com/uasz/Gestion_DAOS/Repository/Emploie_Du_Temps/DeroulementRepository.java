package com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;

/**
 * DeroulementRepository
 */
@Repository
public interface DeroulementRepository extends JpaRepository<Deroulement,Long> {

    
}