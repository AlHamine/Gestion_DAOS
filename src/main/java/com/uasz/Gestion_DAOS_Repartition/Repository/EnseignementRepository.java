package com.uasz.Gestion_DAOS_Repartition.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Repartition.model.Enseignement;

@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {

}