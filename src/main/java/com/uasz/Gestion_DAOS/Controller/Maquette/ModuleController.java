package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.ModuleService;
import com.uasz.Gestion_DAOS.model.Maquette.Module;

/**
 * UEController
 */
@Controller
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/module", method = RequestMethod.GET)
    public String lister_module(Model model) {
        List<Module> moduleList = moduleService.afficherToutModule();
        model.addAttribute("listeDesModule", moduleList);
        return "module";
    }

    @RequestMapping(value = "/ajouter_module", method = RequestMethod.POST)
    public String ajouter_module(Model modele, Module module) {
        moduleService.ajouterModule(module);
        return "redirect:/module";
    }

}