package com.uasz.Gestion_DAOS.Service.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Repository.Maquette.ECRepository;
import com.uasz.Gestion_DAOS.model.Maquette.EC;

import jakarta.transaction.Transactional;
import java.util.List;
@Service
@Transactional

    public class ECService {
    @Autowired
    private ECRepository ecRepository;

    public EC ajouterEC(EC ec) {
        ecRepository.save(ec);
        return ec;

    }

    public List<EC> afficherToutEC() {
        return ecRepository.findAll();
    }

    public EC rechercherEC(Long id) {
        return ecRepository.findById(id).get();
    }

    public EC modifierEC(EC ec) {
        EC ecModifier = rechercherEC(ec.getId());
        if (ecModifier != null) {
            ecModifier.setCode(ec.getCode());
            ecModifier.setDescription(ec.getDescription());
            ecModifier.setLibelle(ec.getLibelle());
            ecModifier.setModule(ec.getModule());
            ecModifier.setUe(ec.getUe());
            return ecRepository.save(ecModifier);
        } else
            return null;
    }

    public Boolean suprimerEC(Long id) {
        EC ecModifier = rechercherEC(id);
        if (ecModifier != null) {
            ecRepository.delete(ecModifier);
            return true;
        } else
            return false;
    }



}
