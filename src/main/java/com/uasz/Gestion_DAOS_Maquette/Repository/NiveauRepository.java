package com.uasz.Gestion_DAOS_Maquette.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Maquette.model.Formation;
import com.uasz.Gestion_DAOS_Maquette.model.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {

    @Query("SELECT f FROM Formation f WHERE f.niveau = ?1")
    List<Formation> findByFormation(Niveau niveau);
}
