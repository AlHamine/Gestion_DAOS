package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;

@Repository
public interface ModuleRepository extends JpaRepository<com.uasz.Gestion_DAOS.model.Maquette.Module, Long> {
    @Query("SELECT e FROM Enseignement e WHERE e.module.id =:id")
    List<Enseignement> detailsModuleEnseignement(@Param("id") Long id);

}
