package com.uasz.Gestion_DAOS_Repartition;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Interface.MaquetteProxy;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Model.Enseignement;
import com.uasz.Gestion_DAOS_Repartition.Maquette_Service.Service.EnseignementService;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GestionDaosRepartitionApplication implements CommandLineRunner {

	@Autowired // Ajout de l'annotation @Autowired
	EnseignementService enseignementService;

	public static void main(String[] args) {

		SpringApplication.run(GestionDaosRepartitionApplication.class, args);
	}

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
	}
}
