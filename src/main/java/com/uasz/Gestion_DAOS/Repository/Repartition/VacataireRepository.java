package com.uasz.Gestion_DAOS.Repository.Repartition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;

@Repository
/**
 * VacataireRepository
 */
public interface VacataireRepository extends JpaRepository<Vacataire,Long> {

    
}
