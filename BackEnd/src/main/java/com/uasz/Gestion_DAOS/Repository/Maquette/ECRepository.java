package com.uasz.Gestion_DAOS.Repository.Maquette;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.EC;


@Repository

public interface ECRepository extends JpaRepository<EC, Long> {

}
