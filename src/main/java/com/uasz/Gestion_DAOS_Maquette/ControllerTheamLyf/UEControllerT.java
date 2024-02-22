package com.uasz.Gestion_DAOS_Maquette.ControllerTheamLyf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.uasz.Gestion_DAOS_Maquette.Service.UEService;
import com.uasz.Gestion_DAOS_Maquette.model.UE;

@Controller
@RequestMapping("/maquette/test")
public class UEControllerT {

    @Autowired
    private UEService ueService;

    // Tehadfdf
    @RequestMapping(value = "/ue", method = RequestMethod.GET)
    public String lister_ue(Model model) {
        List<UE> ueList = ueService.afficherToutUE();
        model.addAttribute("listDesUE", ueList);
        return "ue";

    }

    // @GetMapping(path = "/ue")
    // public List<UE> listerUE() {
    // return ueService.afficherToutUE();
    // }

    // @GetMapping(path = "/ue/{id}")
    // public UE recherchUE(@PathVariable Long id) {
    // return ueService.rechercherUE(id);
    // }

    // @PostMapping(path = "/ue")
    // public UE ajouterUE(@RequestBody UE ue) {
    // return ueService.ajouterUE(ue);
    // }

    // @PutMapping(path = "/ue/{id}")
    // public UE modifierUE(@RequestBody UE ue, @PathVariable Long id) {
    // return ueService.modifierUE(ue);
    // }

    // @DeleteMapping(path = "/ue/{id}")
    // public ResponseEntity<String> supprimerUE(@PathVariable Long id) {
    // ueService.suprimerUE(id);
    // return new ResponseEntity<>("UE supprimée avec succès", HttpStatus.OK);
    // }
}
