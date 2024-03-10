package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;
// import com.uasz.Gestion_DAOS.model.Maquette.Niveau;


@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

    // @Query("SELECT n FROM Niveau n WHERE n.formation = ?1")
    // List<Niveau> findByNiveau(Formation formation);

    @Query("SELECT c FROM Classe c WHERE c.formation.id =:id")
    List<Classe> formationDetailsClasse(@Param("id") Long id);
}
