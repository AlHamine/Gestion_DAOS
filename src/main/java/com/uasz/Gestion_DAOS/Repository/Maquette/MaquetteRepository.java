package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Formation;
import com.uasz.Gestion_DAOS.model.Maquette.Maquette;
import com.uasz.Gestion_DAOS.model.Maquette.Module;


@Repository
public interface MaquetteRepository extends JpaRepository<Maquette, Long> {

    @Query("SELECT m FROM Module m WHERE m.maquette.id =:id")
    List<Module> moduleDetailsMaquette(@Param("id") Long id);

    @Query("SELECT f FROM Formation f WHERE f.maquette.id =:id")
    List<Formation> formationDetailsMaquette(@Param("id") Long id);

}
