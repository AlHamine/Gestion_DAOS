package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.EC;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

@Repository
public interface UERepository extends JpaRepository<UE, Long> {
    // List<EC> findEcs();

    // @Query("SELECT c FROM ec c WHERE c.ue_id =:idUE")
    // List<EC> findEcs(@Param("idUE") Long idUE);

    // @Query(nativeQuery = true, value = "SELECT * FROM niveau WHERE cycle =:idc ")
    // List<Niveau> findByCycle(@Param("idc") Long idc);
}
