package com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Repartition.Emploi_Service.Model.Seance;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

}
