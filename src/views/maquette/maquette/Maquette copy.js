// import React, { useEffect, useState } from 'react'
// import {
//   CCard,
//   CCardBody,
//   CCardHeader,
//   CCol,
//   CRow,
//   CTable,
//   CTableBody,
//   CTableDataCell,
//   CTableHead,
//   CTableHeaderCell,
//   CTableRow,
//   CButton,
//   CPagination,
//   CPaginationItem,
//   CFormInput,
// } from '@coreui/react'
// import { SERVER_URL } from 'src/constantURL'
// import { Link } from 'react-router-dom'

// export default function Maquette() {
//   const [maquetteList, setListMaquette] = useState([])
//   const [searchTerm, setSearchTerm] = useState('')
//   const [itemsPerPage] = useState(10) // Nombre d'éléments par page
//   const [currentPage, setCurrentPage] = useState(1) // La page courante

//   useEffect(() => {
//     fetchMaquette()
//   }, [])

//   const handleSearchChange = (intitule) => {
//     setSearchTerm(intitule.target.value)
//   }
//   const lastPageNumber = Math.ceil(maquetteList.length / itemsPerPage)

//   const handleChangePaginate = (value) => {
//     if (value === -100) {
//       setCurrentPage(currentPage + 1)
//     } else if (value === -200) {
//       setCurrentPage(currentPage - 1)
//     } else setCurrentPage(value)
//   }

//   const fetchMaquette = () => {
//     fetch(SERVER_URL + `maquette/maquette`)
//       .then((response) => {
//         if (!response.ok) {
//           throw new Error('Network response was not ok')
//         }
//         return response.json()
//       })
//       .then((data) => {
//         data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
//         setListMaquette(data)
//       })
//       .catch((error) => console.error('Error fetching Maquette:', error))
//   }

//   const onDelClick = (id) => {
//     if (window.confirm('Are you sure to delete the Maquette?')) {
//       fetch(SERVER_URL + `maquette/maquette/${id}`, { method: 'DELETE' })
//         .then((response) => {
//           if (response.ok) {
//             fetchMaquette()
//           } else {
//             alert("Une erreur s'est produite lors de la suppression.")
//           }
//         })
//         .catch((err) => console.error(err))
//     }
//   }

//   // Index de la dernière Maquette à afficher sur la page
//   const indexOfLastUE = currentPage * itemsPerPage
//   // Index de la première Maquette à afficher sur la page
//   const indexOfFirstUE = indexOfLastUE - itemsPerPage
//   // Liste des Maquette à afficher sur la page actuelle
//   const currentMaquettes = maquetteList
//     .filter((maquette) => maquette.intitule.toLowerCase().includes(searchTerm.toLowerCase()))
//     .slice(indexOfFirstUE, indexOfLastUE)

//   return (
//     <CRow>
//       <div className="d-grid gap-2 col-6 mx-auto" style={{ marginBottom: '10px' }}>
//         <div className="text-center">
//           <Link to={'/maquette/maquette/AjouterMaquette'}>
//             <CButton color="primary" style={{ fontWeight: 'bold' }}>
//               Ajouter un Maquette
//             </CButton>
//           </Link>
//         </div>
//       </div>
//       <CCol xs={12}>
//         <CCard className="mb-4">
//           <CCardHeader>
//             <div>
//               <div>
//                 <strong style={{ display: 'block', textAlign: 'center' }}>
//                   Liste des Maquette
//                 </strong>
//               </div>
//               <CFormInput
//                 type="text"
//                 size="sm"
//                 placeholder="Rechercher Maquette par Intitule"
//                 aria-label="sm input example"
//                 onChange={handleSearchChange}
//               />
//             </div>
//           </CCardHeader>
//           <CCardBody>
//             <CTable>
//               <CTableHead color="dark">
//                 <CTableRow>
//                   <CTableHeaderCell scope="col">#</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">Credit</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">CoefUE</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">Intitule</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">CM</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">TD</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">TP</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">CUMULE</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">TPE</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">VH</CTableHeaderCell>
//                   <CTableHeaderCell scope="col">COEF</CTableHeaderCell>
//                   <CTableHeaderCell scope="col" className="text-center">
//                     Operation
//                   </CTableHeaderCell>
//                   <CTableHeaderCell scope="col">Details</CTableHeaderCell>
//                 </CTableRow>
//               </CTableHead>
//               <CTableBody>
//                 {currentMaquettes.map((maquette, index) => (
//                   <CTableRow key={index}>
//                     <CTableHeaderCell scope="row"> {maquette.id} </CTableHeaderCell>
//                     <CTableDataCell className="text-center">{maquette.credit}</CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.coefUe}</CTableDataCell>
//                     <CTableDataCell>
//                       {maquette.intitule.length > 15
//                         ? `${maquette.intitule.substring(0, 15)}...`
//                         : maquette.intitule}
//                     </CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.cm}</CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.td}</CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.tp}</CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.cumule}</CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.tpe}</CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.vh}</CTableDataCell>
//                     <CTableDataCell className="text-center">{maquette.coef}</CTableDataCell>

//                     <CTableDataCell className="text-center">
//                       <Link to={`/maquette/maquette/ModifierMaquette/${maquette.id}`}>
//                         <CButton color="primary" style={{ fontWeight: 'bold', marginRight: '5px' }}>
//                           Modifier
//                         </CButton>
//                       </Link>
//                       <CButton color="danger" onClick={() => onDelClick(maquette.id)}>
//                         Supprimer
//                       </CButton>
//                     </CTableDataCell>
//                     <CTableDataCell>
//                       <Link to={`/maquette/maquette/${maquette.id}/UEDetailsEC`}>
//                         <CButton
//                           color="info"
//                           style={{ fontWeight: 'bold', marginRight: '5px', marginLeft: '0px' }}
//                         >
//                           Detail
//                         </CButton>
//                       </Link>
//                     </CTableDataCell>
//                   </CTableRow>
//                 ))}
//                 <CPagination align="end" aria-label="Page navigation example">
//                   {currentPage === 1 ? (
//                     <CPaginationItem disabled>Previous</CPaginationItem>
//                   ) : (
//                     <CPaginationItem onClick={() => handleChangePaginate(-200)}>
//                       Previous
//                     </CPaginationItem>
//                   )}
//                   {currentPage === 1 ? (
//                     <CPaginationItem disabled>1</CPaginationItem>
//                   ) : (
//                     <CPaginationItem onClick={() => handleChangePaginate(1)}>1</CPaginationItem>
//                   )}
//                   {currentPage === lastPageNumber ? (
//                     <CPaginationItem disabled>2</CPaginationItem>
//                   ) : (
//                     <CPaginationItem onClick={() => handleChangePaginate(2)}>2</CPaginationItem>
//                   )}
//                   {currentPage === lastPageNumber ? (
//                     <CPaginationItem disabled>3</CPaginationItem>
//                   ) : (
//                     <CPaginationItem onClick={() => handleChangePaginate(3)}>3</CPaginationItem>
//                   )}
//                   {currentPage === lastPageNumber ? (
//                     <CPaginationItem disabled>Fin</CPaginationItem>
//                   ) : (
//                     <CPaginationItem onClick={() => handleChangePaginate(lastPageNumber)}>
//                       Fin
//                     </CPaginationItem>
//                   )}
//                   {currentPage === lastPageNumber ? (
//                     <CPaginationItem disabled>Next</CPaginationItem>
//                   ) : (
//                     <CPaginationItem onClick={() => handleChangePaginate(-100)}>
//                       Next
//                     </CPaginationItem>
//                   )}
//                 </CPagination>
//               </CTableBody>
//             </CTable>
//           </CCardBody>
//         </CCard>
//       </CCol>
//     </CRow>
//   )
// }
