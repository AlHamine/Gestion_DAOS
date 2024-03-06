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

export default function Repartition() {
  const [listRepartition, setListRepartition] = useState([])

  useEffect(() => {
    fetchRepartition()
  }, [])

  const fetchRepartition = () => {
    fetch(SERVER_URL + 'repartition/repartition')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListRepartition(data))
      .catch((error) => console.error('Error fetching Repartition:', error))
  }

  const onDelClick = (id) => {
    // console.log(typeof id)
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `repartition/repartition/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('Repartition supprimer')
            fetchRepartition()
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
          <Link to={'/repartition/repartition/AjouterRepartition'}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un Repartition
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des Repartition</small>
          </CCardHeader>
          <CCardBody>
            {/* <DocsExample href="components/table#table-head"> */}
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  <CTableHeaderCell>#</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Enseignant</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Classe</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Groupe</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Module</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Type</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Operation</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {listRepartition.map((Repartition, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell style={{ width: '0px' }}> {index + 1} </CTableHeaderCell>
                    <CTableDataCell style={{ width: '4px' }}>
                      {Repartition.enseignant.prenom} {Repartition.enseignant.nom}{' '}
                      {Repartition.enseignant.grade} en {Repartition.enseignant.specialite}
                    </CTableDataCell>
                    <CTableDataCell>
                      {Repartition.enseignement.groupe.classe.libelle}{' '}
                    </CTableDataCell>
                    <CTableDataCell>{Repartition.enseignement.groupe.libelle} </CTableDataCell>
                    <CTableDataCell>{Repartition.enseignement.module.nom}</CTableDataCell>
                    <CTableDataCell>{Repartition.enseignement.libelle}</CTableDataCell>

                    {/* <CTableDataCell className="text-center">{Repartition.grade}</CTableDataCell> */}
                    <CTableDataCell className="text-center">
                      {/* <CButton color="primary" className="me-1">
                        Modifier
                      </CButton> */}
                      <Link to={`/repartition/repartition/ModifierRepartition/${Repartition.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          Modifier
                        </CButton>
                      </Link>
                      <CButton color="danger" onClick={() => onDelClick(Repartition.id)}>
                        Supprimer
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