package com.uasz.Gestion_DAOS_Repartition.MSMaquette.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS_Repartition.MSMaquette.Model.UE;
import com.uasz.Gestion_DAOS_Repartition.MSMaquette.Service.UEProxy;

import lombok.AllArgsConstructor;
import lombok.Data;

// @Data
@Controller
@RequestMapping("/repartition/maquette")
public class UEControllerU {

    private final UEProxy ueProxy;

    public UEControllerU(UEProxy ueProxy) {
        this.ueProxy = ueProxy;
    }

    // @RequestMapping(value = "/repartition/ue", method = RequestMethod.GET)
    @GetMapping("/ue")
    public String listeur_ue(Model model) {
        List<UE> ueList = ueProxy.lister_ue();
        model.addAttribute("listeDesUE", ueList);
        return "ue.html";
    }

}
