package com.uasz.Gestion_DAOS.Service.Repartition.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uasz.Gestion_DAOS.Repository.Maquette.ModuleRepository;
import com.uasz.Gestion_DAOS.model.Maquette.Enseignement;
import com.uasz.Gestion_DAOS.model.Maquette.Module;

import jakarta.transaction.Transactional;
import java.util.List;
@Service
@Transactional

public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public Module ajouterModule(Module module) {
        moduleRepository.save(module);
        return module;

    }

    public List<Module> afficherToutModule() {
        return moduleRepository.findAll();
    }

    public Module rechercherModule(Long id) {
        return moduleRepository.findById(id).get();
    }

    public Module modifierModule(Module module) {
        Module moduleModifier = rechercherModule(module.getId());
        if (moduleModifier != null) {
            moduleModifier.setEc(module.getEc());
            moduleModifier.setEnseignements(module.getEnseignements());
            moduleModifier.setMaquette(module.getMaquette());
            moduleModifier.setNom(module.getNom());
            moduleModifier.setSemestre(module.getSemestre());
            moduleModifier.setUe(module.getUe());
            return moduleRepository.save(moduleModifier);
        } else
            return null;
    }

    public Boolean suprimerModule(Long id) {
        Module moduleModifier = rechercherModule(id);
        if (moduleModifier != null) {
            moduleRepository.delete(moduleModifier);
            return true;
        } else
            return false;
    }

    public List<Enseignement> detailsModuleEnseignement(Long id) {
        // return moduleRepository.findById(id).get().getEnseignements();
        return moduleRepository.detailsModuleEnseignement(id);
    }

}
