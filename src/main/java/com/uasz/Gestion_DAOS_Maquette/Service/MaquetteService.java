package com.uasz.Gestion_DAOS_Maquette.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS_Maquette.Repository.MaquetteRepository;
import com.uasz.Gestion_DAOS_Maquette.model.Maquette;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MaquetteService {
    @Autowired
    private MaquetteRepository maquetteRepository;

    public Maquette ajouterMaquette(Maquette ue) {
        maquetteRepository.save(ue);
        return ue;

    }

    public List<Maquette> afficherToutMaquette() {
        return maquetteRepository.findAll();
    }

    public Maquette rechercherMaquette(Long id) {
        return maquetteRepository.findById(id).get();
    }

    public Maquette modifierMaquette(Maquette maquette) {
        Maquette maquetteModifier = rechercherMaquette(maquette.getId());
        if (maquetteModifier != null) {
            maquetteModifier.setCm(maquette.getCm());
            maquetteModifier.setCoef(maquette.getCoef());
            maquetteModifier.setCoefUe(maquette.getCoefUe());
            maquetteModifier.setCredit(maquette.getCredit());
            maquetteModifier.setCumule(maquette.getCumule());
            maquetteModifier.setFormation(maquette.getFormation());
            maquetteModifier.setIntitule(maquette.getIntitule());
            maquetteModifier.setModules(maquette.getModules());
            maquetteModifier.setTd(maquette.getTd());
            maquetteModifier.setTp(maquette.getTp());
            maquetteModifier.setTpe(maquette.getTpe());
            maquetteModifier.setUe(maquette.getUe());
            maquetteModifier.setVh(maquette.getVh());
            
            return maquetteRepository.save(maquetteModifier);
        } else
            return null;
    }

    public Boolean suprimerMaquette(Long id) {
        Maquette maquetteModifier = rechercherMaquette(id);
        if (maquetteModifier != null) {
            maquetteRepository.delete(maquetteModifier);
            return true;
        } else
            return false;
    }
}
