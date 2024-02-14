package com.uasz.Gestion_DAOS_EmploiDuTemps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Batiment;


@Repository
public interface BatimentRepository extends JpaRepository<Batiment,Long>{

    
} 