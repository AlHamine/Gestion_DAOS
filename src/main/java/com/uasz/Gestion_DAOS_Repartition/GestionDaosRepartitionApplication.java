package com.uasz.Gestion_DAOS_Repartition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS_Repartition.Service.EnseignementService;
import com.uasz.Gestion_DAOS_Repartition.model.Enseignement;

@SpringBootApplication
public class GestionDaosRepartitionApplication implements CommandLineRunner {

	@Autowired
	EnseignementService enseignementService;
	public static void main(String[] args) {
		SpringApplication.run(GestionDaosRepartitionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		enseignementService.ajouterEnseignement(new Enseignement(null, "libelle", null, "description"));
	}

}
