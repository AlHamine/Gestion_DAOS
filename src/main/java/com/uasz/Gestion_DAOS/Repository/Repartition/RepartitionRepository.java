package com.uasz.Gestion_DAOS.Repository.Repartition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Repartition.Repartition;

@Repository
/**
 * RepartitionRepository
 */
public interface RepartitionRepository extends JpaRepository<Repartition,Long> {

  
}