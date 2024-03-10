// package com.uasz.Gestion_DAOS.Controller.Repartition;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

// import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;
// import com.uasz.Gestion_DAOS.model.Repartition.Repartition;

// @Controller
// public class RepartitionController {

// @Autowired
// private RepartitionService repartitionService;

// @RequestMapping(value = "/repartition", method = RequestMethod.GET)
// public String lister_repartition(Model model) {
// List<Repartition> repartitionList =
// repartitionService.afficherToutRepartition();
// model.addAttribute("listeDesRepartition", repartitionList);
// return "repartition";
// }

// @RequestMapping(value = "/ajouter_repartition", method = RequestMethod.POST)
// public String ajouter_repartition(Model modele, Repartition repartition) {
// repartitionService.ajouterRepartition(repartition);
// return "redirect:/repartition";
// }

// }