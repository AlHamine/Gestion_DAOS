import jsPDF from 'jspdf'
import autoTable from 'jspdf-autotable'
import PropTypes from 'prop-types'

function extractDateOnly(dateTimeString) {
  // Vérifier si la chaîne est vide ou null
  if (!dateTimeString) {
    return null
  }

  // Extraire la date uniquement
  const dateOnly = dateTimeString.substring(0, 10)

  return dateOnly
}
const PDFComponent = ({ seances, emploi }) => {
  // Créer un nouveau document PDF en mode paysage avec des dimensions personnalisées
  const doc = new jsPDF({
    orientation: 'landscape',
    unit: 'pt', // Unité de mesure : points
    format: [842, 595], // Format A4 en mode paysage : largeur = 842 pts, hauteur = 595 pts
  })
  // doc.internal.scaleFactor = 1.25
  const entete = `EMPLOI DU TEMPS DU ${extractDateOnly(emploi?.dateDebut)} au ${extractDateOnly(
    emploi?.dateFin,
  )} de la Classe :\n ${emploi?.classe}  - Filière : ${emploi?.filiere}`
  doc.text(entete, 50, 30)
  // Créer les en-têtes de tableau avec les jours de la semaine et les heures
  const headers = ['  ', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi']
  const hours = ['8:00', '9:00', '10:00', '11:00', '12:00', '15:00', '16:00', '17:00', '19:00']

  // Préparer les données du tableau
  const tableData = hours.map((hour, index) => {
    const row = [hour]
    headers.slice(1).forEach((day) => {
      const seance = seances.find((s) => s.jour == day && s.heureDebut == hour)
      if (seance) {
        row.push(
          `${seance.module != null ? seance.module : seance.libelle}\n${seance.prenom} ${
            seance.nom
          }\n${seance.classe} ${seance.groupe ? `(${seance.groupe})` : ''}\n${
            seance.salle.batimentNom
          }-${seance.salle.numero}\nDuree: ${seance.dureee}`,
        )
      } else {
        row.push('-')
      }
    })
    return row
  })

  // Générer le tableau à l'aide du plugin jspdf-autotable
  autoTable(doc, {
    head: [headers],
    body: tableData,
    margin: { top: 90, left: 90, right: 90 },
    tableWidth: 750, // Augmenter la largeur du tableau
    columnStyles: {
      0: { columnWidth: 100 }, // Première colonne pour les noms d'enseignants
      1: { columnWidth: 100 }, // Lundi
      2: { columnWidth: 100 }, // Mardi
      3: { columnWidth: 100 }, // Mercredi
      4: { columnWidth: 100 }, // Jeudi
      5: { columnWidth: 100 }, // Vendredi
      6: { columnWidth: 100 }, // Samedi
    },
    styles: {
      // Bordures du tableau
      // cellPadding: 1, // Espacement entre le contenu et les bordures
      // fillColor: [85, 107, 47], // Couleur de fond des cellules
      // textColor: [0, 0, 0], // Couleur du texte
      // lineColor: [0, 0, 0], // Couleur des bordures
      lineWidth: 0.5,
    },
  })

  // Enregistrer le document PDF avec le nom spécifié
  doc.save('emploi_du_temps_L2i.pdf')
}

PDFComponent.propTypes = {
  seances: PropTypes.array.isRequired, // Validez que seances est un tableau et qu'il est requis
}

export default PDFComponent
