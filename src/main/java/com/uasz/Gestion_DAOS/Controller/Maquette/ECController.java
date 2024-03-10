package com.uasz.Gestion_DAOS.Controller.Maquette;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ECService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.EC;

@Controller
public class ECController {

    @Autowired
    private ECService eCService;

    @Autowired
    private UEService euService;

    @RequestMapping(value = "/ec", method = RequestMethod.GET)
    public String lister_eC(Model model) {
        List<EC> eCList = eCService.afficherToutEC();
        model.addAttribute("listeDesEC", eCList);
        return "ec";
    }

    @RequestMapping(value = "/ajouter_ec", method = RequestMethod.POST)
    public String ajouter_ec(Model modele, EC ec, @RequestParam(name = "id") Long idUE) {
        ec.setUe(euService.rechercherUE(idUE));
        eCService.ajouterEC(ec);
        return "redirect:/details_ue?id=" + idUE;
    }

    @RequestMapping(value = "/supprimer_ec", method = RequestMethod.GET)
    public String supprimer_ue(Model modele, @RequestParam(name = "id") Long idEC,
            @RequestParam(name = "id2") Long idUE) {
        eCService.suprimerEC(idEC);
        return "redirect:/details_ue?id=" + idUE;
        // return "redirect:/ue";
    }

}