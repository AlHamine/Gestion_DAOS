package com.uasz.Gestion_DAOS_EmploiDuTemps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;

/**
 * SeanceRepository
 */
@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM seance WHERE emploi_id = :emploiId")
    List<Seance> findByEmploi(@Param("emploiId") Long emploiId);

}