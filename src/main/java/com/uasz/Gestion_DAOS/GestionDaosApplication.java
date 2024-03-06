package com.uasz.Gestion_DAOS;

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
		cycleService.ajouterCycle(new Cycle(null, "Licence", null));
		cycleService.ajouterCycle(new Cycle(null, "Master", null));
		cycleService.ajouterCycle(new Cycle(null, "Doctorat", null));
		Cycle cycle1 = new Cycle(null, "Bachelor", null);
		Cycle cycle2 = new Cycle(null, "Ingenieurie", null);
		cycleService.ajouterCycle(cycle1);
		cycleService.ajouterCycle(cycle2);
		String[] noms = { "Dupont", "Martin", "Dubois", "Thomas", "Lefebvre" };
		String[] prenoms = { "Jean", "Marie", "Claire", "Philippe", "Sophie" };
		String[] grades = { "Professeur", "Maître de conférences", "Assistant",
				"Chargé de cours", "Docteur" };
		String[] matricules = { "MAT001", "MAT002", "MAT003", "MAT004", "MAT005" };
		String[] specialites = { "Informatique", "Mathématiques", "Physique",
				"Biologie", "Chimie" };

		// // Créez et ajoutez 5 objets PER à la base de données
		for (int i = 0; i < 5; i++) {
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
		String[] nomss = { "Girard", "Fontaine", "Lemoine", "Durand", "Roux" };
		String[] prenomss = { "Sandrine", "Sylvie", "Paul", "Luc", "Marie" };

		// Créez et ajoutez 5 objets Vacataire à la base de données
		for (int i = 4; i == 0; i--) {
			Vacataire vacataire = new Vacataire();
			vacataire.setNom(nomss[i]);
			vacataire.setPrenom(prenomss[i]);
			vacataire.setSpecialite(specialites[i]);
			vacataire.setGrade(grades[i]);
			// Ajoutez cet objet Vacataire à la base de données en utilisant le service
			// approprié
			vacataireService.ajouterVacataire(vacataire);
		}
		Batiment b1 = new Batiment(null, "Bloc Scientifique", null);
		all.batimentService.ajouterBatiment(b1);
		Batiment b2 = new Batiment(null, "PGF SUP", null);

		all.batimentService.ajouterBatiment(b2);
		all.salleService.ajouterSalle(new Salle(null, "A1", 15, b1));
		all.salleService.ajouterSalle(new Salle(null, "B4", 25, b2));
		Vacataire vac = new Vacataire();
		vac.setNom(nomss[2]);
		vac.setPrenom(prenomss[3]);
		vac.setSpecialite(specialites[2]);
		vac.setGrade(grades[0]);
		all.vacataireService.ajouterVacataire(vac);
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++//
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

		// Ajout des cycles
		cycleService.ajouterCycle(new Cycle(null, "Licence", null));
		cycleService.ajouterCycle(new Cycle(null, "Master", null));
		cycleService.ajouterCycle(new Cycle(null, "Doctorat", null));

		Niveau l1 = niveauService.ajouterNiveau(new Niveau(null, "L1", cycle1, null));
		Niveau l2 = niveauService.ajouterNiveau(new Niveau(null, "L2", cycle1, null));
		Niveau l3 = niveauService.ajouterNiveau(new Niveau(null, "M1", cycle2, null));

		// Ajout des filières
		Filiere filiere1 = filiereService.ajouterFiliere(new Filiere(null, "L2I", null));
		Filiere filiere2 = filiereService.ajouterFiliere(new Filiere(null, "Mathematique", null));
		Filiere filiere3 = filiereService.ajouterFiliere(new Filiere(null, "Cybersecurite", null));
		Filiere filiere4 = filiereService.ajouterFiliere(new Filiere(null, "Physique", null));
		Filiere filiere5 = filiereService.ajouterFiliere(new Filiere(null, "LEA", null));

		// Ajout des formations
		Formation l3_L2I = formationService
				.ajouterFormation(new Formation(null, "L2I", filiere1, null, null, l1));
		Formation l2_MPI = formationService
				.ajouterFormation(new Formation(null, "Mathematique", filiere2, null, null, l2));

		// Ajout des enseignements
		// enseignementService.ajouterEnseignement(new Enseignement(null, "testENS1",
		// "Machin", classe1, groupe1, null));
		Semestre t = new Semestre(null, null, null, null, null);
		Semestre semestre_5 = semestreRepository.save(new Semestre(null, "Semestre 5", null, null, null));
		Semestre semestre_6 = semestreRepository.save(new Semestre(null, "Semestre 6", null, null, null));
		Semestre semestre_3 = semestreRepository.save(new Semestre(null, "Semestre 3", null, null, null));
		Semestre semestre_4 = semestreRepository.save(new Semestre(null, "Semestre 4", null, null, null));
		// Ajout des classes
		Classe semestre_5_3_L21 = classeRepository
				.save(new Classe(null, "Licence 3 L2I Semestre 5", 30, 1, null,
						l3_L2I, null, semestre_5, null));
		Classe semestre_6_3_L21 = classeRepository.save(new Classe(null, "Licence 3 L2I Semestre 6", 30, 1, null,
				l3_L2I, null, semestre_6, null));
		Classe semestre_3_2_MPI = classeRepository.save(new Classe(null, "Licence 2 MPI Semestre 3", 70, 2, null,
				l2_MPI, null, semestre_3, null));
		Classe semestre_4_L2_MI = classeRepository.save(new Classe(null, "Licence 2 MI Semestre 4", 30, 1, null,
				l2_MPI, null, semestre_4, null));
		Classe semestre_4_L2_MP = classeRepository.save(new Classe(null, "Licence 2 MP Semestre 4", 30, 1, null,
				l2_MPI, null, semestre_4, null));
		// Ajou des modules
		// Ajout des groupes
		Groupe groupe1 = groupeService.ajouterGroupe(new Groupe(null, "Groupe1", 25, null, null, semestre_6_3_L21));
		Groupe groupe2 = groupeService.ajouterGroupe(new Groupe(null, "Groupe2", 50, null, null, semestre_6_3_L21));
		Groupe groupe3 = groupeService.ajouterGroupe(new Groupe(null, "Alpha", 40, null, null, semestre_4_L2_MI));
		Groupe groupe4 = groupeService.ajouterGroupe(new Groupe(null, "Beta", 30, null, null, semestre_4_L2_MI));

		Module dd = new Module(null, null, null, 0, 0, null,
				null, null, ue_3, null, semestre_4, null);
		Module module1 = moduleRepository
				.save(new Module(null, "Genie Logiciel 1", "CM", 2, 2, null,
						null, null, ue_3, null, semestre_4, null));
		Module module2 = moduleRepository.save(new Module(null, "Genie Logiciel 1", "TD", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		Module module3 = moduleRepository.save(new Module(null, "Reseaux et Telecoms", "CM", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		Module module4 = moduleRepository.save(new Module(null, "Reseaux et Telecoms", "TD", 2, 2, null,
				null, null, ue_3, null, semestre_4, null));
		Enseignement e = new Enseignement(null, null, null, module4, semestre_4_L2_MP, groupe4);
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1", null, module1, semestre_5_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1", null,
				module2, semestre_5_3_L21, null));
		enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module3,
						semestre_5_3_L21, null));
		enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module4,
						semestre_5_3_L21, null));

		Enseignement enseignement1 = enseignementRepository
				.save(new Enseignement(null, "Genie Logiciel 1", null, module1,
						semestre_5_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1",
				null,
				module2, semestre_5_3_L21, null));
		Enseignement enseignement2 = enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module3,
						semestre_5_3_L21, null));
		enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module4,
						semestre_5_3_L21, null));

		Repartition r1 = repartitionService
				.ajouterRepartition(new Repartition(null, enseignement1, vac, null));
		Repartition r2 = repartitionService
				.ajouterRepartition(new Repartition(null, enseignement2, vac, null));

		// =================================================================

		Deroulement d1 = new Deroulement(null,
				List.of("Analyse", "Modelisation", "Conception"),
				"Opération intellectuelle consistant à décomposer un tout en ses éléments constituants et d'en établir les relations",
				null);
		all.deroulementService.ajouterDeroulement(d1);
		all.deroulementService.ajouterDeroulement(new Deroulement(null,
				List.of("Analyse", "Modelisation", "Conception"),
				"Test deroulement",
				null));
		Seance seance1 = new Seance(null, LocalDateTime.now(), "1h30", null, d1,
				r1);

		// all.seanceService.ajouterSeance(seance1);

	}

}
