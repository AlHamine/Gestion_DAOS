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
// import { DocsExample } from 'src/components'

import EditIcon from '@mui/icons-material/Edit'
import DeleteIcon from '@mui/icons-material/Delete'
export default function Emploi() {
  const [listEmploi, setListEmploi] = useState([])

  const [searchTerm, setSearchTerm] = useState('')
  const [itemsPerPage] = useState(10) // Nombre d'éléments par page
  const [currentPage, setCurrentPage] = useState(1) // La page courante
  const handleSearchChange = (libelle) => {
    setSearchTerm(libelle.target.value)
  }
  const lastPageNumber = Math.ceil(listEmploi.length / itemsPerPage)

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
  const currentPER = listEmploi
    .filter(
      (ue) =>
        ue.filiere?.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.classe?.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.dateDebut?.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.dateFin?.toLowerCase().includes(searchTerm.toLowerCase()),
    )
    .slice(indexOfFirstUE, indexOfLastUE)
  useEffect(() => {
    fetchEmploi()
  }, [])

  const fetchEmploi = () => {
    fetch(SERVER_URL + 'emploi/emploi')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListEmploi(data))
      .catch((error) => console.error('Error fetching Emploi:', error))
  }

  const onDelClick = (id) => {
    // console.log(typeof id)
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `emploi/emploi/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('Emploi supprimer')
            fetchEmploi()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
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
  return (
    <CRow>
      <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
        <div className="text-center">
          <Link to={'/emploiDuTemps/emploi/AjouterEmploi'}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un Emploi
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des Emploi</small>
            <CFormInput
              type="text"
              size="sm"
              placeholder="Rechercher Emploi par Filiere | Classe  | Date-Debut | Date-Fin"
              aria-label="sm input example"
              onChange={handleSearchChange}
            />
          </CCardHeader>
          <CCardBody>
            {/* <DocsExample href="components/table#table-head"> */}
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  <CTableHeaderCell scope="col">#</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Filiere</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Classe</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Date-Debut</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Date-Fin</CTableHeaderCell>
                  <CTableHeaderCell scope="col" className="text-center">
                    Operation
                  </CTableHeaderCell>
                  <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {currentPER.map((Emploi, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell scope="row"> {index + 1} </CTableHeaderCell>
                    <CTableDataCell>{Emploi?.filiere}</CTableDataCell>
                    <CTableDataCell>{Emploi?.classe}</CTableDataCell>
                    <CTableDataCell>{extractDateOnly(Emploi.dateDebut)}</CTableDataCell>
                    <CTableDataCell>{extractDateOnly(Emploi.dateFin)}</CTableDataCell>
                    <CTableDataCell className="text-center">
                      {/* <CButton color="primary" className="me-1">
                        <EditIcon className="icon4" />
                      </CButton> */}
                      <Link to={`/emploiDuTemps/emploi/ModifierEmploi/${Emploi.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          <EditIcon className="icon4" />
                        </CButton>
                      </Link>
                      <CButton
                        style={{ color: 'white' }}
                        color="danger"
                        onClick={() => onDelClick(Emploi.id)}
                      >
                        <DeleteIcon className="icon3" />
                      </CButton>
                    </CTableDataCell>
                    <CTableDataCell>
                      <Link to={`/emploiDuTemps/seance/Seance/Emploi/${Emploi.id}`}>
                        <CButton color="info">Gerer Seances</CButton>
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
