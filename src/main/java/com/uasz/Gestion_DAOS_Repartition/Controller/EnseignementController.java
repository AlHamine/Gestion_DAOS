// package com.uasz.Gestion_DAOS_Repartition.Controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;
// import
// com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Service.EnseignementService;

// @RestController
// @RequestMapping("/repartition")
// public class EnseignementController {

// @Autowired
// private EnseignementService enseignementService;

// @GetMapping(path = "/enseignement")
// public List<Enseignement> listerEnseignement() {
// return enseignementService.afficherToutEnseignement();
// }

// @GetMapping(path = "/enseignement/{id}")
// public Enseignement recherchEnseignement(@PathVariable Long id) {
// return enseignementService.rechercherEnseignement(id);
// }

// @PostMapping(path = "/enseignement")
// public Enseignement ajouterEnseignement(@RequestBody Enseignement
// Enseignement) {
// return enseignementService.ajouterEnseignement(Enseignement);
// }

// @PutMapping(path = "/enseignement/{id}")
// public Enseignement modifierEnseignement(@RequestBody Enseignement
// Enseignement, @PathVariable Long id) {
// return enseignementService.modifierEnseignement(Enseignement);
// }

// @DeleteMapping(path = "/enseignement/{id}")
// public ResponseEntity<String> supprimerEnseignement(@PathVariable Long id) {
// enseignementService.suprimerEnseignement(id);
// return new ResponseEntity<>("Enseignement supprimée avec succès",
// HttpStatus.OK);
// }
// }