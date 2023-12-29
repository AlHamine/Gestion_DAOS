package com.uasz.Gestion_DAOS;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS.Service.AllService;
import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.Semestre;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

@SpringBootApplication
public class GestionDaosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosApplication.class, args);
	}

	@Autowired
	private AllService allService;

	@Override
	public void run(String... args) throws Exception {
		// ueService.ajouterUE(new UE(null, "Reseaux et Telecoms", "INFF351", 8, 4, "",
		// null, null, 8, 5));
		allService.ueService.ajouterUE(new UE(
				null,
				"GL 1",
				"INFF351",
				null,
				null,
				null,
				new Date(),
				null,
				8,
				5));
		allService.ueService.ajouterUE(new UE(null,
				"GL 2",
				"INFF352",
				null,
				null,
				null, new Date(),
				null, 6,
				4));
		allService.ueService.ajouterUE(new UE(null,

				"Base de Donnees  1", "INFC101", null,
				null, null, new Date(), null, 7, 3));
		allService.ueService.ajouterUE(new UE(null,
				"Programmation1  2", "INFC102", null, null,
				null, new Date(), null, 6,
				3));
		allService.ueService.ajouterUE(new UE(
				null,
				"Math 1",
				"INFM201",
				null,
				null,
				null,
				new Date(),
				null,
				8,
				5));
		allService.ueService.ajouterUE(new UE(null,
				"Phys 1",
				"INFPH101",
				null,
				null, null,
				new Date(),
				null,
				7, 4));
		allService.semestreService.ajouterSemestre(new Semestre(null, "Bonnheur", null, null));

	}

	// machin

}
