package com.uasz.Gestion_DAOS;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.uasz.Gestion_DAOS.Repository.Maquette.ClasseRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.EnseignementRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.ModuleRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.SemestreRepository;
import com.uasz.Gestion_DAOS.Service.AllService;
import com.uasz.Gestion_DAOS.Service.Repartition.PERService;
import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;
import com.uasz.Gestion_DAOS.Service.Repartition.VacataireService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.CycleService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ECService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FormationService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ModuleService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.SemestreService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Batiment;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Deroulement;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Emploi;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Seance;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;
import com.uasz.Gestion_DAOS.model.Maquette.EC;
import com.uasz.Gestion_DAOS.model.Maquette.Filiere;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;
import com.uasz.Gestion_DAOS.model.Maquette.Module;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;
import com.uasz.Gestion_DAOS.model.Maquette.Semestre;
import com.uasz.Gestion_DAOS.model.Maquette.UE;
import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;
import com.uasz.Gestion_DAOS.model.Repartition.PER;
import com.uasz.Gestion_DAOS.model.Repartition.Repartition;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;

@SpringBootApplication
public class GestionDaosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosApplication.class, args);
	}

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// return new WebMvcConfigurer() {
	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	// registry.addMapping("/maquette/**")
	// .allowedOrigins("*")
	// .allowedMethods("GET", "POST", "PUT", "DELETE")
	// .allowedHeaders("*");
	// }
	// };
	// }

	@Autowired
	private AllService all;

	@Autowired
	public UEService ueService;
	@Autowired
	public ECService ecService;

	@Autowired
	private VacataireService vacataireService;

	@Autowired
	private CycleService cycleService;
	@Autowired
	private ClasseService classeService;
	@Autowired
	private GroupeService groupeService;
	@Autowired
	private EnseignementService enseignementService;

	@Autowired
	private NiveauService niveauService;
	@Autowired
	PERService pERService;
	@Autowired
	private FiliereService filiereService;

	@Autowired
	private FormationService formationService;

	@Autowired
	private RepartitionService repartitionService;
	@Autowired
	private SemestreService semestreService;

	@Autowired
	private ModuleService modulesService;

	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private SemestreRepository semestreRepository;

	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private EnseignementRepository enseignementRepository;

	@Override
	public void run(String... args) throws Exception {
		Cycle cycle1 = cycleService.ajouterCycle(new Cycle(null, "Licence", null));
		Cycle cycle2 = cycleService.ajouterCycle(new Cycle(null, "Master", null));
		Cycle cycle3 = cycleService.ajouterCycle(new Cycle(null, "Doctorat", null));
		// Les niveaux
		Niveau l1 = niveauService.ajouterNiveau(new Niveau(null, "L1", cycle1, null));
		Niveau l2 = niveauService.ajouterNiveau(new Niveau(null, "L2", cycle1, null));
		Niveau l3 = niveauService.ajouterNiveau(new Niveau(null, "M1", cycle2, null));
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

			pERService.ajouterPER(per);
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
		// AJout des Batiment
		Batiment b1 = new Batiment(null, "Bloc Scientifique", null);
		all.batimentService.ajouterBatiment(b1);

		Batiment b3 = new Batiment(null, "Batiment Informatique", null);
		all.batimentService.ajouterBatiment(b3);
		all.batimentService.ajouterBatiment(b1);
		Batiment b2 = new Batiment(null, "PGF SUP", null);

		all.batimentService.ajouterBatiment(b2);
		Salle salle1 = all.salleService.ajouterSalle(new Salle(null, "A1", 15, b1, null));
		all.salleService.ajouterSalle(new Salle(null, "B4", 25, b2, null));

		all.salleService.ajouterSalle(new Salle(null, "F02", 25, b3, null));
		all.salleService.ajouterSalle(new Salle(null, "F03", 25, b3, null));
		all.salleService.ajouterSalle(new Salle(null, "F01", 25, b3, null));
		all.salleService.ajouterSalle(new Salle(null, "F04", 25, b3, null));

		// Exemple concret
		Vacataire vac = new Vacataire();
		vac.setNom("Malack");
		vac.setPrenom("Kamir");
		vac.setSpecialite("Genie Logiciel");
		vac.setGrade("Docteur");
		all.vacataireService.ajouterVacataire(vac);

		PER per = new PER("B078X", "Genie Logiciel");
		per.setGrade("Professeur");
		per.setNom("DIOP");
		per.setPrenom("Ibrahima");
		all.perService.ajouterPER(per);

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Ajout des unités d'enseignement (UEs)
		UE ue_1 = ueService.ajouterUE(new UE(null, "Reseaux et Telecoms", "INF351", 8, 4, null, null, null, null));
		UE ue_2 = ueService.ajouterUE(new UE(null, "Genie Logiciel 1", "INF352", 8, 4, null, null, null, null));
		UE ue_3 = ueService
				.ajouterUE(new UE(null, "Technologies embarques et Mobiles", "INF353", 8, 4, null, null, null, null));
		UE ue_4 = ueService
				.ajouterUE(new UE(null, "Gestions de donnees structurees", "INF354", 8, 4, null, null, null, null));
		UE ue_5 = ueService.ajouterUE(new UE(null, "Humanites et Entreprise", "INF355", 6, 3, null, null, null, null));

		// Ajout des filières
		Filiere filiere1 = filiereService.ajouterFiliere(new Filiere(null, "L2I", null));
		Filiere filiere2 = filiereService.ajouterFiliere(new Filiere(null, "Mathematique", null));
		Filiere filiere3 = filiereService.ajouterFiliere(new Filiere(null, "Geographie", null));
		Filiere filiere4 = filiereService.ajouterFiliere(new Filiere(null, "Agronomie", null));
		Filiere filiere5 = filiereService.ajouterFiliere(new Filiere(null, "Histoire", null));

		// Ajout des formations
		Formation l3_L2I = formationService
				.ajouterFormation(new Formation(null, "L3_2I", filiere1, null, null, l1));
		Formation l2_MPI = formationService
				.ajouterFormation(new Formation(null, "Mathematique", filiere2, null, null, l2));
		// Ajout des Semetres
		Semestre semestre_5 = semestreRepository.save(new Semestre(null, "Semestre 5", null, null, null));
		Semestre semestre_6 = semestreRepository.save(new Semestre(null, "Semestre 6", null, null, null));
		Semestre semestre_3 = semestreRepository.save(new Semestre(null, "Semestre 3", null, null, null));
		Semestre semestre_4 = semestreRepository.save(new Semestre(null, "Semestre 4", null, null, null));
		// Ajout des classes
		Classe semestre_5_3_L21 = classeRepository
				.save(new Classe(null, "Licence 3 L2I Semestre 5", 30, 1, null,
						l3_L2I, null, semestre_5, null));
		Classe semestre_6_3_L21 = classeRepository
				.save(new Classe(null, "Licence 3 L2I Semestre 6", 32, 1, "Tres Intense comme formation ",
						l3_L2I, null, semestre_6, null));
		Classe semestre_3_2_MPI = classeRepository.save(new Classe(null, "Licence 2 MPI Semestre 3", 70, 2, null,
				l2_MPI, null, semestre_3, null));
		Classe semestre_4_L2_MI = classeRepository.save(new Classe(null, "Licence 2 MI Semestre 4", 30, 1, null,
				l2_MPI, null, semestre_4, null));
		Classe semestre_4_L2_MP = classeRepository.save(new Classe(null, "Licence 2 MP Semestre 4", 30, 1, null,
				l2_MPI, null, semestre_4, null));
		// Ajout des groupes
		Groupe groupe1 = groupeService.ajouterGroupe(
				new Groupe(null, "Groupe GL", 25, "C'est l'option Genile LOgiciel", null, semestre_6_3_L21));
		Groupe groupe2 = groupeService.ajouterGroupe(new Groupe(null, "Groupe2", 50, "", null, semestre_6_3_L21));
		Groupe groupe3 = groupeService.ajouterGroupe(new Groupe(null, "Alpha", 40, "", null, semestre_4_L2_MI));
		Groupe groupe4 = groupeService.ajouterGroupe(new Groupe(null, "Beta", 30, "", null, semestre_4_L2_MI));
		// Ajout des Modules
		// Génie Logiciel Anvacé
		Module module1 = moduleRepository
				.save(new Module(null, "Génie Logiciel Anvacé", "CM", 2, 2, "C'est la suite logique de GL1",
						null, null, ue_3, null, semestre_4, null));
		Module module1_1 = moduleRepository
				.save(new Module(null, "Génie Logiciel Anvacé", "TP", 2, 2, "C'est la suite logique de GL1",
						null, null, ue_3, null, semestre_4, null));
		// Développement d'Applications Orientés
		Module module2 = moduleRepository
				.save(new Module(null, "Développement d'Applications Orientés Service", "CM", 2, 2, null,
						null, null, ue_3, null, semestre_4, null));
		Module module2_1 = moduleRepository
				.save(new Module(null, "Développement d'Applications Orientés Service", "TP", 2, 2, null,
						null, null, ue_3, null, semestre_4, null));
		// Sécurité des réseux
		Module module3 = moduleRepository.save(new Module(null, "Sécurité des réseux", "CM", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		Module module3_1 = moduleRepository.save(new Module(null, "Sécurité des réseux", "TP", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		// Administration Réseaux
		Module module4 = moduleRepository.save(new Module(null, "Administration Réseaux", "CM", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		Module module4_1 = moduleRepository.save(new Module(null, "Administration Réseaux", "TP", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));

		// Anglais
		Module module5 = moduleRepository.save(new Module(null, "Anglais 6", "CM", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		// Droit des TICS
		Module module6 = moduleRepository.save(new Module(null, "Droit des TICS", "CM", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		// Enseignement pour Semstre 6 L3 L2I
		Enseignement gl_cm = enseignementRepository
				.save(new Enseignement(null, "Génie Logiciel Anvacé-CM", null, module1,
						semestre_6_3_L21, null,
						null));
		enseignementRepository.save(new Enseignement(null, "Génie Logiciel Anvacé-TP", null, module1_1,
				semestre_6_3_L21, null,
				null));
		Enseignement daos_cm = enseignementRepository
				.save(new Enseignement(null, "Développement d'Applications Orientés Service-CM", null, module2,
						semestre_6_3_L21, null,
						null));
		Enseignement daos_tp = enseignementRepository
				.save(new Enseignement(null, "Développement d'Applications Orientés Service-TP", null, module2_1,
						semestre_6_3_L21, null,
						null));
		enseignementRepository.save(new Enseignement(null, "Sécurité des réseux-CM", null, module3,
				semestre_6_3_L21, null,
				null));
		enseignementRepository.save(new Enseignement(null, "Sécurité des réseux-TP", null, module3_1,
				semestre_6_3_L21, null,
				null));
		enseignementRepository.save(new Enseignement(null, "Administration Réseaux-CM", null, module4,
				semestre_6_3_L21, null,
				null));
		enseignementRepository.save(new Enseignement(null, "Administration Réseaux-TP", null, module4_1,
				semestre_6_3_L21, null,
				null));
		enseignementRepository.save(new Enseignement(null, "Anglais 6", null, module5,
				semestre_6_3_L21, null,
				null));
		enseignementRepository.save(new Enseignement(null, "Droit des TICS", null, module6,
				semestre_6_3_L21, null,
				null));
		// ----------------------------------
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1", null,
				module2, semestre_5_3_L21, null, null));
		enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module3,
						semestre_5_3_L21, null, null));
		enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module4,
						semestre_5_3_L21, null, null));

		Enseignement enseignement1 = enseignementRepository
				.save(new Enseignement(null, "Genie Logiciel 1", null, module1,
						semestre_5_3_L21, groupe1, null));
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1",
				null,
				module2, semestre_5_3_L21, groupe2, null));
		Enseignement enseignement2 = enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module3,
						semestre_5_3_L21, null, null));
		enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module4,
						semestre_5_3_L21, null, null));

		Repartition r1 = repartitionService
				.ajouterRepartition(new Repartition(null, daos_cm, per, null));
		Repartition r2 = repartitionService
				.ajouterRepartition(new Repartition(null, daos_tp, vac, null));
		// Repartition r3 = repartitionService
		// .ajouterRepartition(new Repartition(null, gl_cm, vac, null));

		// =================================================================

		all.deroulementService.ajouterDeroulement(new Deroulement(null,
				"Analyse - Modelisation - Conception",
				"Test deroulement",
				null));
		Emploi em1 = all.emploiService
				.ajouterEmploi(new Emploi(null, null, new Date(), new Date()));
		// all.seanceService.ajouterSeance(seance1);
		Seance seance1 = all.seanceService.ajouterSeance(new Seance(null, "Lundi", "08:00", "01:30",
				em1, null,
				r1, salle1));
		Deroulement d1 = new Deroulement(null,
				"Initialiation aux Application Monolithique - Introduction aux microService - Realise d'une application MicroService",
				"Opération intellectuelle consistant à décomposer un tout en ses éléments constituants et d'en établir les relations et d'en faire une application",
				seance1);
		all.deroulementService.ajouterDeroulement(d1);

	}

}
