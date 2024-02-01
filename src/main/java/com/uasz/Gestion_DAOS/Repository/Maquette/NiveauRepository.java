package com.uasz.Gestion_DAOS.Repository.Maquette;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Niveau;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {

}
