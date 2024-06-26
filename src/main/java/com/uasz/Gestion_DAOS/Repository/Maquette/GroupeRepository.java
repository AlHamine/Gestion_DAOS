package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    
    @Query("SELECT e FROM Enseignement e WHERE e.groupe.id =:id")
    List<Enseignement> groupeDetailsEnseignement(@Param("id") Long id);
}
