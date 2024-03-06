package com.uasz.Gestion_DAOS.Service;
import java.util.stream.Collectors;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Batiment;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.BatimentDTO;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.Salle;
import com.uasz.Gestion_DAOS.model.Emploie_Du_Temps.SalleDTO;

public class Mapper {
    public static BatimentDTO mapBatimentToDTO(Batiment b) {
        BatimentDTO bDTO = new BatimentDTO();
        bDTO.setId(b.getId());
        bDTO.setNom(b.getNom());
        bDTO.setSalles(b.getSalles().stream()
                .map(salle -> mapSalleToDTO(salle))
                .collect(Collectors.toList()));
        return bDTO;
    }

    public static SalleDTO mapSalleToDTO(Salle salle) {
        SalleDTO salleDTO = new SalleDTO();
        salleDTO.setId(salle.getId());
        salleDTO.setNumero(salle.getNumero());
        salleDTO.setCapacite(salle.getCapacite());
        salleDTO.setBatimentId(salle.getBatiment().getId());
        return salleDTO;
    }
}
