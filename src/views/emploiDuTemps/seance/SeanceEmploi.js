import React, { useEffect, useState } from 'react'
import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CTable,
  CTableBody,
  // CTableCaption,
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
export default function SeanceEmploi() {
  const [listSeance, setListSeance] = useState([])
  const [emploi, setEmploi] = useState()
  const { id } = useParams()

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
                  {/* <CTableHeaderCell scope="col">Details</CTableHeaderCell> */}
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {listSeance.map((Seance, index) => (
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
                    {/* <CTableDataCell>
                      <CButton color="info">Detail</CButton>
                    </CTableDataCell> */}
                  </CTableRow>
                ))}
                <CPagination align="end" aria-label="Page navigation example">
                  <CPaginationItem disabled>Previous</CPaginationItem>
                  <CPaginationItem>1</CPaginationItem>
                  <CPaginationItem>2</CPaginationItem>
                  <CPaginationItem>3</CPaginationItem>
                  <CPaginationItem>Next</CPaginationItem>
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
