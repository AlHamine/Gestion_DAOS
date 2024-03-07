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
// import { DocsExample } from 'src/components'

import EditIcon from '@mui/icons-material/Edit'
import DeleteIcon from '@mui/icons-material/Delete'
export default function Vacataire() {
  const [listVacataire, setListVacataire] = useState([])

  useEffect(() => {
    fetchVacataire()
  }, [])

  const fetchVacataire = () => {
    fetch(SERVER_URL + 'repartition/vacataire')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListVacataire(data))
      .catch((error) => console.error('Error fetching Vacataire:', error))
  }

  const onDelClick = (id) => {
    // console.log(typeof id)
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `repartition/vacataire/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('Vacataire supprimer')
            fetchVacataire()
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
          <Link to={'/repartition/vacataire/AjouterVacataire'}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un Vacataire
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des Vacataire</small>
          </CCardHeader>
          <CCardBody>
            {/* <DocsExample href="components/table#table-head"> */}
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  <CTableHeaderCell scope="col">#</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Prenom</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Nom</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Specialite</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Grade</CTableHeaderCell>
                  <CTableHeaderCell scope="col" className="text-center">
                    Operation
                  </CTableHeaderCell>
                  <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {listVacataire.map((Vacataire, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell scope="row"> {index + 1} </CTableHeaderCell>
                    <CTableDataCell>{Vacataire.prenom}</CTableDataCell>
                    <CTableDataCell>{Vacataire.nom}</CTableDataCell>
                    <CTableDataCell className="text-center">{Vacataire.specialite}</CTableDataCell>
                    <CTableDataCell className="text-center">{Vacataire.grade}</CTableDataCell>
                    <CTableDataCell className="text-center">
                      {/* <CButton color="primary" className="me-1">
                        Modifier
                      </CButton> */}
                      <Link to={`/repartition/vacataire/ModifierVacataire/${Vacataire.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          <EditIcon className="icon4" />
                        </CButton>
                      </Link>
                      <CButton
                        style={{ color: 'white' }}
                        color="danger"
                        onClick={() => onDelClick(Vacataire.id)}
                      >
                        <DeleteIcon className="icon3" />
                      </CButton>
                    </CTableDataCell>
                    <CTableDataCell>
                      <CButton color="info">Detail</CButton>
                    </CTableDataCell>
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
