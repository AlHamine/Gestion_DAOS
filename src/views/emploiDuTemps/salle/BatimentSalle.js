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
import { useParams } from 'react-router-dom'
import Typography from 'src/views/theme/typography/Typography'
// import { DocsExample } from 'src/components'

export default function BatimentSalle() {
  const { id } = useParams()
  const [listSalle, setListSalle] = useState([])
  const [batiment, setBatiment] = useState({})

  useEffect(() => {
    const chargerbatiments = () => {
      fetch(SERVER_URL + `emploi/batiment/${id}`, {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setBatiment(data))
        .catch((err) => console.error(err))
    }
    chargerbatiments()
    fetchSalle()
  }, [])

  const fetchSalle = () => {
    fetch(SERVER_URL + `emploi/batiment/${id}/salles`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListSalle(data))
      .catch((error) => console.error('Error fetching Salle:', error))
  }

  const onDelClick = (id) => {
    // console.log(typeof id)
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `emploi/salle/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('Salle supprimer')
            fetchSalle()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
  }

  return (
    <CRow>
      <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
        <div className="text-center">
          <p style={{ fontSize: '30px' }}>
            Liste des salles du batiment <b>{batiment.nom}</b>{' '}
          </p>
          <Link to={`/emploiDuTemps/batiment/${id}/AjouterSalle`}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un Salle
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des Salle</small>
          </CCardHeader>
          <CCardBody>
            {/* <DocsExample href="components/table#table-head"> */}
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  <CTableHeaderCell scope="col">#</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Numero</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Capacite</CTableHeaderCell>
                  <CTableHeaderCell scope="col" className="text-center">
                    Operation
                  </CTableHeaderCell>
                  {/* <CTableHeaderCell scope="col">Details</CTableHeaderCell> */}
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {listSalle.map((Salle, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell scope="row"> {index + 1} </CTableHeaderCell>
                    <CTableDataCell>{Salle.numero}</CTableDataCell>
                    <CTableDataCell>{Salle.capacite}</CTableDataCell>
                    <CTableDataCell className="text-center">
                      {/* <CButton color="primary" className="me-1">
                        Modifier
                      </CButton> */}
                      <Link to={`/emploiDuTemps/salle/ModifierSalle/${Salle.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          Modifier
                        </CButton>
                      </Link>
                      <CButton color="danger" onClick={() => onDelClick(Salle.id)}>
                        Supprimer
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
