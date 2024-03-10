package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.EC;


@Repository

public interface ECRepository extends JpaRepository<EC, Long> {

    @Query("SELECT m FROM Module m WHERE m.ec.id =:id")
    List<com.uasz.Gestion_DAOS.model.Maquette.Module> ecDetailsModule(@Param("id") Long id);

}
