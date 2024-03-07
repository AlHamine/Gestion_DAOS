import React, { useEffect, useState } from 'react'
import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CTable,
  CTableBody,
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

export default function Semestre() {
  const [listSemestre, setListMaquette] = useState([])
  const [searchTerm, setSearchTerm] = useState('')
  const [itemsPerPage] = useState(10) // Nombre d'éléments par page
  const [currentPage, setCurrentPage] = useState(1) // La page courante

  useEffect(() => {
    fetchMaquette()
  }, [])

  const handleSearchChange = (libelle) => {
    setSearchTerm(libelle.target.value)
  }
  const lastPageNumber = Math.ceil(listSemestre.length / itemsPerPage)

  const handleChangePaginate = (value) => {
    if (value === -100) {
      setCurrentPage(currentPage + 1)
    } else if (value === -200) {
      setCurrentPage(currentPage - 1)
    } else setCurrentPage(value)
  }

  const fetchMaquette = () => {
    fetch(SERVER_URL + `maquette/semestre`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListMaquette(data)
      })
      .catch((error) => console.error('Error fetching Semestre:', error))
  }

  const onDelClick = (id) => {
    if (window.confirm('Are you sure to delete de Semestre?')) {
      fetch(SERVER_URL + `maquette/semestre/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            fetchMaquette()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
  }

  // Index de la dernière Maquette à afficher sur la page
  const indexOfLastUE = currentPage * itemsPerPage
  // Index de la première Maquette à afficher sur la page
  const indexOfFirstUE = indexOfLastUE - itemsPerPage
  // Liste des Maquette à afficher sur la page actuelle
  const currentSemestres = listSemestre
    .filter((maquette) => maquette.libelle.toLowerCase().includes(searchTerm.toLowerCase()))
    .slice(indexOfFirstUE, indexOfLastUE)

  return (
    <CRow>
      <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
        <div className="text-center">
          <Link to={'/maquette/semestre/AjouterSemestre'}>
            <CButton color="primary" style={{ fontWeight: 'bold' }}>
              Ajouter un Semestre
            </CButton>
          </Link>
        </div>
      </div>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <div>
                <strong style={{ display: 'block', textAlign: 'center' }}>
                  Liste des Semestre
                </strong>
              </div>
              <CFormInput
                type="text"
                size="sm"
                placeholder="Rechercher Semestre par libelle"
                aria-label="sm input example"
                onChange={handleSearchChange}
              />
            </div>
          </CCardHeader>
          <CCardBody>
            <CTable>
              <CTableHead color="dark">
                <CTableRow>
                  <CTableHeaderCell scope="col">#</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Libelle</CTableHeaderCell>
                  <CTableHeaderCell scope="col">Description</CTableHeaderCell>
                  <CTableHeaderCell scope="col" className="text-center">
                    Operation
                  </CTableHeaderCell>
                  <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                </CTableRow>
              </CTableHead>
              <CTableBody>
                {currentSemestres.map((maquette, index) => (
                  <CTableRow key={index}>
                    <CTableHeaderCell scope="row"> {maquette.id} </CTableHeaderCell>
                    <CTableDataCell>
                      {maquette.libelle.length > 15
                        ? `${maquette.libelle.substring(0, 15)}...`
                        : maquette.libelle}
                    </CTableDataCell>
                    <CTableDataCell className="text-center">{maquette.description}</CTableDataCell>
                    <CTableDataCell className="text-center">
                      <Link to={`/maquette/semestre/ModifierSemestre/${maquette.id}`}>
                        <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
                          Modifier
                        </CButton>
                      </Link>
                      <CButton color="danger" onClick={() => onDelClick(maquette.id)}>
                        Supprimer
                      </CButton>
                    </CTableDataCell>
                    <CTableDataCell>
                      <Link to={`/maquette/semestre/${maquette.id}/UEDetailsEC`}>
                        <CButton
                          color="info"
                          style={{ fontWeight: 'bold', marginRight: '5px', marginLeft: '0px' }}
                        >
                          Detail
                        </CButton>
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
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}
