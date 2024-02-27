package com.uasz.Gestion_DAOS_Repartition.MSMaquette.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uasz.Gestion_DAOS_Repartition.MSMaquette.Model.UE;

@FeignClient(name = "maquette-service", url = "http://localhost:8081")
public interface UEProxy {
    @GetMapping(path = "/maquette/ue")
    List<UE> lister_ue();

    @GetMapping(path = "/maquette/ue/{id}")
    UE rechercher_ue(@PathVariable Long id);
}
