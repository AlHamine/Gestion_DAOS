// package com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.context.annotation.Bean;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Interface.MaquetteProxy;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// // @Data
// @RestController
// @RequestMapping("/repartition")
// public class EnseignementController {

//     private final MaquetteProxy mProxy;
//     @Autowired
//     EnseignantRepository enseignantRepository;

//     public EnseignementController(MaquetteProxy mProxy) {
//         this.mProxy = mProxy;

//     }

//     @DeleteMapping("/maquette/enseignement/{id}")
//     public Boolean supprimerEnsignement(@PathVariable Long id) {
//         enseignantRepository.deleteById(id);//SUpprimer la copie
//         return mProxy.supprimerEnseignement(id); //Puis l'original
//     }

//     // @PatchMapping()
// }
