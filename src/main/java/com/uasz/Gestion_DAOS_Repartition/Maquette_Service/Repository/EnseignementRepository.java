package com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;

@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {

}
