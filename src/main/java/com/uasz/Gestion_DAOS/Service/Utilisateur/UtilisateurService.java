// package com.uasz.Gestion_DAOS.Service.Utilisateur;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.uasz.Gestion_DAOS.Repository.Utilisateur.UtilisateurRepository;
// import com.uasz.Gestion_DAOS.model.Utilisateur.Utilisateur;



// @Service
// public class UtilisateurService {

//     private final UtilisateurRepository utilisateurRepository;

//     @Autowired
//     public UtilisateurService(UtilisateurRepository utilisateurRepository) {
//         this.utilisateurRepository = utilisateurRepository;
//     }

//     public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
//         return utilisateurRepository.save(utilisateur);
//     }

//     public List<Utilisateur> obtenirTousLesUtilisateurs() {
//         return utilisateurRepository.findAll();
//     }
// }
