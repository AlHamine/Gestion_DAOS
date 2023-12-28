package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.Gestion_DAOS.Service.Maquette.SemestreService;
import com.uasz.Gestion_DAOS.model.Maquette.Semestre;

/**
 * UEController
 */
@Controller
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @RequestMapping(value = "/semestre", method = RequestMethod.GET)
    public String lister_semestre(Model model) {
        List<Semestre> semestreList = semestreService.afficherToutSemestre();
        model.addAttribute("listeDesSemestre", semestreList);
        return "semestre";
    }

    @RequestMapping(value = "/ajouter_semestre", method = RequestMethod.POST)
    public String ajouter_semestre(Model modele, Semestre semestre) {
        semestreService.ajouterSemestre(semestre);
        return "redirect:/semestre";
    }

}