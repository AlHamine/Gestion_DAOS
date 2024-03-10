package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Semestre;


@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    @Query("SELECT c FROM Classe c WHERE c.semestre.id =:id")
    List<Classe> semestreDetailsClasse(@Param("id") Long id);

    @Query("SELECT m FROM Module m WHERE m.semestre.id =:id")
    List<com.uasz.Gestion_DAOS.model.Maquette.Module> semestreDetailsModule(@Param("id") Long id);
}
