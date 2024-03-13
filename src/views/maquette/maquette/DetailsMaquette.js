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
import EditIcon from '@mui/icons-material/Edit'
import DeleteIcon from '@mui/icons-material/Delete'
import style from './maquette.css'
import Typography from '@mui/material/Typography'
export default function DetailsMaquette() {
  const { id } = useParams()
  const [listModule, setListModule] = useState([])
  const [searchTerm, setSearchTerm] = useState('')
  const [itemsPerPage] = useState(10)
  const [currentPage, setCurrentPage] = useState(1)

  useEffect(() => {
    fetchModule()
  }, [])

  const handleSearchChange = (libelle) => {
    setSearchTerm(libelle.target.value)
  }
  const lastPageNumber = Math.ceil(listModule.length / itemsPerPage)

  const handleChangePaginate = (value) => {
    if (value === -100) {
      setCurrentPage(currentPage + 1)
    } else if (value === -200) {
      setCurrentPage(currentPage - 1)
    } else setCurrentPage(value)
  }

  const fetchModule = () => {
    fetch(SERVER_URL + `maquette/maquetteDetailsModule/${id}`)
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
            alert('An error occurred while deleting.')
          }
        })
        .catch((err) => console.error(err))
    }
  }

  const groupedModules = listModule.reduce((acc, module) => {
    const key = `${module.libelle_ue}_${module.credit_ue}_${module.coefficient_ue}`
    const existingGroup = acc.find((item) => item.key === key)
    if (existingGroup) {
      existingGroup.details.push(module)
    } else {
      acc.push({
        key,
        libelle_ue: module.libelle_ue,
        credit_ue: module.credit_ue,
        coefficient_ue: module.coefficient_ue,
        details: [module],
      })
    }
    return acc
  }, [])

  const currentModules = groupedModules
    .filter((group) => group.libelle_ue.toLowerCase().includes(searchTerm.toLowerCase()))
    .slice((currentPage - 1) * itemsPerPage, currentPage * itemsPerPage)

  return (
    <div>
      <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '2px' }}>
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
            <h1>
              MAQUETTE DE LA FORMATION: <strong>{listModule[1]?.formation}</strong> <br></br>
              Filiere : <strong>{listModule[1]?.filiere}</strong> - Filière :{' '}
              {/* <strong>{emploi?.filiere}</strong>
              <strong>{emploi?.nom}</strong> */}
            </h1>

            <div>
              <div>
                <strong style={{ display: 'block', textAlign: 'center' }}></strong>
              </div>
              <CFormInput
                type="text"
                size="sm"
                placeholder="Search Module by name"
                aria-label="sm input example"
                onChange={handleSearchChange}
              />
            </div>
          </CCardHeader>
        </CCard>
        <CCardBody>
          <CTable className="table">
            <CTableHead color="dark">
              <CTableRow className="table">
                <CTableHeaderCell colSpan="3">
                  UNITES D{"'"}ENSEIGNEMENT {listModule[1]?.semestre}
                </CTableHeaderCell>
                {/* <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell> */}
                <CTableHeaderCell colSpan="5" style={{ textAlign: 'center' }}>
                  ELEMENTS CONSTITUTIFS
                </CTableHeaderCell>
                {/* <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell>
                <CTableHeaderCell></CTableHeaderCell> */}
              </CTableRow>
              <CTableRow>
                <CTableHeaderCell>Intitulés</CTableHeaderCell>
                <CTableHeaderCell scope="col">Crédits</CTableHeaderCell>
                <CTableHeaderCell scope="col">Coeff_UE</CTableHeaderCell>

                <CTableRow>
                  <CTableHeaderCell style={{ minWidth: '350px', maxWidth: '400px' }}>
                    Intitulés
                  </CTableHeaderCell>
                  <CTableHeaderCell scope="col" style={{ width: '50px' }}>
                    CM
                  </CTableHeaderCell>
                  <CTableHeaderCell style={{ width: '50px' }} scope="col">
                    TD
                  </CTableHeaderCell>
                  <CTableHeaderCell style={{ width: '50px' }} scope="col">
                    TP
                  </CTableHeaderCell>
                  <CTableHeaderCell style={{ width: '50px' }} scope="col">
                    CM+TD/TP
                  </CTableHeaderCell>
                  <CTableHeaderCell style={{ width: '50px' }} scope="col">
                    TPE
                  </CTableHeaderCell>
                  <CTableHeaderCell style={{ width: '50px' }} scope="col">
                    VHT
                  </CTableHeaderCell>
                  <CTableHeaderCell style={{ width: '50px' }} scope="col">
                    Coeff
                  </CTableHeaderCell>
                  <CTableHeaderCell style={{ width: '111px' }} scope="col">
                    Operation
                  </CTableHeaderCell>
                </CTableRow>
              </CTableRow>
            </CTableHead>
            <CTableBody>
              {currentModules.map((group, groupIndex) => (
                <React.Fragment key={groupIndex}>
                  <CTableRow>
                    <CTableHeaderCell>{group.libelle_ue}</CTableHeaderCell>
                    <CTableDataCell>{group.credit_ue}</CTableDataCell>
                    <CTableDataCell className="text-center">{group.coefficient_ue}</CTableDataCell>
                    {/* <CTableDataCell colSpan="2"></CTableDataCell> */}
                    {group.details.map((module, moduleIndex) => (
                      <CTableRow key={moduleIndex}>
                        {/* <div> */}
                        {/* <CTableDataCell>{module.nom}</CTableDataCell> */}
                        <CTableDataCell style={{ minWidth: '350px' }}>
                          {module.libelleec} testLibe
                        </CTableDataCell>
                        <CTableDataCell className="text-center" style={{ width: '50px' }}>
                          {module.cmec}
                        </CTableDataCell>
                        <CTableDataCell className="text-center" style={{ width: '50px' }}>
                          {module.tdec}
                        </CTableDataCell>
                        <CTableDataCell className="text-center" style={{ width: '50px' }}>
                          {module.tpec}
                        </CTableDataCell>
                        <CTableDataCell className="text-center" style={{ width: '80px' }}>
                          {parseInt(module.tpec) + parseInt(module.cmec) + parseInt(module.tdec)}
                        </CTableDataCell>
                        <CTableDataCell className="text-center" style={{ width: '50px' }}>
                          {module.tpeec}
                        </CTableDataCell>
                        <CTableDataCell className="text-center" style={{ width: '50px' }}>
                          {module.nbreHeure}
                        </CTableDataCell>
                        <CTableDataCell className="text-center" style={{ width: '50px' }}>
                          {module.coefficient}
                        </CTableDataCell>
                        <CTableDataCell className="text-center">
                          <Link to={`/maquette/module/ModifierModule/${module.id}`}>
                            <CButton
                              color="primary"
                              style={{ fontWeight: 'bold', marginRight: '5px' }}
                            >
                              <EditIcon className="icon4" />
                            </CButton>
                          </Link>
                          <CButton
                            style={{ color: 'white' }}
                            color="danger"
                            onClick={() => onDelClickModule(module.id)}
                          >
                            <DeleteIcon className="icon3" />
                          </CButton>
                        </CTableDataCell>
                        {/* </div> */}
                      </CTableRow>
                    ))}
                  </CTableRow>
                </React.Fragment>
              ))}
            </CTableBody>
          </CTable>
          <CPagination align="end" aria-label="Page navigation example">
            {currentPage === 1 ? (
              <CPaginationItem disabled>Previous</CPaginationItem>
            ) : (
              <CPaginationItem onClick={() => handleChangePaginate(-200)}>Previous</CPaginationItem>
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
              <CPaginationItem disabled>End</CPaginationItem>
            ) : (
              <CPaginationItem onClick={() => handleChangePaginate(lastPageNumber)}>
                End
              </CPaginationItem>
            )}
            {currentPage === lastPageNumber ? (
              <CPaginationItem disabled>Next</CPaginationItem>
            ) : (
              <CPaginationItem onClick={() => handleChangePaginate(-100)}>Next</CPaginationItem>
            )}
          </CPagination>
        </CCardBody>
      </CCol>
    </div>
  )
}
