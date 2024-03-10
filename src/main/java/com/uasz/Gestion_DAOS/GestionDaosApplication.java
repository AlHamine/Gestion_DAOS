package com.uasz.Gestion_DAOS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.uasz.Gestion_DAOS.Service.Maquette.CycleService;
import com.uasz.Gestion_DAOS.Service.Maquette.ECService;
import com.uasz.Gestion_DAOS.Service.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.Service.Maquette.FormationService;
import com.uasz.Gestion_DAOS.Service.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.Service.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.Service.Maquette.SemestreService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.BatimentService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.DeroulementService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.EmploiService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SalleService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SeanceService;
import com.uasz.Gestion_DAOS.Service.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.Service.Maquette.MaquetteService;
import com.uasz.Gestion_DAOS.Service.Maquette.ModuleService;
import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;
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
	private FiliereService filiereService;
	private FormationService formationService;
	private ModuleService moduleService;
	private SemestreService semestreService;
	private BatimentService batimentService;
	private DeroulementService deroulementService;
	private EmploiService emploiService;
	private RepartitionService repartitionService;
	private SalleService salleService;
	private SeanceService seanceService;
	private MaquetteService maquetteService;

	@Override
	public void run(String... args) throws Exception {
		// ueService.ajouterUE(new UE(null, "Reseaux et Telecoms", "INFF351", 8, 4, "",
		// null, null, 8, 5));
		UE ue1 = new UE(null, "GL 3", "INFF353", null, null, null, new Date(), null, 8, 5);
		ueService.ajouterUE(ue1);
		UE ue2 = new UE(null, "Another Course", "INFX001", null, null, null, new Date(), null, 6, 3);
		ueService.ajouterUE(ue2);
		ueService.ajouterUE(new UE(null, "GL 1", "INFF351", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "GL 2", "INFF352", null, null, null, new Date(), null, 6, 4));
		ueService.ajouterUE(new UE(null, "Base de Donnees  1", "INFC101", null, null, null, new Date(), null, 7, 3));
		ueService.ajouterUE(new UE(null, "Programmation1  2", "INFC102", null, null, null, new Date(), null, 6, 3));
		ueService.ajouterUE(new UE(null, "Math 1", "INFM201", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "Phys 1", "INFPH101", null, null, null, new Date(), null, 7, 4));
		ueService.ajouterUE(new UE(null, "GL 3", "INFF351", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "GL 4", "INFF352", null, null, null, new Date(), null, 6, 4));
		ueService.ajouterUE(new UE(null, "Base de Donnees  Avance", "INFC101", null, null, null, new Date(), null, 7, 3));
		ueService.ajouterUE(new UE(null, "Programmation3 4", "INFC102", null, null, null, new Date(), null, 6, 3));
		ueService.ajouterUE(new UE(null, "Math 5", "INFM201", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "Phys 7", "INFPH101", null, null, null, new Date(), null, 7, 4));
		ueService.ajouterUE(ue2);
		ueService.ajouterUE(new UE(null, "GL 1", "INFF351", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "GL 2", "INFF352", null, null, null, new Date(), null, 6, 4));
		ueService.ajouterUE(new UE(null, "Base de Donnees  1", "INFC101", null, null, null, new Date(), null, 7, 3));
		ueService.ajouterUE(new UE(null, "Programmation1  2", "INFC102", null, null, null, new Date(), null, 6, 3));
		ueService.ajouterUE(new UE(null, "Math 1", "INFM201", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "Phys 1", "INFPH101", null, null, null, new Date(), null, 7, 4));
		ueService.ajouterUE(new UE(null, "GL 3", "INFF351", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "GL 4", "INFF352", null, null, null, new Date(), null, 6, 4));
		ueService.ajouterUE(new UE(null, "Base de Donnees  Avance", "INFC101", null, null, null, new Date(), null, 7, 3));
		ueService.ajouterUE(new UE(null, "Programmation3 4", "INFC102", null, null, null, new Date(), null, 6, 3));
		ueService.ajouterUE(new UE(null, "Math 5", "INFM201", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "Phys 7", "INFPH101", null, null, null, new Date(), null, 7, 4));
		ueService.ajouterUE(ue2);
		ueService.ajouterUE(new UE(null, "GL 1", "INFF351", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "GL 2", "INFF352", null, null, null, new Date(), null, 6, 4));
		ueService.ajouterUE(new UE(null, "Base de Donnees  1", "INFC101", null, null, null, new Date(), null, 7, 3));
		ueService.ajouterUE(new UE(null, "Programmation1  2", "INFC102", null, null, null, new Date(), null, 6, 3));
		ueService.ajouterUE(new UE(null, "Math 1", "INFM201", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "Phys 1", "INFPH101", null, null, null, new Date(), null, 7, 4));
		ueService.ajouterUE(new UE(null, "GL 3", "INFF351", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "GL 4", "INFF352", null, null, null, new Date(), null, 6, 4));
		ueService.ajouterUE(new UE(null, "Base de Donnees  Avance", "INFC101", null, null, null, new Date(), null, 7, 3));
		ueService.ajouterUE(new UE(null, "Programmation3 4", "INFC102", null, null, null, new Date(), null, 6, 3));
		ueService.ajouterUE(new UE(null, "Math 5", "INFM201", null, null, null, new Date(), null, 8, 5));
		ueService.ajouterUE(new UE(null, "Phys 7", "INFPH101", null, null, null, new Date(), null, 7, 4));
		ecService.ajouterEC(new EC(null, "EC 2", "EC002", 3, 2, 2, 1, 4, "Description for EC 2", new Date(), ue1, null));
		ecService.ajouterEC(new EC(null, "EC 1", "EC001", 4, 3, 2, 1, 5, "Description for EC 1", null, ue1, null));
		ecService.ajouterEC(new EC(null, "EC 3", "EC003", 4, 3, 2, 1, 5, "Description for EC 3", new Date(), ue2, null));
		// .semestreService.ajouterSemestre(new Semestre(null, "Bonnheur", null, null));

		cycleService.ajouterCycle(new Cycle(null, "Licence", null, new Date()));
		cycleService.ajouterCycle(new Cycle(null, "Master", null, new Date()));
		cycleService.ajouterCycle(new Cycle(null, "Doctorat", null, new Date()));
		Cycle cycle1 = new Cycle(null, "Bachelor", null, new Date());
		Cycle cycle2 = new Cycle(null, "Ingenieurie", null, new Date());
		cycleService.ajouterCycle(cycle1);
		cycleService.ajouterCycle(cycle2);

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
		Classe ccl1 = new Classe(null, "L1-2I", 10, 3, "c'est cool", null, null, new ArrayList<>(), null, new Date());
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

		Module module1 = new Module(null, "Englais", ue1, null, null, null, null, new Date());
		moduleService.ajouterModule(module1);
		moduleService.ajouterModule(new Module(null, "Maths", ue1, null, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Base De Donnee", ue2, null, null, null, null, new Date()));
		moduleService.ajouterModule(new Module(null, "Philo", ue1, null, null, null, null, new Date()));

		enseignementService.ajouterEnseignement(new Enseignement(null, "testENS1",List.of("Objectif 1", "Objectif 2", "Objectif 3"), "Machin", ccl1, null, null, new Date()));

		semestreService.ajouterSemestre(new Semestre(null, "lib", "semestre 1", null, null, null));
		semestreService.ajouterSemestre(new Semestre(null, "lib 5", "semestre 5", null, null, null));

		batimentService.ajouterBatiment(new Batiment(null, "PGF SUP", null, new Date()));
		batimentService.ajouterBatiment(new Batiment(null, "BP", null, new Date()));
		batimentService.ajouterBatiment(new Batiment(null, "INFO", null, new Date()));

		deroulementService.ajouterDeroulement(new Deroulement(null, "matiere 1", new Date(), "processus 1", null, new Date()));
		deroulementService.ajouterDeroulement(new Deroulement(null, "matiere 2", new Date(), "processus 2", null, new Date()));

		emploiService.ajouterEmploi(new Emploi(null, null, new Date()));
		emploiService.ajouterEmploi(new Emploi(null, null, new Date()));

		repartitionService.ajouterRepartition(new Repartition());
		repartitionService.ajouterRepartition(new Repartition());
		repartitionService.ajouterRepartition(new Repartition());

		salleService.ajouterSalle(new Salle());
		salleService.ajouterSalle(new Salle());
		salleService.ajouterSalle(new Salle());

		seanceService.ajouterSeance(new Seance());
		seanceService.ajouterSeance(new Seance());
		seanceService.ajouterSeance(new Seance());

		maquetteService.ajouterMaquette(new Maquette(null, 2, 4, "intitule other", 3, 7, 11, 45, 6, 400, 21, null, null, new Date()));
		maquetteService.ajouterMaquette(new Maquette(null, 2, 4, "titre", 3, 7, 11, 45, 6, 400, 21, null, null, new Date()));
		maquetteService.ajouterMaquette(new Maquette(null, 2, 4, "l'homme", 3, 7, 11, 45, 6, 400, 21, null, null, new Date()));

	}

}
