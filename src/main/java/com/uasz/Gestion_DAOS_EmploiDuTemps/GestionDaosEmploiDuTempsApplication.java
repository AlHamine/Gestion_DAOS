package com.uasz.Gestion_DAOS_EmploiDuTemps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Interface.MaquetteProxy;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Maquette_Service.Service.EnseignementService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.Interface.RepartitionProxy;
import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.Service.RepartitionService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.RepartitionService.model.Repartition;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Service.BatimentService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Service.DeroulementService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Service.EmploiService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.Service.SalleService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Batiment;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Deroulement;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Emploi;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Salle;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Seance;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class GestionDaosEmploiDuTempsApplication implements CommandLineRunner {

	@Autowired
	SalleService salleService;

	@Autowired
	BatimentService batimentService;
	@Autowired
	EmploiService emploiService;
	@Autowired
	DeroulementService deroulementService;

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosEmploiDuTempsApplication.class, args);
	}

	private final RepartitionProxy proxy;
	RepartitionService repartitionService;

	public GestionDaosEmploiDuTempsApplication(RepartitionProxy proxy, RepartitionService repartitionService) {
		this.proxy = proxy;
		this.repartitionService = repartitionService;
	}

	@Override
	public void run(String... args) throws Exception {
		List<Repartition> repartitions = proxy.lister_seance_Repartitions();
		for (Repartition e : repartitions) {
			repartitionService.ajouterRepartition(e);

		}
		// AJout des Batiment
		Batiment b1 = new Batiment(null, "Bloc Scientifique", null);
		batimentService.ajouterBatiment(b1);

		Batiment b3 = new Batiment(null, "Batiment Informatique", null);
		batimentService.ajouterBatiment(b3);
		batimentService.ajouterBatiment(b1);
		Batiment b2 = new Batiment(null, "PGF SUP", null);

		batimentService.ajouterBatiment(b2);
		Salle salle1 = salleService.ajouterSalle(new Salle(null, "A1", 15, b1, null));
		salleService.ajouterSalle(new Salle(null, "B4", 25, b2, null));

		salleService.ajouterSalle(new Salle(null, "F02", 25, b3, null));
		salleService.ajouterSalle(new Salle(null, "F03", 25, b3, null));
		salleService.ajouterSalle(new Salle(null, "F01", 25, b3, null));
		salleService.ajouterSalle(new Salle(null, "F04", 25, b3, null));

		// Emploi em1 = emploiService
		// .ajouterEmploi(new Emploi(null, null, new Date(), new Date()));
		// seanceService.ajouterSeance(seance1);
		// Seance seance1 = seanceService.ajouterSeance(new Seance(null, "Lundi",
		// "08:00", "01:30",
		// em1, null,
		// null, salle1));
		// Deroulement d1 = new Deroulement(null,
		// "Initialiation aux Application Monolithique - Introduction aux microService -
		// Realise d'une application MicroService",
		// " Initiation aux Applications Monolithiques : Formation sur les bases de
		// conception, développement et déploiement d'applications monolithiques.\n"
		// + //
		// " Introduction aux Microservices : Cours explorant les concepts clés des
		// microservices et leur utilisation dans les architectures logicielles.\n"
		// + //
		// " Réalisation d'une Application Microservice : Apprentissage pratique de la
		// conception, du développement et du déploiement d'une application basée sur
		// l'architecture microservices.",
		// seance1);
		// deroulementService.ajouterDeroulement(d1);

	}
}
