package com.uasz.Gestion_DAOS_Maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.uasz.Gestion_DAOS_Maquette.Repository.ClasseRepository;
import com.uasz.Gestion_DAOS_Maquette.Repository.EnseignementRepository;
import com.uasz.Gestion_DAOS_Maquette.Repository.ModuleRepository;
import com.uasz.Gestion_DAOS_Maquette.Repository.SemestreRepository;
import com.uasz.Gestion_DAOS_Maquette.Service.*;
import com.uasz.Gestion_DAOS_Maquette.model.*;
import com.uasz.Gestion_DAOS_Maquette.model.Module;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionDaosMaquetteApplication implements CommandLineRunner {

	@Autowired
	private UEService ueService;

	@Autowired
	private ECService ecService;

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

	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private SemestreRepository semestreRepository;

	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private EnseignementRepository enseignementRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosMaquetteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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

		// Ajout des niveaux
		Cycle cycle1 = cycleService.ajouterCycle(new Cycle(null, "Bachelor", null));
		Cycle cycle2 = cycleService.ajouterCycle(new Cycle(null, "Ingenieurie", null));

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

		// ue_1);
		// ueService.ajouterUE(ue_2);
		// ueService.ajouterUE(ue_3);
		// ueService.ajouterUE(ue_4);
		// ueService.ajouterUE(ue_5);

	}
}
