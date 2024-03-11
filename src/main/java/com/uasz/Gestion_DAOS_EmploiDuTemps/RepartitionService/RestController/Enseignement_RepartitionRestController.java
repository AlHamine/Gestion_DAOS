// package com.uasz.Gestion_DAOS_Maquette.RepartitionService.RestController;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import com.uasz.Gestion_DAOS_Maquette.RepartitionService.model.Enseignement_Repartition;
// import com.uasz.Gestion_DAOS_Maquette.RepartitionService.model.Service.Enseignement_RepartitionService;

// // @CrossOrigin(origins = "*", allowedHeaders = "Authorization", methods = { RequestMethod.GET,
// //         RequestMethod.POST,
// //         RequestMethod.PATCH, RequestMethod.DELETE })
// @RestController
// @RequestMapping("/maquette/api")
// public class Enseignement_RepartitionRestController {
//     @Autowired
//     private Enseignement_RepartitionService enseignement_RepartitionService;

//     @GetMapping("/enseignements_Repartitions")
//     public List<Enseignement_Repartition> lister_Enseignement() {
//         return enseignement_RepartitionService.lister_Enseignement_Repartition();

//     }

//     @GetMapping("/enseignements_Repartitions/{id}")
//     public Enseignement_Repartition rechercherEnseignement_Repartition(@PathVariable Long id) {
//         return enseignement_RepartitionService.rechercherEnseignement_Repartition(id);

//     }
// }
