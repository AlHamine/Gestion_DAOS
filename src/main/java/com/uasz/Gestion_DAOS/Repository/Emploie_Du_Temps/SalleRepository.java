package com.uasz.Gestion_DAOS.Repository.Emploie_Du_Temps;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;

import jakarta.websocket.server.PathParam;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM salle WHERE batiment_id = :batimentId")
    List<Salle> findByBatiment(@PathParam("batimentId") Long batimentId);

}
