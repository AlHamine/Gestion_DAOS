package com.uasz.Gestion_DAOS_Repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Interface.MaquetteProxy;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Service.EnseignementService;
import com.uasz.Gestion_DAOS_Repartition.Service.PERService;
import com.uasz.Gestion_DAOS_Repartition.Service.VacataireService;
import com.uasz.Gestion_DAOS_Repartition.model.PER;
import com.uasz.Gestion_DAOS_Repartition.model.Vacataire;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GestionDaosRepartitionApplication implements CommandLineRunner {

	@Autowired // Ajout de l'annotation @Autowired
	EnseignementService enseignementService;
	@Autowired // Ajout de l'annotation @Autowired
	VacataireService vacataireService;
	@Autowired // Ajout de l'annotation @Autowired
	PERService perService;

	public static void main(String[] args) {

		SpringApplication.run(GestionDaosRepartitionApplication.class, args);
	}

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 		public void addCorsMappings(CorsRegistry registry) {
	// 			registry.addMapping("/repartition/**").allowedOrigins("http://localhost:3000");
	// 		}
	// 	};
	// }

	private final MaquetteProxy maquetteProxy;

	public GestionDaosRepartitionApplication(EnseignementService enseignementService, MaquetteProxy maquetteProxy) {
		this.enseignementService = enseignementService;
		this.maquetteProxy = maquetteProxy;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(maquetteProxy.lister_enseignements_Repartitions());
		List<Enseignement> enseignements = maquetteProxy.lister_enseignements_Repartitions();
		for (Enseignement enseignement : enseignements) {
			enseignementService.ajouter_Enseignement(enseignement);

		}
		// enseignementService.ajouterEnseignement(new Enseignement(null, "libelle",
		// null, "description"));
		// System.out.println(ueProxy.lister_ue());

		// Les enseignants
		String[] noms = { "DIOP", "DRAME", "NDOYE", "NDIAYE", "FAYE", "FAYE", "NDIAYE", "DIAW" };
		String[] prenoms = { "Ibrahima", "Khadim", "Malick", "Mr", "Youssou", "El Hadji", "Marie", "Mame Kouna" };
		String[] grades = { "Professeur", "Docteur", "Maître de conférences", "Docteur",
				"Professeur", "Docteur", "Professeur", "Doctoreur" };
		String[] matricules = { "MAT001", "MAT002", "MAT003", "MAT004", "MAT005", "MAT003", "MAT004", "MatrK83" };

		String[] specialites = { "Genie Logiciel", "IA", "Reseaux",
				"Droit", "Securite et Reseaux", "Reseaux et Telecom",
				"Genie Logiciel", "Anglais" };

		// // Créez et ajoutez 5 objets PER à la base de données
		for (int i = 0; i < 8; i++) {
			PER per = new PER();
			per.setNom(noms[i]);
			per.setPrenom(prenoms[i]);
			per.setGrade(grades[i]);
			per.setMatricule(matricules[i]);
			per.setSpecialite(specialites[i]);
			// Exemple de date de naissance

			// Ajoutez cet objet PER à la base de données en utilisant le service a//
			// appropriépproprié

			perService.ajouterPER(per);
		}
		String[] nomss = { "BAKHOUM", "MBOUP", "Dieng", "Ka", "THIAM" };
		String[] prenomss = { "Aannah", "Mor", "Sidiya", "Dame", "Amadou" };

		// Créez et ajoutez 5 objets Vacataire à la base de données
		for (int i = 4; i >= 0; i--) {
			Vacataire vacataire = new Vacataire();
			vacataire.setNom(nomss[i]);
			vacataire.setPrenom(prenomss[i]);
			vacataire.setSpecialite("Genie Logiciel");
			vacataire.setGrade("Charge de cours");
			vacataireService.ajouterVacataire(vacataire);
		}
		// Exemple concret
		Vacataire vac = new Vacataire();
		vac.setNom("Malack");
		vac.setPrenom("Kamir");
		vac.setSpecialite("Genie Logiciel");
		vac.setGrade("Docteur");
		vacataireService.ajouterVacataire(vac);

		PER per = new PER("B078X", "Genie Logiciel");
		per.setGrade("Professeur");
		per.setNom("DIOP");
		per.setPrenom("Ibrahima");
		perService.ajouterPER(per);

	}
}
