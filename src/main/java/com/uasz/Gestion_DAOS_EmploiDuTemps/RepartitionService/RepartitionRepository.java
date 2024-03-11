package com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.model.Repartition;




@Repository
public interface RepartitionRepository extends JpaRepository<Repartition,Long> {

}