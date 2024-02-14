package com.uasz.Gestion_DAOS_Maquette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.Repository.UERepository;
import com.uasz.Gestion_DAOS_Maquette.model.EC;
import com.uasz.Gestion_DAOS_Maquette.model.UE;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UEService {
    @Autowired
    private UERepository ueRepository;

    public UE ajouterUE(UE ue) {
        ueRepository.save(ue);
        return ue;

    }

    public List<UE> afficherToutUE() {
        return ueRepository.findAll();
    }

    public UE rechercherUE(Long id) {
        if (!ueRepository.findById(id).isPresent()) {
            return null;
        }
        return ueRepository.findById(id).get();
    }

    public UE modifierUE(UE ue) {
        UE euModifier = rechercherUE(ue.getId());
        if (euModifier != null) {
            euModifier.setCode(ue.getCode());
            euModifier.setDescription(ue.getDescription());
            euModifier.setLibelle(ue.getLibelle());
            euModifier.setModule(ue.getModule());
            euModifier.setCredit(ue.getCredit());
            euModifier.setCoefficient(ue.getCoefficient());

            return ueRepository.save(euModifier);
        } else
            return null;
    }

    public UE modifierUE(Long id, UE ue) {
        UE euModifier = rechercherUE(id);
        if (euModifier != null) {
            euModifier.setCode(ue.getCode());
            euModifier.setDescription(ue.getDescription());
            euModifier.setLibelle(ue.getLibelle());
            euModifier.setModule(ue.getModule());
            euModifier.setCredit(ue.getCredit());
            euModifier.setCoefficient(ue.getCoefficient());

            return ueRepository.save(euModifier);
        } else
            return null;
    }

    // public Boolean suprimerUE(UE ue) {
    // UE euModifier = rechercherUE(ue.getId());
    // if (euModifier != null) {
    // ueRepository.delete(ue);
    // return true;
    // } else
    // return false;
    // }

    public Boolean suprimerUE(Long id) {
        UE eu = rechercherUE(id);
        if (eu != null) {
            ueRepository.delete(eu);
            return true;
        }
        return false;
    }

    public List<EC> detailsUE(Long id) {
        return ueRepository.findById(id).get().getEcs();
    }
}
