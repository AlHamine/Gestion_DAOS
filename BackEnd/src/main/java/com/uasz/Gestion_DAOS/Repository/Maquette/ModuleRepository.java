package com.uasz.Gestion_DAOS.Repository.Maquette;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<com.uasz.Gestion_DAOS.model.Maquette.Module, Long> {

}
