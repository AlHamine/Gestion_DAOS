package com.uasz.Gestion_DAOS;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Maquette.UE;

@SpringBootApplication
public class GestionDaosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GestionDaosApplication.class, args);
	}

	@Autowired
	private UEService ueService;

	@Override
	public void run(String... args) throws Exception {
		// ueService.ajouterUE(new UE(null, "Reseaux et Telecoms", "INFF351", 8, 4, "",
		// null, null, 8, 5));
		ueService.ajouterUE(new UE(
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
		ueService.ajouterUE(new UE(null,
				"GL 2",
				"INFF352",
				null,
				null,
				null, new Date(),
				null, 6,
				4));
		ueService.ajouterUE(new UE(null,

				"Base de Donnees  1", "INFC101", null,
				null, null, new Date(), null, 7, 3));
		ueService.ajouterUE(new UE(null,
				"Programmation1  2", "INFC102", null, null,
				null, new Date(), null, 6,
				3));
		ueService.ajouterUE(new UE(
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
		ueService.ajouterUE(new UE(null,
				"Phys 1", 
				"INFPH101",
				 null,
				 null, null,
				 new Date(),
				null,
				 7, 4));

	}

}
