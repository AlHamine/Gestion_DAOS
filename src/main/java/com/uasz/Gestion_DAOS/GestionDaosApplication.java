package com.uasz.Gestion_DAOS;

// import java.time.Instant;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import com.uasz.Gestion_DAOS.Service.Maquette.CycleService;
// import com.uasz.Gestion_DAOS.Service.Maquette.ECService;
// import com.uasz.Gestion_DAOS.Service.Maquette.FiliereService;
// import com.uasz.Gestion_DAOS.Service.Maquette.FormationService;
// import com.uasz.Gestion_DAOS.Service.Maquette.EnseignementService;
// import com.uasz.Gestion_DAOS.Service.Maquette.NiveauService;
// import com.uasz.Gestion_DAOS.Service.Maquette.SemestreService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.BatimentService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.DeroulementService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.EmploiService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SalleService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SeanceService;
import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.uasz.Gestion_DAOS.Repository.Maquette.ClasseRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.EnseignementRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.ModuleRepository;
import com.uasz.Gestion_DAOS.Repository.Maquette.SemestreRepository;
// import com.uasz.Gestion_DAOS.Service.AllService;
import com.uasz.Gestion_DAOS.Service.Repartition.PERService;
// import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;
import com.uasz.Gestion_DAOS.Service.Repartition.VacataireService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.CycleService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ECService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FormationService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.MaquetteService;
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
import com.uasz.Gestion_DAOS.model.Maquette.Maquette;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;
import com.uasz.Gestion_DAOS.model.Maquette.Semestre;
import com.uasz.Gestion_DAOS.model.Maquette.UE;
import com.uasz.Gestion_DAOS.model.Repartition.Repartition;
import com.uasz.Gestion_DAOS.model.Maquette.Module;

import lombok.AllArgsConstructor;
// import com.uasz.Gestion_DAOS.model.Maquette.Module;
// import com.uasz.Gestion_DAOS.model.Maquette.Niveau;
// import com.uasz.Gestion_DAOS.model.Maquette.Semestre;
// import com.uasz.Gestion_DAOS.model.Maquette.UE;
// import com.uasz.Gestion_DAOS.model.Repartition.Enseignant;
import com.uasz.Gestion_DAOS.model.Repartition.PER;
// import com.uasz.Gestion_DAOS.model.Repartition.Repartition;
import com.uasz.Gestion_DAOS.model.Repartition.Vacataire;

@SpringBootApplication
@AllArgsConstructor
public class GestionDaosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosApplication.class, args);
	}

	private UEService ueService;
	private ECService ecService;
	private CycleService cycleService;
	private ClasseService classeService;
	private GroupeService groupeService;
	private EnseignementService enseignementService;
	private NiveauService niveauService;
	// private PERService pERService;
	private PERService perService;
	private FiliereService filiereService;
	private FormationService formationService;
	private ModuleService moduleService;
	private BatimentService batimentService;
	private DeroulementService deroulementService;
	private EmploiService emploiService;
	private SalleService salleService;
	private SeanceService seanceService;
	private MaquetteService maquetteService;
	private VacataireService vacataireService;
	// private MaquetteService maquetteService;

	private RepartitionService repartitionService;
	private SemestreService semestreService;

	// private ModuleService modulesService;

	private ClasseRepository classeRepository;
	private SemestreRepository semestreRepository;

	private ModuleRepository moduleRepository;
	private EnseignementRepository enseignementRepository;

	@Override
	public void run(String... args) throws Exception {

		UE ue1 = new UE(null, "Génie civil", "GEN001", 6, 3, "Introduction au génie civil", new Date(), null, null);
		ueService.ajouterUE(ue1);
		UE ue2 = new UE(null, "Psychologie", "PSY001", 5, 4, "Introduction à la psychologie", new Date(), null, null);
		ueService.ajouterUE(ue2);
		ueService.ajouterUE(new UE(null, "Informatique", "INFO001", 6, 3, "Cours d'informatique avancée", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Économie", "ECO001", 5, 4, "Introduction à l'économie", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Marketing", "MAR001", 6, 3, "Introduction au marketing", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Sciences politiques", "POL001", 5, 4, "Introduction aux sciences politiques", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Biologie", "BIO001", 6, 3, "Introduction à la biologie", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Droit", "DRO001", 5, 4, "Introduction au droit", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Langues et culture étrangères", "LCE001", 6, 3, "Cours de langues et culture étrangères", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Finance", "FIN001", 5, 4, "Introduction à la finance", new Date(), null, null));
		ueService.ajouterUE(new UE(null, "Histoire", "HIS001", 6, 3, "Introduction à l'histoire", new Date(), null, null));

		ecService.ajouterEC(new EC(null, "EC 2", "EC002", 3, 2, 2, 1, 4, "Description for EC 2", new Date(), ue1, null));
		ecService.ajouterEC(new EC(null, "EC 1", "EC001", 4, 3, 2, 1, 5, "Description for EC 1", null, ue1, null));
		ecService.ajouterEC(new EC(null, "EC 3", "EC003", 4, 3, 2, 1, 5, "Description for EC 3", new Date(), ue2, null));

		cycleService.ajouterCycle(new Cycle(null, "Licence", null, new Date()));
		cycleService.ajouterCycle(new Cycle(null, "Master", null, new Date()));
		cycleService.ajouterCycle(new Cycle(null, "Doctorat", null, new Date()));


		Cycle cycle1 = cycleService.ajouterCycle(new Cycle(null, "Licence", null, new Date()));
		Cycle cycle2 = cycleService.ajouterCycle(new Cycle(null, "Master", null, new Date()));
		// Cycle cycle3 = cycleService.ajouterCycle(new Cycle(null, "Doctorat", null, new Date()));
		Cycle cycle4 = new Cycle(null, "Bachelor", null, new Date());
		Cycle cycle5 = new Cycle(null, "Ingenieurie", null, new Date());
		cycleService.ajouterCycle(cycle4);
		cycleService.ajouterCycle(cycle5);

		Niveau niveau1 = new Niveau(null, "L1", cycle1, null, new Date());
		Niveau niveau2 = new Niveau(null, "L2", cycle1, null, new Date());
		Niveau niveau3 = new Niveau(null, "M1", cycle2, null, new Date());
		niveauService.ajouterNiveau(niveau1);
		niveauService.ajouterNiveau(niveau2);
		niveauService.ajouterNiveau(niveau3);

		Filiere filiere1 = new Filiere(null, "L2I", null, new Date());
		Filiere filiere2 = new Filiere(null, "Mathematique", null, new Date());
		Filiere filiere3 = new Filiere(null, "Cybersecurite", null, new Date());
		Filiere filiere4 = new Filiere(null, "Physique", null, new Date());
		Filiere filiere5 = new Filiere(null, "LEA", null, new Date());
		filiereService.ajouterFiliere(filiere1);
		filiereService.ajouterFiliere(filiere2);
		filiereService.ajouterFiliere(filiere3);
		filiereService.ajouterFiliere(filiere4);
		filiereService.ajouterFiliere(filiere5);

		Formation formation1 = new Formation(null, "Developpement fullStack", filiere1, null, null, niveau1, new Date());
		Formation formation2 = new Formation(null, "Cryptographie", filiere2, null, null, niveau2, new Date());
		Formation formation3 = new Formation(null, "Hacking", filiere3, null, null, niveau3, new Date());
		Formation formation4 = new Formation(null, "Astronomie", filiere4, null, null, niveau1, new Date());
		Formation formation5 = new Formation(null, "Developpement personnelle", filiere5, null, null, niveau2, new Date());
		formationService.ajouterFormation(formation1);
		formationService.ajouterFormation(formation2);
		formationService.ajouterFormation(formation3);
		formationService.ajouterFormation(formation4);
		formationService.ajouterFormation(formation5);

		Classe ccl1 = new Classe(null, "L1-2I", 10, 3, "c'est cool", null, null, null, null, new Date());
		classeService.ajouterClasse(ccl1);
		Classe ccl2 = new Classe(null, "L2-2I", 14, 5, "Tres interressant", null, null, null, null, new Date());
		classeService.ajouterClasse(ccl2);
		classeService.ajouterClasse(new Classe(null, "MI", 14, 5, "Tres interressant et a retenir", null, null, null, null, new Date()));
		classeService.ajouterClasse(new Classe(null, "MIO", 14, 5, "Informatiquement parlant ", null, null, null, null, new Date()));
		classeService.ajouterClasse(new Classe(null, "GEOGRAPHIE", 14, 5, "Util pour exploter les petrole", null, null, null, null, new Date()));
		classeService.ajouterClasse(new Classe(null, "MATH", 14, 5, "Discipline tre ancienne ", null, null, null, null, new Date()));
		groupeService.ajouterGroupe(new Groupe(null, "Groupe1", 25, "desc 1", null, ccl1, new Date()));
		groupeService.ajouterGroupe(new Groupe(null, "Groupe2", 50, "desc 2", null, ccl1, new Date()));
		groupeService.ajouterGroupe(new Groupe(null, "Alpha", 40, "desc 3", null, ccl2, new Date()));
		groupeService.ajouterGroupe(new Groupe(null, "Beta", 30, "desc 4", null, ccl2, new Date()));

		Module module1 = new Module(null, "Mathématiques", "Cours", 4, 6, "Cours de mathématiques avancées", "Objectifs du module", null, ue1, null, null, null, new Date());
		moduleService.ajouterModule(module1);
		Module module2 = new Module(null, "Englais", "Cours", 3, 7, "Description", "object", null, ue2, null, null, null, new Date());
		moduleService.ajouterModule(module2);
		moduleService.ajouterModule(new Module(null, "Programmation informatique", "Cours", 3, 5, "Cours de programmation en Java", "Objectifs du module", null, ue1, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Génie électrique", "Cours", 4, 6, "Cours de génie électrique", "Objectifs du module", null, ue2, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Finance", "Cours", 3, 5, "Cours de finance d'entreprise", "Objectifs du module", null, ue1, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Biologie moléculaire", "Cours", 4, 6, "Cours de biologie moléculaire", "Objectifs du module", null, null, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Marketing", "Cours", 3, 5, "Cours de marketing stratégique", "Objectifs du module", null, null, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Psychologie sociale", "Cours", 4, 6, "Cours de psychologie sociale", "Objectifs du module", null, null, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Chimie organique", "Cours", 3, 5, "Cours de chimie organique avancée", "Objectifs du module", null, null, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Gestion des ressources humaines", "Cours", 4, 6, "Cours de gestion des RH", "Objectifs du module", null, null, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Droit international", "Cours", 3, 5, "Cours de droit international public", "Objectifs du module", null, null, null, null, null, new Date()));

		// enseignementService.ajouterEnseignement(new Enseignement(null, "testENS1", "objectif", "description", module1, null, null, new Date(), null));
		// enseignementService.ajouterEnseignement(new Enseignement(null, "Mathématiques avancées", "Objectifs du cours de mathématiques", "Description du cours de mathématiques avancées", module2, null, null, new Date(), null));
		// enseignementService.ajouterEnseignement(new Enseignement(null, "Programmation en Java", "Objectifs du cours de programmation", "Description du cours de programmation en Java", module2, null, null, new Date(), null));
		// enseignementService.ajouterEnseignement(new Enseignement(null, "Finance d'entreprise", "Objectifs du cours de finance", "Description du cours de finance d'entreprise", module1, null, null, new Date(), null));
		// enseignementService.ajouterEnseignement(new Enseignement(null, "Biologie cellulaire avancée", "Objectifs du cours de biologie cellulaire", "Description du cours de biologie cellulaire avancée", module1, null, null, new Date(), null));
		// enseignementService.ajouterEnseignement(new Enseignement(null, "Marketing stratégique", "Objectifs du cours de marketing", "Description du cours de marketing stratégique", module2, null, null, new Date(), null));

		semestreService.ajouterSemestre(new Semestre(null, "lib", "semestre 1", null, null, null));
		semestreService.ajouterSemestre(new Semestre(null, "lib 5", "semestre 5", null, null, null));

		batimentService.ajouterBatiment(new Batiment(null, "PGF SUP", null, new Date()));
		batimentService.ajouterBatiment(new Batiment(null, "BP", null, new Date()));
		batimentService.ajouterBatiment(new Batiment(null, "INFO", null, new Date()));

		deroulementService.ajouterDeroulement(new Deroulement(null, "Objectif 1", "Description 1", null, new Date()));
		deroulementService.ajouterDeroulement(new Deroulement(null, "Objectif 2", "Description 2", null, new Date()));

		emploiService.ajouterEmploi(new Emploi(null, null, new Date(), null, null));
		emploiService.ajouterEmploi(new Emploi(null, null, new Date(), null, null));

		// repartitionService.ajouterRepartition(new Repartition());
		// repartitionService.ajouterRepartition(new Repartition());
		// repartitionService.ajouterRepartition(new Repartition());

		// salleService.ajouterSalle(new Salle());
		// salleService.ajouterSalle(new Salle());
		// salleService.ajouterSalle(new Salle());

		// seanceService.ajouterSeance(new Seance());
		// seanceService.ajouterSeance(new Seance());
		// seanceService.ajouterSeance(new Seance());

		maquetteService.ajouterMaquette(new Maquette(null, 2, 4, "intitule other", 3, 7, 11, 45, 6, 400, 21, null, null, new Date()));
		maquetteService.ajouterMaquette(new Maquette(null, 2, 4, "titre", 3, 7, 11, 45, 6, 400, 21, null, null, new Date()));
		maquetteService.ajouterMaquette(new Maquette(null, 2, 4, "l'homme", 3, 7, 11, 45, 6, 400, 21, null, null, new Date()));

		// Les niveaux
		Niveau l1 = niveauService.ajouterNiveau(new Niveau(null, "L1", cycle1, null, new Date()));
		Niveau l2 = niveauService.ajouterNiveau(new Niveau(null, "L2", cycle1, null, new Date()));
		// Niveau l3 = niveauService.ajouterNiveau(new Niveau(null, "M1", cycle2, null, new Date()));

		// Les enseignants
		String[] noms = { "DIOP", "DRAME", "NDOYE", "NDIAYE", "FAYE", "FAYE", "NDIAYE", "DIAW" };
		String[] prenoms = { "Ibrahima", "Khadim", "Malick", "Mr", "Youssou", "El Hadji", "Marie", "Mame Kouna" };
		String[] grades = { "Professeur", "Docteur", "Maître de conférences", "Docteur",
				"Professeur", "Docteur", "Professeur", "Doctoreur" };
		String[] matricules = { "MAT001", "MAT002", "MAT003", "MAT004", "MAT005", "MAT003", "MAT004", "MatrK83" };

		String[] specialites = { "Genie Logiciel", "IA", "Reseaux",
				"Droit", "Securite et Reseaux", "Reseaux et Telecom",
				"Genie Logiciel", "Anglais" };

		// Créez et ajoutez 5 objets PER à la base de données
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

		// AJout des Batiment
		Batiment b1 = new Batiment(null, "Bloc Scientifique", null, new Date());
		batimentService.ajouterBatiment(b1);
		Batiment b3 = new Batiment(null, "Batiment Informatique", null, new Date());
		batimentService.ajouterBatiment(b3);
		batimentService.ajouterBatiment(b1);
		Batiment b2 = new Batiment(null, "PGF SUP", null, new Date());
		batimentService.ajouterBatiment(b2);

		Salle salle1 = salleService.ajouterSalle(new Salle(null, "A1", 15, b1, new Date(), null));
		salleService.ajouterSalle(new Salle(null, "B4", 25, b2, new Date(),null));
		salleService.ajouterSalle(new Salle(null, "F02", 25, b3, new Date(),null));
		salleService.ajouterSalle(new Salle(null, "F03", 25, b3, new Date(),null));
		salleService.ajouterSalle(new Salle(null, "F01", 25, b3, new Date(),null));
		salleService.ajouterSalle(new Salle(null, "F04", 25, b3, new Date(),null));

		// Exemple concret
		Vacataire vac = new Vacataire();
		vac.setNom("Malack");
		vac.setPrenom("Kamir");
		vac.setSpecialite("Genie Logiciel");
		vac.setGrade("Docteur");
		vacataireService.ajouterVacataire(vac);

		PER per = new PER("B078X", "Genie Logiciel", new Date());
		per.setGrade("Professeur");
		per.setNom("DIOP");
		per.setPrenom("Ibrahima");
		perService.ajouterPER(per);

		// Ajout des unités d'enseignement (UEs)
		UE ue_1 = ueService.ajouterUE(new UE(null, "Reseaux et Telecoms", "INF351", 8, 4, null, null, null, null));
		UE ue_2 = ueService.ajouterUE(new UE(null, "Genie Logiciel 1", "INF352", 8, 4, null, null, null, null));
		UE ue_3 = ueService.ajouterUE(new UE(null, "Technologies embarques et Mobiles", "INF353", 8, 4, null, null, null, null));
		UE ue_4 = ueService.ajouterUE(new UE(null, "Gestions de donnees structurees", "INF354", 8, 4, null, null, null, null));
		UE ue_5 = ueService.ajouterUE(new UE(null, "Humanites et Entreprise", "INF355", 6, 3, null, null, null, null));

		// Ajout des filières
		// Filiere filiere1 = filiereService.ajouterFiliere(new Filiere(null, "L2I", null, new Date()));
		// Filiere filiere2 = filiereService.ajouterFiliere(new Filiere(null, "Mathematique", null, new Date()));
		// Filiere filiere3 = filiereService.ajouterFiliere(new Filiere(null, "Geographie", null, new Date()));
		// Filiere filiere4 = filiereService.ajouterFiliere(new Filiere(null, "Agronomie", null, new Date()));
		// Filiere filiere5 = filiereService.ajouterFiliere(new Filiere(null, "Histoire", null, new Date()));

		// Ajout des formations
		Formation l3_L2I = formationService.ajouterFormation(new Formation(null, "L3_2I", filiere1, null, null, l1, new Date()));
		Formation l2_MPI = formationService.ajouterFormation(new Formation(null, "Mathematique", filiere2, null, null, l2, new Date()));
		
		// Ajout des Semetres
		Semestre semestre_5 = semestreRepository.save(new Semestre(null, "Semestre 5", "Description 1", null, null, new Date()));
		Semestre semestre_6 = semestreRepository.save(new Semestre(null, "Semestre 6", "Description 2", null, null, new Date()));
		Semestre semestre_3 = semestreRepository.save(new Semestre(null, "Semestre 3", "Description 3", null, null, new Date()));
		Semestre semestre_4 = semestreRepository.save(new Semestre(null, "Semestre 4", "Description 4", null, null, new Date()));
		
		// Ajout des classes
		Classe semestre_5_3_L21 = classeService.ajouterClasse(new Classe(null, "Licence 3 L2I Semestre 5", 30, 1, "Desc 1", l3_L2I, null, semestre_5, null, new Date()));
		Classe semestre_6_3_L21 = classeRepository.save(new Classe(null, "Licence 3 L2I Semestre 6", 32, 1, "Tres Intense comme formation ",l3_L2I, null, semestre_6, null, new Date()));
		Classe semestre_3_2_MPI = classeRepository.save(new Classe(null, "Licence 2 MPI Semestre 3", 70, 2, null,l2_MPI, null, semestre_3, null, new Date()));
		Classe semestre_4_L2_MI = classeRepository.save(new Classe(null, "Licence 2 MI Semestre 4", 30, 1, null,l2_MPI, null, semestre_4, null, new Date()));
		Classe semestre_4_L2_MP = classeRepository.save(new Classe(null, "Licence 2 MP Semestre 4", 30, 1, null,l2_MPI, null, semestre_4, null, new Date()));
		
		// Ajout des groupes
		Groupe groupe1 = groupeService.ajouterGroupe(new Groupe(null, "Groupe GL", 25, "C'est l'option Genile LOgiciel", null, semestre_6_3_L21, new Date()));
		Groupe groupe2 = groupeService.ajouterGroupe(new Groupe(null, "Groupe2", 50, "", null, semestre_6_3_L21, new Date()));
		Groupe groupe3 = groupeService.ajouterGroupe(new Groupe(null, "Alpha", 40, "", null, semestre_4_L2_MI, new Date()));
		Groupe groupe4 = groupeService.ajouterGroupe(new Groupe(null, "Beta", 30, "", null, semestre_4_L2_MI, new Date()));
		
		// Ajout des Modules
		// Génie Logiciel Anvacé
		Module module1_2 = moduleRepository.save(new Module(null, "Génie Logiciel Anvacé", "CM", 2, 2, "C'est la suite logique de GL1",null, null, ue_3, null, semestre_4, null, new Date()));
		Module module1_1 = moduleRepository.save(new Module(null, "Génie Logiciel Anvacé", "TP", 2, 2, "C'est la suite logique de GL1",null, null, ue_3, null, semestre_4, null, new Date()));
		// Développement d'Applications Orientés
		Module module2_2 = moduleRepository.save(new Module(null, "Développement d'Applications Orientés Service", "CM", 2, 2, null,null, null, ue_3, null, semestre_4, null,  new Date()));
		Module module2_1 = moduleRepository.save(new Module(null, "Développement d'Applications Orientés Service", "TP", 2, 2, null,null, null, ue_3, null, semestre_4, null,  new Date()));
		// Sécurité des réseux
		Module module3 = moduleRepository.save(new Module(null, "Sécurité des réseux", "CM", 2, 2, null,null, null, ue_3, null, semestre_4, null,  new Date()));
		Module module3_1 = moduleRepository.save(new Module(null, "Sécurité des réseux", "TP", 2, 2, null,null, null, ue_3, null, semestre_4, null,  new Date()));
		// Administration Réseaux
		Module module4 = moduleRepository.save(new Module(null, "Administration Réseaux", "CM", 2, 2, null,null, null, ue_3, null, semestre_4, null,  new Date()));
		Module module4_1 = moduleRepository.save(new Module(null, "Administration Réseaux", "TP", 2, 2, null,null, null, ue_3, null, semestre_4, null,  new Date()));
		// Anglais
		Module module5 = moduleRepository.save(new Module(null, "Anglais 6", "CM", 2, 2, null,null, null, ue_3, null, semestre_4, null, new Date()));
		// Droit des TICS
		Module module6 = moduleRepository.save(new Module(null, "Droit des TICS", "CM", 2, 2, null,null, null, ue_3, null, semestre_4, null, new Date()));
		
		// Enseignement pour Semstre 6 L3 L2I
		Enseignement gl_cm = enseignementService.ajouterEnseignement(new Enseignement(null, "Génie Logiciel Anvacé-CM", "Objec 1", "Desc 1", module1, semestre_6_3_L21, null, new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Génie Logiciel Anvacé-TP", "Object 2", "Desc 2", module1_1,semestre_6_3_L21, null, new Date(),null));
		Enseignement daos_cm = enseignementRepository.save(new Enseignement(null, "Développement d'Applications Orientés Service-CM", "Object 2", "Desc 2", module2,semestre_6_3_L21, null, new Date(), null));
		Enseignement daos_tp = enseignementRepository.save(new Enseignement(null, "Développement d'Applications Orientés Service-TP", "Object 2", "Desc 2", module2_1,semestre_6_3_L21, null, new Date(), null));
		enseignementRepository.save(new Enseignement(null, "Sécurité des réseux-CM", "Object 2", "Desc 2", module3,semestre_6_3_L21, null, new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Sécurité des réseux-TP", "Object 2", "Desc 2", module3_1,semestre_6_3_L21, null, new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Administration Réseaux-CM", "Object 2", "Desc 2", module4,semestre_6_3_L21, null,new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Administration Réseaux-TP", "Object 2", "Desc 2", module4_1,semestre_6_3_L21, null, new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Anglais 6", "Object 2", "Desc 2", module5,semestre_6_3_L21, null,new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Droit des TICS", "Object 2", "Desc 2", module6,semestre_6_3_L21, null,new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1", "Object 2", "Desc 2",module2, semestre_5_3_L21, null, new Date(), null));
		enseignementRepository.save(new Enseignement(null, "Reseaux et Telecoms", "Object 2", "Desc 2", module3,semestre_5_3_L21, null, new Date(), null));
		enseignementRepository.save(new Enseignement(null, "Reseaux et Telecoms", "Object 2", "Desc 2", module4,semestre_5_3_L21, null, new Date(), null));
		Enseignement enseignement1 = enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1", "Object", "Desc", module1,semestre_5_3_L21, groupe1, new Date(),null));
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1","Object", "Desc",module2, semestre_5_3_L21, groupe2, new Date(), null));
		Enseignement enseignement2 = enseignementRepository.save(new Enseignement(null, "Reseaux et Telecoms", "Object", "Desc", module3,semestre_5_3_L21, null, new Date(), null));
		enseignementRepository.save(new Enseignement(null, "Reseaux et Telecoms", "Object", "Desc", module4,semestre_5_3_L21, null, new Date(), null));

		Repartition r1 = repartitionService.ajouterRepartition(new Repartition(null, daos_cm, per, null));
		Repartition r2 = repartitionService.ajouterRepartition(new Repartition(null, daos_tp, vac, null));
		// Repartition r3 = repartitionService
		// .ajouterRepartition(new Repartition(null, gl_cm, vac, null));
		// =================================================================

		deroulementService.ajouterDeroulement(new Deroulement(null,"Analyse - Modelisation - Conception","Test deroulement",null, new Date()));
		Emploi em1 = emploiService.ajouterEmploi(new Emploi(null, null, new Date(), new Date(), new Date()));
		// all.seanceService.ajouterSeance(seance1);
		Seance seance1 = seanceService.ajouterSeance(new Seance(null, "Lundi", "08:00", "01:30",em1, null,r1, new Date(), salle1));
		Deroulement d1 = new Deroulement(null,"Initialiation aux Application Monolithique - Introduction aux microService - Realise d'une application MicroService","Opération intellectuelle consistant à décomposer un tout en ses éléments constituants et d'en établir les relations et d'en faire une application",seance1, new Date());
		deroulementService.ajouterDeroulement(d1);
	}

}
