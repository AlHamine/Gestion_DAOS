import React from 'react'
import CIcon from '@coreui/icons-react'
import {
  cilBalanceScale,
  cilBell,
  cilCalculator,
  cilChartPie,
  cilCursor,
  cilDescription,
  cilDrop,
  cilLineStyle,
  cilNotes,
  cilPencil,
  cilPuzzle,
  cilSpeedometer,
  cilSpreadsheet,
  cilStar,
} from '@coreui/icons'
import { CNavGroup, CNavItem, CNavTitle } from '@coreui/react'

const _nav = [
  {
    component: CNavItem,
    name: 'Dashboard',
    to: '/dashboard',
    icon: <CIcon icon={cilSpeedometer} customClassName="nav-icon" />,
    badge: {
      color: 'info',
      text: 'NEW',
    },
  },
  {
    component: CNavTitle,
    name: 'GESTION DAOS',
  },
  //--------------------------- DAOS ---------------------------
  // --------------------------- LES ELEMENTS DE MAQUETTE ---------------------------
  {
    component: CNavGroup,
    name: 'Maquette',
    to: '/maquette',
    icon: <CIcon icon={cilLineStyle} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'Classe',
        to: '/maquette/classe/Classe',
      },
      {
        component: CNavItem,
        name: 'Cycle',
        to: '/maquette/cycle/Cycle',
      },
      {
        component: CNavItem,
        name: 'EC',
        to: '/maquette/ec/EC',
      },
      {
        component: CNavItem,
        name: 'Enseignement',
        to: '/maquette/enseignement/Enseignement',
      },
      {
        component: CNavItem,
        name: 'Filiere',
        to: '/maquette/filiere/Filiere',
      },
      {
        component: CNavItem,
        name: 'Formation',
        to: '/maquette/formation/Formation',
      },
      {
        component: CNavItem,
        name: 'Groupe',
        to: '/maquette/groupe/Groupe',
      },
      {
        component: CNavItem,
        name: 'Maquette',
        to: '/maquette/maquette/Maquette',
      },
      {
        component: CNavItem,
        name: 'Module',
        to: '/maquette/module/Module',
      },
      {
        component: CNavItem,
        name: 'Niveau',
        to: '/maquette/niveau/Niveau',
      },
      {
        component: CNavItem,
        name: 'Semestre',
        to: '/maquette/semestre/Semestre',
      },
      {
        component: CNavItem,
        name: 'UE',
        to: '/maquette/ue/UE',
      },
    ],
  },

  // --------------------------- LES ELEMENTS DE REPARTITION ---------------------------
  {
    component: CNavGroup,
    name: 'Repartition',
    to: '/repartition',
    icon: <CIcon icon={cilBalanceScale} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'Enseignant',
        to: '/repartition/enseignant/Enseignant',
      },
      {
        component: CNavItem,
        name: 'PER',
        to: '/repartition/per/PER',
      },
      {
        component: CNavItem,
        name: 'Repartition',
        to: '/repartition/repartition/Repartition',
      },
      {
        component: CNavItem,
        name: 'Vacataire',
        to: '/repartition/vacataire/Vacataire',
      },
    ],
  },

  // --------------------------- EMPLOI DU TEMPS ---------------------------
  {
    component: CNavGroup,
    name: 'Emploi Du Temps',
    to: '/emploiDuTemps',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'Batiment',
        to: '/emploiDuTemps/batiment/Batiment',
      },
      {
        component: CNavItem,
        name: 'Deroulement',
        to: '/emploiDuTemps/deroulement/Deroulement',
      },
      {
        component: CNavItem,
        name: 'Emploi',
        to: '/emploiDuTemps/emploi/Emploi',
      },
      {
        component: CNavItem,
        name: 'Salle',
        to: '/emploiDuTemps/salle/Salle',
      },
      {
        component: CNavItem,
        name: 'Seance',
        to: '/emploiDuTemps/seance/Seance',
      },
    ],
  },

  // --------------------------- FIN DAOS ---------------------------
  {
    component: CNavItem,
    name: 'Colors',
    to: '/theme/colors',
    icon: <CIcon icon={cilDrop} customClassName="nav-icon" />,
  },
  {
    component: CNavItem,
    name: 'Typography',
    to: '/theme/typography',
    icon: <CIcon icon={cilPencil} customClassName="nav-icon" />,
  },
  {
    component: CNavTitle,
    name: 'DAOS (Components)',
  },
  {
    component: CNavGroup,
    name: 'Maquette (Base)',
    to: '/base',
    icon: <CIcon icon={cilPuzzle} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'UE (Accordion)',
        // to: '/base/accordion',
        to: '/base/Ue',
      },
      {
        component: CNavItem,
        name: 'EC (Breadcrumb)',
        to: '/base/breadcrumbs',
      },
      {
        component: CNavItem,
        name: 'Module (Cards)',
        to: '/base/cards',
      },
      {
        component: CNavItem,
        name: 'Semetre (Carousel)',
        to: '/base/carousels',
      },
      {
        component: CNavItem,
        name: 'Maquette (Collapse)',
        to: '/base/collapses',
      },
      {
        component: CNavItem,
        name: 'Enseignement (List group)',
        to: '/base/list-groups',
      },
      {
        component: CNavItem,
        name: 'Cycle (Navs & Tabs)',
        to: '/base/navs',
      },
      {
        component: CNavItem,
        name: 'Niveau (Pagination)',
        to: '/base/paginations',
      },
      {
        component: CNavItem,
        name: 'Filiere (Placeholders)',
        to: '/base/placeholders',
      },
      {
        component: CNavItem,
        name: 'Formation (Popovers)',
        to: '/base/popovers',
      },
      {
        component: CNavItem,
        name: 'Classse (Progress)',
        to: '/base/progress',
      },
      {
        component: CNavItem,
        name: 'Groupe (Spinners)',
        to: '/base/spinners',
      },
      {
        component: CNavItem,
        name: 'Tables',
        to: '/base/tables',
      },
      {
        component: CNavItem,
        name: 'Tooltips',
        to: '/base/tooltips',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'Repartition (Buttons)',
    to: '/buttons',
    icon: <CIcon icon={cilCursor} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'Buttons',
        to: '/buttons/buttons',
      },
      {
        component: CNavItem,
        name: 'Buttons groups',
        to: '/buttons/button-groups',
      },
      {
        component: CNavItem,
        name: 'Dropdowns',
        to: '/buttons/dropdowns',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'Empoi du temps (Forms)',
    icon: <CIcon icon={cilNotes} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'Form Control',
        to: '/forms/form-control',
      },
      {
        component: CNavItem,
        name: 'Select',
        to: '/forms/select',
      },
      {
        component: CNavItem,
        name: 'Checks & Radios',
        to: '/forms/checks-radios',
      },
      {
        component: CNavItem,
        name: 'Range',
        to: '/forms/range',
      },
      {
        component: CNavItem,
        name: 'Input Group',
        to: '/forms/input-group',
      },
      {
        component: CNavItem,
        name: 'Floating Labels',
        to: '/forms/floating-labels',
      },
      {
        component: CNavItem,
        name: 'Layout',
        to: '/forms/layout',
      },
      {
        component: CNavItem,
        name: 'Validation',
        to: '/forms/validation',
      },
    ],
  },
  {
    component: CNavItem,
    name: 'Charts',
    to: '/charts',
    icon: <CIcon icon={cilChartPie} customClassName="nav-icon" />,
  },
  {
    component: CNavGroup,
    name: 'Icons',
    icon: <CIcon icon={cilStar} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'CoreUI Free',
        to: '/icons/coreui-icons',
        badge: {
          color: 'success',
          text: 'NEW',
        },
      },
      {
        component: CNavItem,
        name: 'CoreUI Flags',
        to: '/icons/flags',
      },
      {
        component: CNavItem,
        name: 'CoreUI Brands',
        to: '/icons/brands',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'Notifications',
    icon: <CIcon icon={cilBell} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'Alerts',
        to: '/notifications/alerts',
      },
      {
        component: CNavItem,
        name: 'Badges',
        to: '/notifications/badges',
      },
      {
        component: CNavItem,
        name: 'Modal',
        to: '/notifications/modals',
      },
      {
        component: CNavItem,
        name: 'Toasts',
        to: '/notifications/toasts',
      },
    ],
  },
  {
    component: CNavItem,
    name: 'Widgets',
    to: '/widgets',
    icon: <CIcon icon={cilCalculator} customClassName="nav-icon" />,
    badge: {
      color: 'info',
      text: 'NEW',
    },
  },
  {
    component: CNavTitle,
    name: 'Extras',
  },
  {
    component: CNavGroup,
    name: 'Pages',
    icon: <CIcon icon={cilStar} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: 'Login',
        to: '/login',
      },
      {
        component: CNavItem,
        name: 'Register',
        to: '/register',
      },
      {
        component: CNavItem,
        name: 'Error 404',
        to: '/404',
      },
      {
        component: CNavItem,
        name: 'Error 500',
        to: '/500',
      },
    ],
  },
  {
    component: CNavItem,
    name: 'Docs',
    href: 'https://coreui.io/react/docs/templates/installation/',
    icon: <CIcon icon={cilDescription} customClassName="nav-icon" />,
  },
]

export default _nav
