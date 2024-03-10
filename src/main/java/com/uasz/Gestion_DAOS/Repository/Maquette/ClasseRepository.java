package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    // @Query("SELECT n FROM Groupe n WHERE n.classe = ?1")
    // @Query(nativeQuery = true, value = "SELECT id, libelle, effectif, description
    // FROM groupe WHERE classe = :idc")
    // List<Object[]> findByClasse(@Param("idc") Long idc);

    // List<Groupe> findByClasse( Classe classe);
    // List<Groupe> groupeParClasse(@Param("idc") Long idc);

    // List<Groupe> findBGroupes();

    @Query("SELECT g FROM Groupe g WHERE g.classe.id =:id")
    List<Groupe> classeDetailsGroupe(@Param("id") Long id);

    @Query("SELECT e FROM Enseignement e WHERE e.classe.id =:id")
    List<Enseignement> classeDetailsEnseignement(@Param("id") Long id);

}
