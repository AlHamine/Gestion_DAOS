package com.uasz.Gestion_DAOS.Repository.Maquette;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS.model.Maquette.Cycle;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {

    @Query("SELECT n FROM Niveau n WHERE n.cycle = ?1")
    List<Niveau> findByCycle(Cycle cycle);

    // @Query(nativeQuery = true, value = "SELECT * FROM niveau WHERE cycle =:idc ")
    // List<Niveau> findByCycle(@Param("idc") Long idc);

    // @Query(nativeQuery = true, value = "SELECT id FROM niveau WHERE cycle_id =:idCycle ")
    // List<Long> findByCycle(@Param("idCycle") Long idCycle);

}
