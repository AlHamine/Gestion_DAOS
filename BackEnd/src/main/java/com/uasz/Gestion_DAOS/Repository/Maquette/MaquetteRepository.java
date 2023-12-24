package com.uasz.Gestion_DAOS.Repository.Maquette;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Maquette;


@Repository
public interface MaquetteRepository extends JpaRepository<Maquette, Long> {

}
