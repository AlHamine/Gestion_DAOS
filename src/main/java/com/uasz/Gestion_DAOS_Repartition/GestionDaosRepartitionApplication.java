package com.uasz.Gestion_DAOS_Repartition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.uasz.Gestion_DAOS_Repartition.Service.EnseignementService;
import com.uasz.Gestion_DAOS_Repartition.model.Enseignement;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class GestionDaosRepartitionApplication implements CommandLineRunner {

	// private final UEProxy ueProxy;
	private final EnseignementService enseignementService;

	@Autowired // Ajout de l'annotation @Autowired
	public GestionDaosRepartitionApplication(EnseignementService enseignementService) {
		// this.ueProxy = ueProxy;
		this.enseignementService = enseignementService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosRepartitionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		enseignementService.ajouterEnseignement(new Enseignement(null, "libelle", null, "description"));
		// System.out.println(ueProxy.lister_ue());
	}
}
