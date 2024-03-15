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
import { Link, useParams } from 'react-router-dom'

export default function SemestreDetails() {
  const { id } = useParams()
  const [listClasse, setListClasse] = useState([])
  const [listModule, setListModule] = useState([])
  const [searchTerm, setSearchTerm] = useState('')
  const [itemsPerPage] = useState(10) // Nombre d'éléments par page
  const [currentPage, setCurrentPage] = useState(1) // La page courante
  const [infobehind, setInfobehind] = useState({})

  const fetchInfobehind = () => {
    fetch(SERVER_URL + `maquette/semestre/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        setInfobehind(data)
      })
      .catch((error) => console.error('Error fetching Groupe:', error))
  }

  useEffect(() => {
    fetchInfobehind()
  }, [])

  useEffect(() => {
    fetchClasse()
    fetchModule()
  }, [])

  const handleSearchChange = (libelle) => {
    setSearchTerm(libelle.target.value)
  }
  const lastPageNumber = Math.ceil(listClasse.length / itemsPerPage)

  const handleChangePaginate = (value) => {
    if (value === -100) {
      setCurrentPage(currentPage + 1)
    } else if (value === -200) {
      setCurrentPage(currentPage - 1)
    } else setCurrentPage(value)
  }

  const fetchClasse = () => {
    fetch(SERVER_URL + `maquette/semestreDetailsClasse/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        // Trier les ateliers par date de création en ordre décroissant
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListClasse(data)
      })
      .catch((error) => console.error('Error fetching Classe:', error))
  }

  const fetchModule = () => {
    fetch(SERVER_URL + `maquette/semestreDetailsModule/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListModule(data)
      })
      .catch((error) => console.error('Error fetching Module:', error))
  }

  const onDelClickModule = (id) => {
    if (window.confirm('Are you sure to delete de Module?')) {
      fetch(SERVER_URL + `maquette/module/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            fetchModule()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
  }

  const onDelClickClasse = (id) => {
    if (window.confirm('Are you sure to delete de Classe?')) {
      fetch(SERVER_URL + `maquette/classe/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            fetchClasse()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
  }

  // Index de la dernière Classe à afficher sur la page
  const indexOfLastUE = currentPage * itemsPerPage
  // Index de la première Classe à afficher sur la page
  const indexOfFirstUE = indexOfLastUE - itemsPerPage
  // Liste des Classe à afficher sur la page actuelle
  const currentUEs = listClasse
    .filter((classe) => classe.libelle.toLowerCase().includes(searchTerm.toLowerCase()))
    .slice(indexOfFirstUE, indexOfLastUE)

  const currentModules = listModule
    .filter((module) => module.nom.toLowerCase().includes(searchTerm.toLowerCase()))
    .slice(indexOfFirstUE, indexOfLastUE)

  return (
    <div>
      <CRow>
        <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
          <div className="text-center">
            <Link to={'/maquette/classe/AjouterClasse'}>
              <CButton color="primary" style={{ fontWeight: 'bold' }}>
                Ajouter un Classe
              </CButton>
            </Link>
          </div>
        </div>
        <CCol xs={12}>
          <CCard className="mb-4">
            <CCardHeader>
              <div>
                <div>
                  <strong style={{ display: 'block', textAlign: 'center' }}>Liste de Classe</strong>
                  <h2>
                    Semestre : {infobehind?.libelle}, Description : {infobehind?.description}{' '}
                  </h2>
                </div>
                <CFormInput
                  type="text"
                  size="sm"
                  placeholder="Rechercher Classe par libelle"
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
                    <CTableHeaderCell scope="col">Effectif</CTableHeaderCell>
                    <CTableHeaderCell scope="col">NbreGroupe</CTableHeaderCell>
                    <CTableHeaderCell scope="col">Description</CTableHeaderCell>
                    <CTableHeaderCell scope="col" className="text-center">
                      Operation
                    </CTableHeaderCell>
                    <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                  </CTableRow>
                </CTableHead>
                <CTableBody>
                  {currentUEs.map((classe, index) => (
                    <CTableRow key={index}>
                      <CTableHeaderCell scope="row">{classe.id}</CTableHeaderCell>
                      <CTableDataCell>{classe.libelle}</CTableDataCell>
                      <CTableDataCell>{classe.effectif}</CTableDataCell>
                      <CTableDataCell>{classe.nbreGroupe}</CTableDataCell>
                      <CTableDataCell>
                        {classe.description.length > 10
                          ? `${classe.description.substring(0, 10)}...`
                          : classe.description}
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        <Link to={`/maquette/classe/ModifierClasse/${classe.id}`}>
                          <CButton
                            color="primary"
                            style={{ fontWeight: 'bold', marginRight: '5px' }}
                          >
                            Modifier
                          </CButton>
                        </Link>
                        <CButton color="danger" onClick={() => onDelClickClasse(classe.id)}>
                          Supprimer
                        </CButton>
                      </CTableDataCell>
                      <CTableDataCell>
                        <Link to={`/maquette/classe/${classe.id}/UEDetailsEC`}>
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
      <CRow>
        <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
          <div className="text-center">
            <Link to={'/maquette/module/AjouterModule'}>
              <CButton color="primary" style={{ fontWeight: 'bold' }}>
                Ajouter un Module
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
                    Liste des Module
                  </strong>
                </div>
                <CFormInput
                  type="text"
                  size="sm"
                  placeholder="Rechercher Module par nom"
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
                    <CTableHeaderCell scope="col">Nom</CTableHeaderCell>
                    <CTableHeaderCell scope="col">UE</CTableHeaderCell>
                    <CTableHeaderCell scope="col">EC</CTableHeaderCell>
                    <CTableHeaderCell scope="col">MAQUETTE</CTableHeaderCell>
                    <CTableHeaderCell scope="col">SEMESTRE</CTableHeaderCell>
                    <CTableHeaderCell scope="col" className="text-center">
                      Operation
                    </CTableHeaderCell>
                    <CTableHeaderCell scope="col">Details</CTableHeaderCell>
                  </CTableRow>
                </CTableHead>
                <CTableBody>
                  {currentModules.map((module, index) => (
                    <CTableRow key={index}>
                      <CTableHeaderCell scope="row"> {module.id} </CTableHeaderCell>
                      <CTableDataCell>
                        {module.nom.length > 15 ? `${module.nom.substring(0, 15)}...` : module.nom}
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        {module.ue && module.ue.libelle}
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        {module.ec && module.ec.libelle}
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        {module.maquette && module.maquette.intitule}
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        {module.semestre && module.semestre.libelle}
                      </CTableDataCell>
                      <CTableDataCell className="text-center">
                        <Link to={`/maquette/module/ModifierModule/${module.id}`}>
                          <CButton
                            color="primary"
                            style={{ fontWeight: 'bold', marginRight: '5px' }}
                          >
                            Modifier
                          </CButton>
                        </Link>
                        <CButton color="danger" onClick={() => onDelClickModule(module.id)}>
                          Supprimer
                        </CButton>
                      </CTableDataCell>
                      <CTableDataCell>
                        <Link to={`/maquette/module/ModuleDetails/${module.id}`}>
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
    </div>
  )
}
