package com.uasz.Gestion_DAOS_EmploiDuTemps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS_EmploiDuTemps.Service.SalleService;
import com.uasz.Gestion_DAOS_EmploiDuTemps.model.Salle;

@SpringBootApplication
public class GestionDaosEmploiDuTempsApplication implements CommandLineRunner {

	@Autowired
	SalleService salleService;
	public static void main(String[] args) {
		SpringApplication.run(GestionDaosEmploiDuTempsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		salleService.ajouterSalle(new Salle(null, "77", 77, null));
	}
}
