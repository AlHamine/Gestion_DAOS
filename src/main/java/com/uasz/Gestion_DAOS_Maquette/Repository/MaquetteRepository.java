package com.uasz.Gestion_DAOS_Maquette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Maquette.model.Maquette;


@Repository
public interface MaquetteRepository extends JpaRepository<Maquette, Long> {

}
