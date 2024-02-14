package com.uasz.Gestion_DAOS_Maquette;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.Gestion_DAOS_Maquette.Service.UEService;
import com.uasz.Gestion_DAOS_Maquette.model.UE;

@SpringBootApplication
public class GestionDaosMaquetteApplication implements CommandLineRunner {

	@Autowired
	UEService ueService;
	public static void main(String[] args) {
		SpringApplication.run(GestionDaosMaquetteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ueService.ajouterUE(new UE(null, "GL 1", "INFF351", null, null, null, new Date(), null, 8, 5));

	}

}
