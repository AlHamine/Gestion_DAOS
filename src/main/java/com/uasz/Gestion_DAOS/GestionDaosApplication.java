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
import com.uasz.Gestion_DAOS.Service.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.Service.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.Service.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.Classe;
import com.uasz.Gestion_DAOS.model.Maquette.Cycle;
import com.uasz.Gestion_DAOS.model.Maquette.EC;
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

		Niveau niveau1 = new Niveau(null, "L1", cycle1);
		niveauService.ajouterNiveau(niveau1);
		niveauService.ajouterNiveau(new Niveau(null, "L2", cycle1));
		niveauService.ajouterNiveau(new Niveau(null, "M1", cycle2));
		niveauService.ajouterNiveau(new Niveau(null, "testNiveau", cycle2));
		Classe ccl1 = new Classe(null, "L1-2I", null, null, null, null);
		classeService.ajouterClasse(ccl1);
		Classe ccl2 = new Classe(null, "L2-2I", null, null, null, null);
		classeService.ajouterClasse(ccl2);
		classeService.ajouterClasse(new Classe(null, "MI", null, null, null, null));

		classeService.ajouterClasse(new Classe(null, "MIO", null, null, null, null));
		classeService.ajouterClasse(new Classe(null, "GEOGRAPHIE", null, null, null, null));

		classeService.ajouterClasse(new Classe(null, "MATH", null, null, null, null));

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
