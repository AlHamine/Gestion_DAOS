package com.uasz.Gestion_DAOS_Maquette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Maquette.model.UE;

@Repository
public interface UERepository extends JpaRepository<UE, Long> {
    // List<EC> findEcs();
}