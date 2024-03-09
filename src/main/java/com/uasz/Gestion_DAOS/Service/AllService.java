package com.uasz.Gestion_DAOS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.BatimentService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.DeroulementService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.EmploiService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SalleService;
import com.uasz.Gestion_DAOS.Service.Emploie_Du_Temps.SeanceService;
import com.uasz.Gestion_DAOS.Service.Repartition.EnseignantService;
import com.uasz.Gestion_DAOS.Service.Repartition.PERService;
import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;
import com.uasz.Gestion_DAOS.Service.Repartition.VacataireService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ClasseService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.CycleService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ECService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.EnseignementService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FiliereService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.FormationService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.GroupeService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.MaquetteService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.ModuleService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.NiveauService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.SemestreService;
import com.uasz.Gestion_DAOS.Service.Repartition.Maquette.UEService;
import com.uasz.Gestion_DAOS.model.Rapport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class AllService {
    @Autowired
    public UEService ueService;
    @Autowired
    public SemestreService semestreService;
    @Autowired
    public PERService perService;
    @Autowired
    public EnseignantService enseignantService;
    @Autowired
    public VacataireService vacataireService;
    @Autowired
    public RepartitionService repartitionService;
    @Autowired
    public NiveauService niveauService;
    @Autowired
    public ModuleService moduleService;
    @Autowired
    public MaquetteService maquetteService;
    @Autowired
    public GroupeService groupeService;
    @Autowired
    public FormationService formationService;
    @Autowired
    public FiliereService filiereService;
    @Autowired
    public EnseignementService enseignementService;
    @Autowired
    public ECService ecservice;
    @Autowired
    public CycleService cycleService;
    @Autowired
    public BatimentService batimentService;
    @Autowired
    public DeroulementService deroulementService;
    @Autowired
    public EmploiService emploiService;
    @Autowired
    public SalleService salleService;
    @Autowired
    public SeanceService seanceService;
    @Autowired
    public ClasseService classeService;

    public Rapport getRapport() {
        return new Rapport(enseignementService.afficherToutEnseignement().size(),
                enseignantService.afficherToutEnseignant().size(),
                vacataireService.afficherToutVacataire().size(), perService.afficherToutPER().size(),
                formationService.afficherToutFormation().size(),
                filiereService.afficherToutFiliere().size(), salleService.afficherToutSalle().size(),
                batimentService.afficherToutBatiment().size(), classeService.afficherToutClasse().size(),
                seanceService.afficherToutSeance().size(),
                repartitionService.afficherToutRepartition().size(), emploiService.afficherToutEmploi().size());
    }

}
