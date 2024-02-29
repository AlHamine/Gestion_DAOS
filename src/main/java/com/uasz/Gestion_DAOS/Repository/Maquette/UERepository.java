package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.EC;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

@Repository
public interface UERepository extends JpaRepository<UE, Long> {
    // List<EC> findEcs();
}
