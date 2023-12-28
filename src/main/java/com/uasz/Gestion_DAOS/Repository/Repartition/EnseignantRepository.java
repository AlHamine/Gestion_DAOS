package com.uasz.Gestion_DAOS.Repository.Repartition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;

@Repository
/**
 * EnseignantRepository
 */
public interface EnseignantRepository extends JpaRepository<Enseignant,Long>{

    
}