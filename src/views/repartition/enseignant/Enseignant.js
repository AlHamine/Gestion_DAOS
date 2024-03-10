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
export default function Enseignant() {
  const [listEnseignant, setListEnseignant] = useState([])

  const [searchTerm, setSearchTerm] = useState('')
  const [itemsPerPage] = useState(10) // Nombre d'éléments par page
  const [currentPage, setCurrentPage] = useState(1) // La page courante
  const handleSearchChange = (libelle) => {
    setSearchTerm(libelle.target.value)
  }
  const lastPageNumber = Math.ceil(listEnseignant.length / itemsPerPage)

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
  const currentPER = listEnseignant
    .filter(
      (ue) =>
        ue.specialite.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.prenom.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.grade.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.specialite.toLowerCase().includes(searchTerm.toLowerCase()) ||
        ue.nom.toLowerCase().includes(searchTerm.toLowerCase()),
    )
    .slice(indexOfFirstUE, indexOfLastUE)

  useEffect(() => {
    fetchEnseignant()
  }, [])

  const fetchEnseignant = () => {
    fetch(SERVER_URL + 'repartition/enseignant')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => setListEnseignant(data))
      .catch((error) => console.error('Error fetching Enseignant:', error))
  }

  const onDelClick = (id) => {
    // console.log(typeof id)
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `repartition/enseignant/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('Enseignant supprimer')
            fetchEnseignant()
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
          <Link to={'/repartition/enseignant/AjouterEnseignant'}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un Enseignant
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des Enseignant</small>
            <CFormInput
              type="text"
              size="sm"
              placeholder="Rechercher PER par Specialite |  Grade | Prenom  |Nom"
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
                  <CTableHeaderCell scope="col">Matricule</CTableHeaderCell>
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
                {currentPER.map((Enseignant, index) => (
                  <CTableRow key={index}>
                    {/* <CTableHeaderCell scope="row"> {index + 1} </CTableHeaderCell> */}
                    <CTableDataCell>{Enseignant?.matricule}</CTableDataCell>
                    <CTableDataCell>{Enseignant.prenom}</CTableDataCell>
                    <CTableDataCell>{Enseignant.nom}</CTableDataCell>
                    <CTableDataCell className="text-center">{Enseignant.specialite}</CTableDataCell>
                    <CTableDataCell className="text-center">{Enseignant.grade}</CTableDataCell>
                    <CTableDataCell className="text-center">
                      {/* <CButton color="primary" className="me-1">
                        Modifier
                      </CButton> */}
                      {Enseignant.matricule ? (
                        <>
                          <Link to={`/repartition/per/ModifierPER/${Enseignant.id}`}>
                            <CButton
                              color="primary"
                              style={{ fontWeight: 'bold', marginRight: '5px' }}
                            >
                              <EditIcon className="icon4" />
                            </CButton>
                          </Link>
                        </>
                      ) : (
                        <Link to={`/repartition/vacataire/ModifierVacataire/${Enseignant.id}`}>
                          <CButton
                            color="primary"
                            style={{ fontWeight: 'bold', marginRight: '5px' }}
                          >
                            <EditIcon className="icon4" />
                          </CButton>
                        </Link>
                      )}
                      <CButton
                        style={{ color: 'white' }}
                        color="danger"
                        onClick={() => onDelClick(Enseignant.id)}
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
