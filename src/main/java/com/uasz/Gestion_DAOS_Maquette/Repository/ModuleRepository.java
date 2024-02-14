package com.uasz.Gestion_DAOS_Maquette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.Gestion_DAOS_Maquette.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

}
