package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Filiere;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;


@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    @Query("SELECT f FROM Formation f WHERE f.filiere = ?1")
    List<Formation> findByFormation(Filiere filiere);
}
