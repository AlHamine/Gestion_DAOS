package com.uasz.Gestion_DAOS_Maquette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
		Cycle cycle1 = cycleService.ajouterCycle(new Cycle(null, "Licence", null));
		Cycle cycle2 = cycleService.ajouterCycle(new Cycle(null, "Master", null));
		Cycle cycle3 = cycleService.ajouterCycle(new Cycle(null, "Doctorat", null));
		// Les niveaux
		Niveau l1 = niveauService.ajouterNiveau(new Niveau(null, "L1", cycle1, null));
		Niveau l2 = niveauService.ajouterNiveau(new Niveau(null, "L2", cycle1, null));
		Niveau l3 = niveauService.ajouterNiveau(new Niveau(null, "M1", cycle2, null));
		// Les enseignants

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
				.ajouterFormation(new Formation(null, "L3_2I", filiere1, null, null, l3));
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
						semestre_6_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Génie Logiciel Anvacé-TP", null, module1_1,
				semestre_6_3_L21,
				null));
		Enseignement daos_cm = enseignementRepository
				.save(new Enseignement(null, "Développement d'Applications Orientés Service-CM", null, module2,
						semestre_6_3_L21, null));
		Enseignement daos_tp = enseignementRepository
				.save(new Enseignement(null, "Développement d'Applications Orientés Service-TP", null, module2_1,
						semestre_6_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Sécurité des réseux-CM", null, module3,
				semestre_6_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Sécurité des réseux-TP", null, module3_1,
				semestre_6_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Administration Réseaux-CM", null, module4,
				semestre_6_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Administration Réseaux-TP", null, module4_1,
				semestre_6_3_L21, null));
		enseignementRepository.save(new Enseignement(null, "Anglais 6", null, module5,
				semestre_6_3_L21,
				null));
		enseignementRepository.save(new Enseignement(null, "Droit des TICS", null, module6,
				semestre_6_3_L21, null));
		// ----------------------------------
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
						semestre_5_3_L21, groupe1));
		enseignementRepository.save(new Enseignement(null, "Genie Logiciel 1",
				null,
				module2, semestre_5_3_L21, groupe2));
		Enseignement enseignement2 = enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module3,
						semestre_5_3_L21, null));
		enseignementRepository
				.save(new Enseignement(null, "Reseaux et Telecoms", null, module4,
						semestre_5_3_L21, null));
	}
}
