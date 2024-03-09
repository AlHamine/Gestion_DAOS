import React from 'react'

const Dashboard = React.lazy(() => import('./views/dashboard/Dashboard'))
const Colors = React.lazy(() => import('./views/theme/colors/Colors'))
const Typography = React.lazy(() => import('./views/theme/typography/Typography'))

// Base
const Accordion = React.lazy(() => import('./views/base/accordion/Accordion'))
// Ajout de nouvelle element
// const Ue = React.lazy(() => import('./views/base/ue/Ue'))
// const AddUe = React.lazy(() => import('./views/base/ue/AddUe'))
// const EditUe = React.lazy(() => import('./views/base/ue/EditUe'))
// Fin
const Breadcrumbs = React.lazy(() => import('./views/base/breadcrumbs/Breadcrumbs'))
const Cards = React.lazy(() => import('./views/base/cards/Cards'))
const Carousels = React.lazy(() => import('./views/base/carousels/Carousels'))
const Collapses = React.lazy(() => import('./views/base/collapses/Collapses'))
const ListGroups = React.lazy(() => import('./views/base/list-groups/ListGroups'))
const Navs = React.lazy(() => import('./views/base/navs/Navs'))
const Paginations = React.lazy(() => import('./views/base/paginations/Paginations'))
const Placeholders = React.lazy(() => import('./views/base/placeholders/Placeholders'))
const Popovers = React.lazy(() => import('./views/base/popovers/Popovers'))
const Progress = React.lazy(() => import('./views/base/progress/Progress'))
const Spinners = React.lazy(() => import('./views/base/spinners/Spinners'))
const Tables = React.lazy(() => import('./views/base/tables/Tables'))
const Tooltips = React.lazy(() => import('./views/base/tooltips/Tooltips'))

// Buttons
const Buttons = React.lazy(() => import('./views/buttons/buttons/Buttons'))
const ButtonGroups = React.lazy(() => import('./views/buttons/button-groups/ButtonGroups'))
const Dropdowns = React.lazy(() => import('./views/buttons/dropdowns/Dropdowns'))

//Forms
const ChecksRadios = React.lazy(() => import('./views/forms/checks-radios/ChecksRadios'))
const FloatingLabels = React.lazy(() => import('./views/forms/floating-labels/FloatingLabels'))
const FormControl = React.lazy(() => import('./views/forms/form-control/FormControl'))
const InputGroup = React.lazy(() => import('./views/forms/input-group/InputGroup'))
const Layout = React.lazy(() => import('./views/forms/layout/Layout'))
const Range = React.lazy(() => import('./views/forms/range/Range'))
const Select = React.lazy(() => import('./views/forms/select/Select'))
const Validation = React.lazy(() => import('./views/forms/validation/Validation'))

const Charts = React.lazy(() => import('./views/charts/Charts'))

// Icons
const CoreUIIcons = React.lazy(() => import('./views/icons/coreui-icons/CoreUIIcons'))
const Flags = React.lazy(() => import('./views/icons/flags/Flags'))
const Brands = React.lazy(() => import('./views/icons/brands/Brands'))

// Notifications
const Alerts = React.lazy(() => import('./views/notifications/alerts/Alerts'))
const Badges = React.lazy(() => import('./views/notifications/badges/Badges'))
const Modals = React.lazy(() => import('./views/notifications/modals/Modals'))
const Toasts = React.lazy(() => import('./views/notifications/toasts/Toasts'))

const Widgets = React.lazy(() => import('./views/widgets/Widgets'))

// Ajout de nouvelle routes
// ########################## Maquette ##########################
// ---------------------------- UE ----------------------------
const UE = React.lazy(() => import('./views/maquette/ue/UE'))
const AjouterUE = React.lazy(() => import('./views/maquette/ue/AjouterUE'))
const ModifierUE = React.lazy(() => import('./views/maquette/ue/ModifierUE'))
const UEDetailsEC = React.lazy(() => import('./views/maquette/ue/UEDetailsEC'))
// ---------------------------- Classe ----------------------------
const Classe = React.lazy(() => import('./views/maquette/classe/Classe'))
const AjouterClasse = React.lazy(() => import('./views/maquette/classe/AjouterClasse'))
const ModifierClasse = React.lazy(() => import('./views/maquette/classe/ModifierClasse'))
// ---------------------------- Cycle ----------------------------
const Cycle = React.lazy(() => import('./views/maquette/cycle/Cycle'))
const AjouterCycle = React.lazy(() => import('./views/maquette/cycle/AjouterCycle'))
const ModifierCycle = React.lazy(() => import('./views/maquette/cycle/ModifierCycle'))
// ---------------------------- EC ----------------------------
const EC = React.lazy(() => import('./views/maquette/ec/EC'))
const AjouterEC = React.lazy(() => import('./views/maquette/ec/AjouterEC'))
const ModifierEC = React.lazy(() => import('./views/maquette/ec/ModifierEC'))
// ---------------------------- Enseignement ----------------------------
const Enseignement = React.lazy(() => import('./views/maquette/enseignement/Enseignement'))
const AjouterEnseignement = React.lazy(() =>
  import('./views/maquette/enseignement/AjouterEnseignement'),
)
const ModifierEnseignement = React.lazy(() =>
  import('./views/maquette/enseignement/ModifierEnseignement'),
)
// ---------------------------- Filiere ----------------------------
const Filiere = React.lazy(() => import('./views/maquette/filiere/Filiere'))
const AjouterFiliere = React.lazy(() => import('./views/maquette/filiere/AjouterFiliere'))
const ModifierFiliere = React.lazy(() => import('./views/maquette/filiere/ModifierFiliere'))
// ---------------------------- Formation ----------------------------
const Formation = React.lazy(() => import('./views/maquette/formation/Formation'))
const AjouterFormation = React.lazy(() => import('./views/maquette/formation/AjouterFormation'))
const ModifierFormation = React.lazy(() => import('./views/maquette/formation/ModifierFormation'))
// ---------------------------- Groupe ----------------------------
const Groupe = React.lazy(() => import('./views/maquette/groupe/Groupe'))
const AjouterGroupe = React.lazy(() => import('./views/maquette/groupe/AjouterGroupe'))
const ModifierGroupe = React.lazy(() => import('./views/maquette/groupe/ModifierGroupe'))
// ---------------------------- Maquette ----------------------------
const Maquette = React.lazy(() => import('./views/maquette/maquette/Maquette'))
const AjouterMaquette = React.lazy(() => import('./views/maquette/maquette/AjouterMaquette'))
const ModifierMaquette = React.lazy(() => import('./views/maquette/maquette/ModifierMaquette'))
// ---------------------------- Module ----------------------------
const Module = React.lazy(() => import('./views/maquette/module/Module'))
const AjouterModule = React.lazy(() => import('./views/maquette/module/AjouterModule'))
const ModifierModule = React.lazy(() => import('./views/maquette/module/ModifierModule'))
// ---------------------------- Niveau ----------------------------
const Niveau = React.lazy(() => import('./views/maquette/niveau/Niveau'))
const AjouterNiveau = React.lazy(() => import('./views/maquette/niveau/AjouterNiveau'))
const ModifierNiveau = React.lazy(() => import('./views/maquette/niveau/ModifierNiveau'))
// ---------------------------- Semestre ----------------------------
const Semestre = React.lazy(() => import('./views/maquette/semestre/Semestre'))
const AjouterSemestre = React.lazy(() => import('./views/maquette/semestre/AjouterSemestre'))
const ModifierSemestre = React.lazy(() => import('./views/maquette/semestre/ModifierSemestre'))

// ########################## Emploi Du Temps ##########################
// ---------------------------- Batiment ----------------------------
const Batiment = React.lazy(() => import('./views/emploiDuTemps/batiment/Batiment'))
const AjouterBatiment = React.lazy(() => import('./views/emploiDuTemps/batiment/AjouterBatiment'))
const ModifierBatiment = React.lazy(() => import('./views/emploiDuTemps/batiment/ModifierBatiment'))
// ---------------------------- Deroulement ----------------------------
const Deroulement = React.lazy(() => import('./views/emploiDuTemps/deroulement/Deroulement'))
const AjouterDeroulement = React.lazy(() =>
  import('./views/emploiDuTemps/deroulement/AjouterDeroulement'),
)
const ModifierDeroulement = React.lazy(() =>
  import('./views/emploiDuTemps/deroulement/ModifierDeroulement'),
)
// ---------------------------- Emploi ----------------------------
const Emploi = React.lazy(() => import('./views/emploiDuTemps/emploi/Emploi'))
const AjouterEmploi = React.lazy(() => import('./views/emploiDuTemps/emploi/AjouterEmploi'))
const ModifierEmploi = React.lazy(() => import('./views/emploiDuTemps/emploi/ModifierEmploi'))
// ---------------------------- Salle ----------------------------
const Salle = React.lazy(() => import('./views/emploiDuTemps/salle/Salle'))
const BatimentSalle = React.lazy(() => import('./views/emploiDuTemps/salle/BatimentSalle'))

const AjouterSalle = React.lazy(() => import('./views/emploiDuTemps/salle/AjouterSalle'))
const AjouterSalleB = React.lazy(() => import('./views/emploiDuTemps/salle/BatimentSalleAjout'))
const ModifierSalle = React.lazy(() => import('./views/emploiDuTemps/salle/ModifierSalle'))
// ---------------------------- Seance ----------------------------
const Seance = React.lazy(() => import('./views/emploiDuTemps/seance/Seance'))
const SeanceEmploi = React.lazy(() => import('./views/emploiDuTemps/seance/SeanceEmploi'))
const AjoutSeanceEmploi = React.lazy(() => import('./views/emploiDuTemps/seance/AjoutSeanceEmploi'))
const ModifierSeanceEmploi = React.lazy(() =>
  import('./views/emploiDuTemps/seance/ModifierSeanceEmploi'),
)
const AjouterSeance = React.lazy(() => import('./views/emploiDuTemps/seance/AjouterSeance'))
const ModifierSeance = React.lazy(() => import('./views/emploiDuTemps/seance/ModifierSeance'))

// ########################## Repartition ##########################
// ---------------------------- Enseignant ----------------------------
const Enseignant = React.lazy(() => import('./views/repartition/enseignant/Enseignant'))
const AjouterEnseignant = React.lazy(() =>
  import('./views/repartition/enseignant/AjouterEnseignant'),
)
const ModifierEnseignant = React.lazy(() =>
  import('./views/repartition/enseignant/ModifierEnseignant'),
)
// ---------------------------- PER ----------------------------
const PER = React.lazy(() => import('./views/repartition/per/PER'))
const AjouterPER = React.lazy(() => import('./views/repartition/per/AjouterPER'))
const ModifierPER = React.lazy(() => import('./views/repartition/per/ModifierPER'))
// ---------------------------- Repartition ----------------------------
const Repartition = React.lazy(() => import('./views/repartition/repartition/Repartition'))
const AjouterRepartition = React.lazy(() =>
  import('./views/repartition/repartition/AjouterRepartition'),
)
const ModifierRepartition = React.lazy(() =>
  import('./views/repartition/repartition/ModifierRepartition'),
)
// ---------------------------- Vacataire ----------------------------
const Vacataire = React.lazy(() => import('./views/repartition/vacataire/Vacataire'))
const AjouterVacataire = React.lazy(() => import('./views/repartition/vacataire/AjouterVacataire'))
const ModifierVacataire = React.lazy(() =>
  import('./views/repartition/vacataire/ModifierVacataire'),
)

const routes = [
  { path: '/', exact: true, name: 'Home' },
  { path: '/dashboard', name: 'Dashboard', element: Dashboard },
  { path: '/theme', name: 'Theme', element: Colors, exact: true },
  { path: '/theme/colors', name: 'Colors', element: Colors },
  { path: '/theme/typography', name: 'Typography', element: Typography },
  { path: '/base', name: 'Base', element: Cards, exact: true },
  { path: '/base/accordion', name: 'Accordion', element: Accordion },
  // --------------------- AJOUT DES ELEMENTS ---------------------
  // ########################## Maquette ##########################
  // ---------------------------- Classe ----------------------------
  { path: '/maquette/classe/Classe', name: 'Classe', element: Classe },
  { path: '/maquette/classe/AjouterClasse', name: 'AjouterClasse', element: AjouterClasse },
  { path: '/maquette/classe/ModifierClasse/:id', name: 'ModifierClasse', element: ModifierClasse },
  // ---------------------------- Cycle ----------------------------
  { path: '/maquette/cycle/Cycle', name: 'Cycle', element: Cycle },
  { path: '/maquette/cycle/AjouterCycle', name: 'AjouterCycle', element: AjouterCycle },
  { path: '/maquette/cycle/ModifierCycle/:id', name: 'ModifierCycle', element: ModifierCycle },
  // ---------------------------- EC ----------------------------
  { path: '/maquette/ec/EC', name: 'EC', element: EC },
  { path: '/maquette/ec/AjouterEC', name: 'AjouterEC', element: AjouterEC },
  { path: '/maquette/ec/ModifierEC/:id', name: 'ModifierEC', element: ModifierEC },
  // ---------------------------- Enseignement ----------------------------
  { path: '/maquette/enseignement/Enseignement', name: 'Enseignement', element: Enseignement },
  {
    path: '/maquette/enseignement/AjouterEnseignement',
    name: 'AjouterEnseignementEnseignement',
    element: AjouterEnseignement,
  },
  {
    path: '/maquette/enseignement/ModifierEnseignement/:id',
    name: 'ModifierEnseignement',
    element: ModifierEnseignement,
  },
  // ---------------------------- Filiere ----------------------------
  { path: '/maquette/filiere/Filiere', name: 'Filiere', element: Filiere },
  { path: '/maquette/filiere/AjouterFiliere', name: 'AjouterFiliere', element: AjouterFiliere },
  {
    path: '/maquette/filiere/ModifierFiliere/:id',
    name: 'ModifierFiliere',
    element: ModifierFiliere,
  },
  // ---------------------------- Formation ----------------------------
  { path: '/maquette/formation/Formation', name: 'Formation', element: Formation },
  {
    path: '/maquette/formation/AjouterFormation',
    name: 'AjouterFormation',
    element: AjouterFormation,
  },
  {
    path: '/maquette/formation/ModifierFormation/:id',
    name: 'ModifierFormation',
    element: ModifierFormation,
  },
  // ---------------------------- Groupe ----------------------------
  { path: '/maquette/groupe/Groupe', name: 'Groupe', element: Groupe },
  {
    path: '/maquette/groupe/AjouterGroupe',
    name: 'AjouterGroupe',
    element: AjouterGroupe,
  },
  {
    path: '/maquette/groupe/ModifierGroupe/:id',
    name: 'ModifierGroupe',
    element: ModifierGroupe,
  },
  // ---------------------------- Maquette ----------------------------
  { path: '/maquette/maquette/Maquette', name: 'Maquette', element: Maquette },
  {
    path: '/maquette/maquette/AjouterMaquette',
    name: 'AjouterMaquette',
    element: AjouterMaquette,
  },
  {
    path: '/maquette/maquette/ModifierMaquette/:id',
    name: 'ModifierMaquette',
    element: ModifierMaquette,
  },
  // ---------------------------- Module ----------------------------
  { path: '/maquette/module/Module', name: 'Module', element: Module },
  {
    path: '/maquette/module/AjouterModule',
    name: 'AjouterModule',
    element: AjouterModule,
  },
  {
    path: '/maquette/module/ModifierModule/:id',
    name: 'ModifierModule',
    element: ModifierModule,
  },
  // ---------------------------- Niveau ----------------------------
  { path: '/maquette/niveau/Niveau', name: 'Niveau', element: Niveau },
  {
    path: '/maquette/niveau/AjouterNiveau',
    name: 'AjouterNiveau',
    element: AjouterNiveau,
  },
  {
    path: '/maquette/niveau/ModifierNiveau/:id',
    name: 'ModifierNiveau',
    element: ModifierNiveau,
  },
  // ---------------------------- Semestre ----------------------------
  { path: '/maquette/semestre/Semestre', name: 'Semestre', element: Semestre },
  {
    path: '/maquette/semestre/AjouterSemestre',
    name: 'AjouterSemestre',
    element: AjouterSemestre,
  },
  {
    path: '/maquette/semestre/ModifierSemestre/:id',
    name: 'ModifierSemestre',
    element: ModifierSemestre,
  },
  // ---------------------------- UE ----------------------------
  { path: '/maquette/ue/UE', name: 'UE', element: UE },
  { path: '/maquette/ue/AjouterUE', name: 'AjouterUE', element: AjouterUE },
  { path: '/maquette/ue/ModifierUE/:id', name: 'ModifierUE', element: ModifierUE },
  { path: '/maquette/ue/:id/UEDetailsEC', name: 'UEDetailsEC', element: UEDetailsEC },

  // ########################## Repartition ##########################
  // ---------------------------- Enseignant ----------------------------
  { path: '/repartition/enseignant/Enseignant', name: 'Enseignant', element: Enseignant },
  {
    path: '/repartition/enseignant/AjouterEnseignant',
    name: 'AjouterEnseignant',
    element: AjouterEnseignant,
  },
  {
    path: '/repartition/enseignant/ModifierEnseignant/:id',
    name: 'ModifierEnseignant',
    element: ModifierEnseignant,
  },
  // ---------------------------- PER ----------------------------
  { path: '/repartition/per/PER', name: 'PER', element: PER },
  {
    path: '/repartition/per/AjouterPER',
    name: 'AjouterPER',
    element: AjouterPER,
  },
  {
    path: '/repartition/per/ModifierPER/:id',
    name: 'ModifierPER',
    element: ModifierPER,
  },
  // ---------------------------- Repartition ----------------------------
  { path: '/repartition/repartition/Repartition', name: 'Repartition', element: Repartition },
  {
    path: '/repartition/repartition/AjouterRepartition',
    name: 'AjouterRepartition',
    element: AjouterRepartition,
  },
  {
    path: '/repartition/repartition/ModifierRepartition/:id',
    name: 'ModifierRepartition',
    element: ModifierRepartition,
  },
  // ---------------------------- Vacataire ----------------------------
  { path: '/repartition/vacataire/Vacataire', name: 'Vacataire', element: Vacataire },
  {
    path: '/repartition/vacataire/AjouterVacataire',
    name: 'AjouterVacataire',
    element: AjouterVacataire,
  },
  {
    path: '/repartition/vacataire/ModifierVacataire/:id',
    name: 'ModifierVacataire',
    element: ModifierVacataire,
  },

  // ########################## Emploi Du Temps ##########################
  // ---------------------------- Batiment ----------------------------
  { path: '/emploiDuTemps/batiment/Batiment', name: 'Batiment', element: Batiment },
  {
    path: '/emploiDuTemps/batiment/AjouterBatiment',
    name: 'AjouterBatiment',
    element: AjouterBatiment,
  },
  {
    path: '/emploiDuTemps/batiment/ModifierBatiment/:id',
    name: 'ModifierBatiment',
    element: ModifierBatiment,
  },
  // ---------------------------- Deroulement ----------------------------
  {
    path: '/emploiDuTemps/deroulement/Deroulement/:id/:idseance',
    name: 'Deroulement',
    element: Deroulement,
  },
  {
    path: '/emploiDuTemps/deroulement/AjouterDeroulement/:idE/:idseance',
    name: 'AjouterDeroulement',
    element: AjouterDeroulement,
  },
  {
    path: '/emploiDuTemps/deroulement/ModifierDeroulement/:idE/:idseance/:id',
    name: 'ModifierDeroulement',
    element: ModifierDeroulement,
  },
  // ---------------------------- Emploi ----------------------------
  { path: '/emploiDuTemps/emploi/Emploi', name: 'Emploi', element: Emploi },
  {
    path: '/emploiDuTemps/emploi/AjouterEmploi',
    name: 'AjouterEmploi',
    element: AjouterEmploi,
  },
  {
    path: '/emploiDuTemps/emploi/ModifierEmploi/:id',
    name: 'ModifierEmploi',
    element: ModifierEmploi,
  },
  // ---------------------------- Salle ----------------------------
  { path: '/emploiDuTemps/salle/Salle', name: 'Salle', element: Salle },
  { path: '/emploiDuTemps/batiment/:id/Salle', name: 'BatimentSalle', element: BatimentSalle },
  {
    path: '/emploiDuTemps/salle/AjouterSalle',
    name: 'AjouterSalle',
    element: AjouterSalle,
  },
  {
    path: '/emploiDuTemps/batiment/:id/AjouterSalle',
    name: 'AjouterSalleB',
    element: AjouterSalleB,
  },
  {
    path: '/emploiDuTemps/salle/ModifierSalle/:id',
    name: 'ModifierSalle',
    element: ModifierSalle,
  },

  //
  { path: '/emploiDuTemps/seance/Seance/Emploi/:id', name: 'SeanceEmploi', element: SeanceEmploi },
  {
    path: '/emploiDuTemps/seance/AjoutSeance/Emploi/:id',
    name: 'AjoutSeanceEmploi',
    element: AjoutSeanceEmploi,
  },
  {
    path: '/emploiDuTemps/seance/ModifierSeance/Emploi/:id/:idseance',
    name: 'ModifierSeanceEmploi',
    element: ModifierSeanceEmploi,
  },

  //

  // ---------------------------- Seance ----------------------------
  { path: '/emploiDuTemps/seance/Seance', name: 'Seance', element: Seance },
  {
    path: '/emploiDuTemps/seance/AjouterSeance',
    name: 'AjouterSeance',
    element: AjouterSeance,
  },
  {
    path: '/emploiDuTemps/seance/ModifierSeance/:id',
    name: 'ModifierSeance',
    element: ModifierSeance,
  },

  // ---------------------------- FIN ----------------------------
  { path: '/base/breadcrumbs', name: 'Breadcrumbs', element: Breadcrumbs },
  { path: '/base/cards', name: 'Cards', element: Cards },
  { path: '/base/carousels', name: 'Carousel', element: Carousels },
  { path: '/base/collapses', name: 'Collapse', element: Collapses },
  { path: '/base/list-groups', name: 'List Groups', element: ListGroups },
  { path: '/base/navs', name: 'Navs', element: Navs },
  { path: '/base/paginations', name: 'Paginations', element: Paginations },
  { path: '/base/placeholders', name: 'Placeholders', element: Placeholders },
  { path: '/base/popovers', name: 'Popovers', element: Popovers },
  { path: '/base/progress', name: 'Progress', element: Progress },
  { path: '/base/spinners', name: 'Spinners', element: Spinners },
  { path: '/base/tables', name: 'Tables', element: Tables },
  { path: '/base/tooltips', name: 'Tooltips', element: Tooltips },
  { path: '/buttons', name: 'Buttons', element: Buttons, exact: true },
  { path: '/buttons/buttons', name: 'Buttons', element: Buttons },
  { path: '/buttons/dropdowns', name: 'Dropdowns', element: Dropdowns },
  { path: '/buttons/button-groups', name: 'Button Groups', element: ButtonGroups },
  { path: '/charts', name: 'Charts', element: Charts },
  { path: '/forms', name: 'Forms', element: FormControl, exact: true },
  { path: '/forms/form-control', name: 'Form Control', element: FormControl },
  { path: '/forms/select', name: 'Select', element: Select },
  { path: '/forms/checks-radios', name: 'Checks & Radios', element: ChecksRadios },
  { path: '/forms/range', name: 'Range', element: Range },
  { path: '/forms/input-group', name: 'Input Group', element: InputGroup },
  { path: '/forms/floating-labels', name: 'Floating Labels', element: FloatingLabels },
  { path: '/forms/layout', name: 'Layout', element: Layout },
  { path: '/forms/validation', name: 'Validation', element: Validation },
  { path: '/icons', exact: true, name: 'Icons', element: CoreUIIcons },
  { path: '/icons/coreui-icons', name: 'CoreUI Icons', element: CoreUIIcons },
  { path: '/icons/flags', name: 'Flags', element: Flags },
  { path: '/icons/brands', name: 'Brands', element: Brands },
  { path: '/notifications', name: 'Notifications', element: Alerts, exact: true },
  { path: '/notifications/alerts', name: 'Alerts', element: Alerts },
  { path: '/notifications/badges', name: 'Badges', element: Badges },
  { path: '/notifications/modals', name: 'Modals', element: Modals },
  { path: '/notifications/toasts', name: 'Toasts', element: Toasts },
  { path: '/widgets', name: 'Widgets', element: Widgets },
]

export default routes
