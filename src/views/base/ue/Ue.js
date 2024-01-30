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
} from '@coreui/react'
import { SERVER_URL } from 'src/constantURL'
// import { DocsExample } from 'src/components'

const Ue = () => {
  const [listUE, setListUE] = useState([])

  useEffect(() => {
    fetchUE()
  }, [])

  // const fetchUE = () => {
  //   fetch(SERVER_URL + 'maquette/ue')
  //     .then((response) => response.json())
  //     .then((data) => setListUE(data))
  //     .then((err) => console.error(err))
  // }
  const fetchUE = () => {
    fetch(SERVER_URL + 'maquette/ue')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListUE(data))
      .catch((error) => console.error('Error fetching UE:', error))
  }

  console.log(listUE)

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des UE</small>
          </CCardHeader>
          <CCardBody>
            {/* <DocsExample href="components/table#table-head"> */}
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  <CTableHeaderCell scope="col">#</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Code</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Libelle</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Credits</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Coefficient</CTableHeaderCell>
                  <CTableHeaderCell scope="col" className="text-center">
                    Operation
                  </CTableHeaderCell>
                  <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {listUE.map((ue, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell scope="row"> {index + 1} </CTableHeaderCell>
                    <CTableDataCell>{ue.code}</CTableDataCell>
                    <CTableDataCell>{ue.libelle}</CTableDataCell>
                    <CTableDataCell className="text-center">{ue.credit}</CTableDataCell>
                    <CTableDataCell className="text-center">{ue.coefficient}</CTableDataCell>
                    <CTableDataCell className="text-center">
                      <CButton color="primary" className="me-1">
                        Modifier
                      </CButton>
                      <CButton color="danger">Supprimer</CButton>
                    </CTableDataCell>
                    <CTableDataCell>
                      <CButton color="info">Detail</CButton>
                    </CTableDataCell>
                  </CTableRow>
                ))}
              </CTableBody>
            </CTable>
            {/* </DocsExample> */}
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Ue
