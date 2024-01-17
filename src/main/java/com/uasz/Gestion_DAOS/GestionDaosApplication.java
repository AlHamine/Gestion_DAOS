package com.uasz.Gestion_DAOS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS.Service.Maquette.CycleService;
import com.uasz.Gestion_DAOS.Service.Maquette.ECService;
import com.uasz.Gestion_DAOS.Service.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.Service.Maquette.FormationService;
import com.uasz.Gestion_DAOS.Service.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.Service.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.Service.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;
import com.uasz.Gestion_DAOS.model.Maquette.EC;
import com.uasz.Gestion_DAOS.model.Maquette.Filiere;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Groupe;
import com.uasz.Gestion_DAOS.model.Maquette.Niveau;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

@SpringBootApplication
public class GestionDaosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosApplication.class, args);
	}

	// @Autowired
	// private AllService ;
	//
	@Autowired
	public UEService ueService;

	@Autowired
	public ECService ecService;

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
	private FiliereService filiereService;

	@Autowired
	private FormationService formationService;

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

		ecService
				.ajouterEC(new EC(null, "EC 2", "EC002", 3, 2, 2, 1, 4, "Description for EC 2", new Date(), ue1, null));
		ecService.ajouterEC(new EC(null, "EC 1", "EC001", 4, 3, 2, 1, 5, "Description for EC 1", null, ue1, null));
		ecService
				.ajouterEC(new EC(null, "EC 3", "EC003", 4, 3, 2, 1, 5, "Description for EC 3", new Date(), ue2, null));
		// .semestreService.ajouterSemestre(new Semestre(null, "Bonnheur", null, null));

		cycleService.ajouterCycle(new Cycle(null, "Licence", null));
		cycleService.ajouterCycle(new Cycle(null, "Master", null));
		cycleService.ajouterCycle(new Cycle(null, "Doctorat", null));
		Cycle cycle1 = new Cycle(null, "Bachelor", null);
		Cycle cycle2 = new Cycle(null, "Ingenieurie", null);
		cycleService.ajouterCycle(cycle1);
		cycleService.ajouterCycle(cycle2);

		Niveau niveau1 = new Niveau(null, "L1", cycle1, null);
		Niveau niveau2 = new Niveau(null, "L2", cycle1, null);
		Niveau niveau3 = new Niveau(null, "M1", cycle2, null);
		niveauService.ajouterNiveau(niveau1);
		niveauService.ajouterNiveau(niveau2);
		niveauService.ajouterNiveau(niveau3);

		Filiere filiere1 = new Filiere(null, "L2I", null);
		Filiere filiere2 = new Filiere(null, "Mathematique", null);
		Filiere filiere3 = new Filiere(null, "Cybersecurite", null);
		Filiere filiere4 = new Filiere(null, "Physique", null);
		Filiere filiere5 = new Filiere(null, "LEA", null);
		filiereService.ajouterFiliere(filiere1);
		filiereService.ajouterFiliere(filiere2);
		filiereService.ajouterFiliere(filiere3);
		filiereService.ajouterFiliere(filiere4);
		filiereService.ajouterFiliere(filiere5);

		Formation formation1 = new Formation(null, "Developpement fullStack", filiere1, null, null, niveau1);
		Formation formation2 = new Formation(null, "Cryptographie", filiere2, null, null, niveau2);
		Formation formation3 = new Formation(null, "Hacking", filiere3, null, null, niveau3);
		Formation formation4 = new Formation(null, "Astronomie", filiere4, null, null, niveau1);
		Formation formation5 = new Formation(null, "Developpement personnelle", filiere5, null, null, niveau2);
		formationService.ajouterFormation(formation1);
		formationService.ajouterFormation(formation2);
		formationService.ajouterFormation(formation3);
		formationService.ajouterFormation(formation4);
		formationService.ajouterFormation(formation5);
		Classe ccl1 = new Classe(null, "L1-2I", 10, 3, "c'est cool", null, null, null, null);
		classeService.ajouterClasse(ccl1);
		Classe ccl2 = new Classe(null, "L2-2I", 14, 5, "Tres interressant", null, null, null, null);
		classeService.ajouterClasse(ccl2);
		classeService
				.ajouterClasse(new Classe(null, "MI", 14, 5, "Tres interressant et a retenir", null, null, null, null));

		classeService
				.ajouterClasse(new Classe(null, "MIO", 14, 5, "Informatiquement parlant ", null, null, null, null));
		classeService.ajouterClasse(
				new Classe(null, "GEOGRAPHIE", 14, 5, "Util pour exploter les petrole", null, null, null, null));

		classeService
				.ajouterClasse(new Classe(null, "MATH", 14, 5, "Discipline tre ancienne ", null, null, null, null));

		groupeService.ajouterGroupe(new Groupe(null, "Groupe1", null, ccl1));
		groupeService.ajouterGroupe(new Groupe(null, "Groupe2", null, ccl1));

		groupeService.ajouterGroupe(new Groupe(null, "Alpha", null, ccl2));
		groupeService.ajouterGroupe(new Groupe(null, "Beta", null, ccl2));
		enseignementService.ajouterEnseignement(
				new Enseignement(null, "testENS1",
						List.of("Objectif 1", "Objectif 2", "Objectif 3"),
						"Machin",
						ccl1, null, null));

	}

}
