package com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;

/**
 * DeroulementRepository
 */
@Repository
public interface DeroulementRepository extends JpaRepository<Deroulement, Long> {

    @Query(value = "SELECT * FROM deroulement WHERE seance_id = :seanceId", nativeQuery = true)
    Deroulement deroulementBySeance(@Param("seanceId") Long seanceId);

}