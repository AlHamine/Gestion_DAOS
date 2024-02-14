package com.uasz.Gestion_DAOS_Maquette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Maquette.model.Formation;

// import com.uasz.Gestion_DAOS.model.Maquette.Niveau;


@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    // @Query("SELECT n FROM Niveau n WHERE n.formation = ?1")
    // List<Niveau> findByNiveau(Formation formation);
}
