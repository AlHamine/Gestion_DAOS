package com.uasz.Gestion_DAOS.Service.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.Repository.Maquette.MaquetteRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Formation;
import com.uasz.Gestion_DAOS.model.Maquette.Maquette;
import com.uasz.Gestion_DAOS.model.Maquette.Module;

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

    public Maquette modifierMaquette(Maquette m) {
        Maquette maquetteModifier = rechercherMaquette(m.getId());
        if (maquetteModifier != null) {
            maquetteModifier.setCm(m.getCm());
            maquetteModifier.setCoef(m.getCoef());
            maquetteModifier.setCoefUe(m.getCoefUe());
            maquetteModifier.setCredit(m.getCredit());
            maquetteModifier.setCumule(m.getCumule());
            maquetteModifier.setFormation(m.getFormation());
            maquetteModifier.setIntitule(m.getIntitule());
            maquetteModifier.setModules(m.getModules());
            maquetteModifier.setTd(m.getTd());
            maquetteModifier.setTp(m.getTp());
            maquetteModifier.setTpe(m.getTpe());
            // maquetteModifier.setUe(m.getUe());
            maquetteModifier.setVh(m.getVh());
            

            return maquetteRepository.save(maquetteModifier);
        } else
            return null;
    }

    // public Boolean suprimerMaquette(Maquette ue) {
    //     Maquette maquetteModifier = rechercherMaquette(ue.getId());
    //     if (maquetteModifier != null) {
    //         maquetteRepository.delete(ue);
    //         return true;
    //     } else
    //         return false;
    // }

    public Boolean suprimerMaquette(Long id) {
        Maquette maquetteModifier = rechercherMaquette(id);
        if (maquetteModifier != null) {
            maquetteRepository.delete(maquetteModifier);
            return true;
        } else
            return false;
    }

    public List<Module> moduleDetailsMaquette(Long id) {
       return maquetteRepository.moduleDetailsMaquette(id);
    }

    public List<Formation> formationDetailsMaquette(Long id) {
        return maquetteRepository.formationDetailsMaquette(id);
    }

}
