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
  CFormInput,
} from '@coreui/react'
import { SERVER_URL } from 'src/constantURL'
import { Link } from 'react-router-dom'
// import { cilZoom } from '@coreui/icons'

export default function UE() {
  const [listUE, setListUE] = useState([])
  const [searchTerm, setSearchTerm] = useState('')
  const [itemsPerPage] = useState(5) // Nombre d'éléments par page
  const [currentPage, setCurrentPage] = useState(1) // La page courante

  useEffect(() => {
    fetchUE()
  }, [])

  const handleSearchChange = (libelle) => {
    setSearchTerm(libelle.target.value)
  }
  const lastPageNumber = Math.ceil(listUE.length / itemsPerPage)

  const handleChangePaginate = (value) => {
    if (value === -100) {
      setCurrentPage(currentPage + 1)
    } else if (value === -200) {
      setCurrentPage(currentPage - 1)
    } else setCurrentPage(value)
  }

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

  const onDelClick = (id) => {
    if (window.confirm('Are you sure to delete de UE?')) {
      fetch(SERVER_URL + `maquette/ue/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            fetchUE()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
  }

  // Index de la dernière UE à afficher sur la page
  const indexOfLastUE = currentPage * itemsPerPage
  // Index de la première UE à afficher sur la page
  const indexOfFirstUE = indexOfLastUE - itemsPerPage
  // Liste des UE à afficher sur la page actuelle
  const currentUEs = listUE
    .filter((ue) => ue.libelle.toLowerCase().includes(searchTerm.toLowerCase()))
    .slice(indexOfFirstUE, indexOfLastUE)

  return (
    <CRow>
      <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
        <div className="text-center">
          <Link to={'/maquette/ue/AjouterUE'}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un UE
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <div>
                <strong style={{ display: 'block', textAlign: 'center' }}>Liste des UE</strong>
              </div>

              <CFormInput
                type="text"
                size="sm"
                placeholder="Rechercher UE par libelle"
                aria-label="sm input example"
                // icon={cilZoom}
                onChange={handleSearchChange}
              />
            </div>
          </CCardHeader>
          <CCardBody>
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
                {currentUEs.map((ue, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell scope="row"> {ue.id} </CTableHeaderCell>
                    <CTableDataCell>{ue.code}</CTableDataCell>
                    <CTableDataCell>
                      {ue.libelle.length > 15 ? `${ue.libelle.substring(0, 15)}...` : ue.libelle}
                    </CTableDataCell>
                    <CTableDataCell className="text-center">{ue.credit}</CTableDataCell>
                    <CTableDataCell className="text-center">{ue.coefficient}</CTableDataCell>
                    <CTableDataCell className="text-center">
                      <Link to={`/maquette/ue/ModifierUE/${ue.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          Modifier
                        </CButton>
                      </Link>
                      <CButton color="danger" onClick={() => onDelClick(ue.id)}>
                        Supprimer
                      </CButton>
                    </CTableDataCell>
                    <CTableDataCell>
                      <CButton color="info">Detail</CButton>
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
                  <CPaginationItem onClick={() => handleChangePaginate(1)}>1</CPaginationItem>
                  <CPaginationItem onClick={() => handleChangePaginate(2)}>2</CPaginationItem>
                  <CPaginationItem onClick={() => handleChangePaginate(3)}>3</CPaginationItem>
                  <CPaginationItem onClick={() => handleChangePaginate(lastPageNumber)}>
                    Fin
                  </CPaginationItem>
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
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}
