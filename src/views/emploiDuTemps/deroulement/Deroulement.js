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
export default function Deroulement() {
  const [listderoulement, setListderoulement] = useState([])

  useEffect(() => {
    fetchderoulement()
  }, [])

  const fetchderoulement = () => {
    fetch(SERVER_URL + 'emploi/deroulement')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListderoulement(data))
      .catch((error) => console.error('Error fetching deroulement:', error))
  }

  const onDelClick = (id) => {
    // console.log(typeof id)
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `emploi/deroulement/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('deroulement supprimer')
            fetchderoulement()
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
          <Link to={'/emploiDuTemps/deroulement/Ajouterderoulement'}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un deroulement
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des deroulement</small>
          </CCardHeader>
          <CCardBody>
            {/* <DocsExample href="components/table#table-head"> */}
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  <CTableHeaderCell>#</CTableHeaderCell>
                  {/* <CTableHeaderCell scope="col">Enseignant</CTableHeaderCell> */}
                  <CTableHeaderCell scope="col">Description</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Objectifs</CTableHeaderCell>
                  {/* <CTableHeaderCell scope="col">Groupe</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Module</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Type</CTableHeaderCell> */}
                  <CTableHeaderCell scope="col"></CTableHeaderCell>
                  <CTableHeaderCell scope="col">Operation</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {listderoulement.map((deroulement, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell style={{ width: '0px' }}> {index + 1} </CTableHeaderCell>
                    <CTableDataCell style={{ width: '200px' }}>
                      {deroulement.description}
                    </CTableDataCell>
                    <CTableDataCell>
                      <ul>
                        {deroulement.objectifs.map((e, index) => (
                          <li key={index}>{e}</li>
                        ))}
                      </ul>
                    </CTableDataCell>

                    <CTableDataCell></CTableDataCell>

                    {/* <CTableDataCell className="text-center">{deroulement.grade}</CTableDataCell> */}
                    <CTableDataCell>
                      {/* <CButton color="primary" className="me-1">
                        <EditIcon className="icon4" />
                      </CButton> */}
                      <Link to={`/emploiDuTemps/deroulement/Modifierderoulement/${deroulement.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          <EditIcon className="icon4" />
                        </CButton>
                      </Link>
                      <CButton
                        style={{ color: 'white' }}
                        color="danger"
                        onClick={() => onDelClick(deroulement.id)}
                      >
                        <DeleteIcon className="icon3" />
                      </CButton>
                    </CTableDataCell>
                    <CTableDataCell>
                      <CButton color="info">Voir les seances</CButton>
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
