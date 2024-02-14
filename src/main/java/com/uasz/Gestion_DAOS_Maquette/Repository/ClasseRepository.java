package com.uasz.Gestion_DAOS_Maquette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Maquette.model.Classe;


@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    // @Query("SELECT n FROM Groupe n WHERE n.classe = ?1")
    // @Query(nativeQuery = true, value = "SELECT id, libelle, effectif, description
    // FROM groupe WHERE classe = :idc")
    // List<Object[]> findByClasse(@Param("idc") Long idc);

    // List<Groupe> findByClasse( Classe classe);
    // List<Groupe> groupeParClasse(@Param("idc") Long idc);

    // List<Groupe> findBGroupes();

}
