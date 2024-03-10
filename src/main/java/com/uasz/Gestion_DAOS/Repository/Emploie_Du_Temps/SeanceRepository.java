package com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Seance;

import org.springframework.data.repository.query.Param;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM seance WHERE emploi_id = :emploiId")
    List<Seance> findByEmploi(@Param("emploiId") Long emploiId);

}
