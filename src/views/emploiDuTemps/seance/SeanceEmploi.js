import React, { useEffect, useState } from 'react'
import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CTable,
  CTableBody,
  CFormInput,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
  CButton,
  CPagination,
  CPaginationItem,
} from '@coreui/react'
import { SERVER_URL } from 'src/constantURL'
import { Link } from 'react-router-dom'
import Card from '@mui/material/Card'
import CardContent from '@mui/material/CardContent'
import Typography from '@mui/material/Typography'
// import { DocsExample } from 'src/components'
import { useParams } from 'react-router-dom'
import EditIcon from '@mui/icons-material/Edit'
import DeleteIcon from '@mui/icons-material/Delete'
import { PDFDownloadLink } from '@react-pdf/renderer'
import PDFComponent from 'src/PDFComponent'
export default function SeanceEmploi() {
  const [listSeance, setListSeance] = useState([])
  const [emploi, setEmploi] = useState()
  const { id } = useParams()

  const [searchTerm, setSearchTerm] = useState('')
  const [itemsPerPage] = useState(10) // Nombre d'éléments par page
  const [currentPage, setCurrentPage] = useState(1) // La page courante
  const handleSearchChange = (libelle) => {
    setSearchTerm(libelle.target.value)
  }
  const lastPageNumber = Math.ceil(listSeance.length / itemsPerPage)

  const handleChangePaginate = (value) => {
    if (value === -100) {
      setCurrentPage(currentPage + 1)
    } else if (value === -200) {
      setCurrentPage(currentPage - 1)
    } else setCurrentPage(value)
  }
  // Index de la dernière UE à afficher sur la page
  const indexOfLastUE = currentPage * itemsPerPage
  // Index de la première UE à afficher sur la page
  const indexOfFirstUE = indexOfLastUE - itemsPerPage
  // Liste des UE à afficher sur la page actuelle
  const currentPER = listSeance
    .filter(
      (ue) =>
        ue.nom?.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.prenom?.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.libelle.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.classe.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.jour.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.dureee.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.heureDebut.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.salle.batimentNom.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.groupe?.toLowerCase().includes(searchTerm.toLowerCase()),
    )
    .slice(indexOfFirstUE, indexOfLastUE)
  const chargerEmploi = () => {
    fetch(SERVER_URL + 'emploi/emploi/' + id)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setEmploi(data))
      .catch((error) => console.error('Error fetching Seance:', error))
  }

  const fetchSeance = () => {
    fetch(SERVER_URL + 'emploi/' + id + '/seance')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListSeance(data))
      .catch((error) => console.error('Error fetching Seance:', error))
  }

  function extractDateOnly(dateTimeString) {
    // Vérifier si la chaîne est vide ou null
    if (!dateTimeString) {
      return null
    }

    // Extraire la date uniquement
    const dateOnly = dateTimeString.substring(0, 10)

    return dateOnly
  }
  const onDelClick = (id) => {
    // console.log(typeof id)
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `emploi/seance/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('Seance supprimer')
            fetchSeance()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
  }
  const testDonne = [
    {
      jour: 'Lundi',
      heureDebut: '8:00-10:00',
      prenom: 'Pierre',
      nom: 'Dupont',
      grade: 'Professeur',
      libelle: 'Algorithmique',
      classe: 'L2i',
      groupe: 'A',
      module: 'M2101',
      semestre: 1,
      salle: {
        batimentNom: 'Batiment A',
        numero: '101',
      },
      dureee: '120',
    },
    {
      jour: 'Mardi',
      heureDebut: '10:00-12:00',
      prenom: 'Marie',
      nom: 'Martin',
      grade: 'ATER',
      libelle: "Travaux Pratiques d'Algorithmique",
      classe: 'L2i',
      groupe: 'A',
      module: 'M2101',
      semestre: 1,
      salle: {
        batimentNom: 'Batiment C',
        numero: '202',
      },
      dureee: '90',
    },
    {
      jour: 'Mercredi',
      heureDebut: '15:00-17:00',
      prenom: 'Jean',
      nom: 'Durant',
      grade: 'Professeur',
      libelle: 'Bases de Données',
      classe: 'L2i',
      groupe: '',
      module: 'M2102',
      semestre: 1,
      salle: {
        batimentNom: 'Batiment B',
        numero: '305',
      },
      dureee: '120',
    },
    {
      jour: 'Jeudi',
      heureDebut: '17:00-19:00',
      nom: 'Aucun',
      prenom: '',
      grade: '',
      libelle: 'Créneau libre',
      classe: '',
      groupe: '',
      module: '',
      semestre: 0,
      salle: {
        batimentNom: '',
        numero: '',
      },
      dureee: '120',
    },
    {
      jour: 'Vendredi',
      heureDebut: '8:00-10:00',
      prenom: 'Sophie',
      nom: 'Lefebvre',
      grade: 'Ingénieur',
      libelle: 'Projet Web',
      classe: 'L2i',
      groupe: '',
      module: 'M2103',
      semestre: 1,
      salle: {
        batimentNom: 'Batiment A',
        numero: '105',
      },
      dureee: '120',
    },
  ]

  const handlePDFDownload = () => {
    PDFComponent({ seances: listSeance, emploi: emploi })
  }
  useEffect(() => {
    fetchSeance()
    chargerEmploi()
  }, [])
  return (
    <CRow>
      <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
        <div className="text-center">
          <Card>
            <CardContent>
              <Typography variant="body1">
                Liste des séances de l{"'"} emploi du{' '}
                <strong>{extractDateOnly(emploi?.dateDebut)}</strong> au{' '}
                <strong>{extractDateOnly(emploi?.dateFin)}</strong> de la Classe :{' '}
                <strong>{emploi?.classe}</strong> - Filière : <strong>{emploi?.filiere}</strong>
                <strong>{emploi?.nom}</strong>
              </Typography>
            </CardContent>
          </Card>
          <Link to={`/emploiDuTemps/seance/AjoutSeance/Emploi/${id}`}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un Seance
            </CButton>
          </Link>
          {/* <PDFDownloadLink document={<PDFComponent seances={listSeance} />} fileName="document.pdf">
            {({ blob, url, loading, error }) => (loading ? 'Chargement...' : 'Télécharger PDF')}
          </PDFDownloadLink> */}
          <CButton color="success" style={{ color: 'white' }} onClick={handlePDFDownload}>
            Télécharger PDF
          </CButton>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>
              Liste des seances de l{"'"}emploi du {extractDateOnly(emploi?.dateDebut)} au{' '}
              {extractDateOnly(emploi?.dateFin)} de la Classe : {emploi?.classe} - Filiere :{' '}
              {emploi?.filiere}
              <b>{emploi?.nom}</b>{' '}
            </strong>{' '}
            <CFormInput
              type="text"
              size="sm"
              placeholder="Rechercher Seance parEnseignant	Libelle	| Classe |	Module	| Semestre	| Batiment-Salle |	Jour	| HeureDebut |	Duree	| Operation	| Details"
              aria-label="sm input example"
              onChange={handleSearchChange}
            />
          </CCardHeader>
          <CCardBody>
            {/* <DocsExample href="components/table#table-head"> */}
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  {/* <CTableHeaderCell scope="col">#</CTableHeaderCell> */}
                  <CTableHeaderCell scope="col">Enseignant</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Libelle</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Classe</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Module</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Semestre</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Batiment-Salle</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Jour</CTableHeaderCell>
                  <CTableHeaderCell scope="col">HeureDebut</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Duree</CTableHeaderCell>
                  <CTableHeaderCell scope="col" className="text-center">
                    Operation
                  </CTableHeaderCell>
                  <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {currentPER.map((Seance, index) => (
                  <CTableRow key={index}>
                    {/* <CTableHeaderCell scope="row"> {index + 1} </CTableHeaderCell> */}
                    {/* <CTableDataCell>{Seance.numero}</CTableDataCell> */}
                    <CTableDataCell style={{ width: '6px' }}>
                      {Seance.prenom} {Seance.nom} {Seance.grade} en {Seance.specialite}
                    </CTableDataCell>
                    <CTableDataCell>{Seance.libelle}</CTableDataCell>
                    <CTableDataCell>
                      {Seance.classe} {Seance.groupe ? ` - Groupe : ${Seance.groupe}` : ''}
                    </CTableDataCell>
                    {/* <CTableDataCell>{Seance.enseignement.groupe.libelle} </CTableDataCell> */}
                    <CTableDataCell>{Seance.module}</CTableDataCell>
                    <CTableDataCell>{Seance.semestre}</CTableDataCell>

                    <CTableDataCell>
                      {Seance.salle.batimentNom}-{Seance.salle.numero}
                    </CTableDataCell>
                    <CTableDataCell>{Seance.jour}</CTableDataCell>
                    <CTableDataCell>{Seance.heureDebut}</CTableDataCell>
                    <CTableDataCell>{Seance.dureee}</CTableDataCell>
                    <CTableDataCell>
                      <Link to={`/emploiDuTemps/seance/ModifierSeance/Emploi/${id}/${Seance.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          <EditIcon className="icon4" />
                        </CButton>
                      </Link>
                      <CButton
                        style={{ color: 'white' }}
                        color="danger"
                        onClick={() => onDelClick(Seance.id)}
                      >
                        <DeleteIcon className="icon3" />
                      </CButton>
                    </CTableDataCell>
                    <CTableDataCell>
                      <Link to={`/emploiDuTemps/deroulement/Deroulement/${id}/${Seance.id}`}>
                        <CButton color="info">Gerer Deroulement</CButton>
                      </Link>
                    </CTableDataCell>
                  </CTableRow>
                ))}
                <CPagination align="end" aria-label="Page navigation example">
                  {currentPage === 1 ? (
                    <CPaginationItem disabled>Previous</CPaginationItem>
                  ) : (
                    <CPaginationItem onClick={() => handleChangePaginate(-200)}>
                      Previous
                    </CPaginationItem>
                  )}
                  {currentPage === 1 ? (
                    <CPaginationItem disabled>1</CPaginationItem>
                  ) : (
                    <CPaginationItem onClick={() => handleChangePaginate(1)}>1</CPaginationItem>
                  )}
                  {currentPage === lastPageNumber ? (
                    <CPaginationItem disabled>2</CPaginationItem>
                  ) : (
                    <CPaginationItem onClick={() => handleChangePaginate(2)}>2</CPaginationItem>
                  )}
                  {currentPage === lastPageNumber ? (
                    <CPaginationItem disabled>3</CPaginationItem>
                  ) : (
                    <CPaginationItem onClick={() => handleChangePaginate(3)}>3</CPaginationItem>
                  )}
                  {currentPage === lastPageNumber ? (
                    <CPaginationItem disabled>Fin</CPaginationItem>
                  ) : (
                    <CPaginationItem onClick={() => handleChangePaginate(lastPageNumber)}>
                      Fin
                    </CPaginationItem>
                  )}
                  {currentPage === lastPageNumber ? (
                    <CPaginationItem disabled>Next</CPaginationItem>
                  ) : (
                    <CPaginationItem onClick={() => handleChangePaginate(-100)}>
                      Next
                    </CPaginationItem>
                  )}
                </CPagination>
              </CTableBody>
            </CTable>
            {/* </DocsExample> */}
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}
