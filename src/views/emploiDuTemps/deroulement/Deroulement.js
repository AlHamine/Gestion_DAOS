import React, { useEffect, useState } from 'react'
import { CButton, CCard, CCardBody, CCardHeader, CCol, CPagination, CRow } from '@coreui/react'
import { SERVER_URL } from 'src/constantURL'
import { Link } from 'react-router-dom'
import { useParams } from 'react-router-dom'
import EditIcon from '@mui/icons-material/Edit'
import DeleteIcon from '@mui/icons-material/Delete'

export default function Deroulement() {
  const [deroulement, setDeroulement] = useState(null)
  const { id } = useParams()
  const { idseance } = useParams()

  useEffect(() => {
    fetchDeroulement()
  }, [])

  const fetchDeroulement = () => {
    fetch(SERVER_URL + 'emploi/seance/' + idseance + '/deroulement')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        setDeroulement(data) // Assuming only one deroulement is fetched
      })
      .catch((error) => console.error('Error fetching deroulement:', error))
  }

  const onDelClick = (id) => {
    if (window.confirm('Are you sure to delete?')) {
      fetch(SERVER_URL + `emploi/deroulement/${id}`, { method: 'DELETE' })
        .then((response) => {
          if (response.ok) {
            alert('deroulement supprimer')
            window.location.reload()
          } else {
            alert("Une erreur s'est produite lors de la suppression.")
          }
        })
        .catch((err) => console.error(err))
    }
  }

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>Liste </strong> <small>des deroulement</small>
          </CCardHeader>
          <CCardBody>
            {deroulement?.id != null ? (
              <div>
                <CCard>
                  <CCardBody>
                    <p>
                      {' '}
                      <strong>Description: </strong>{' '}
                      <span dangerouslySetInnerHTML={{ __html: deroulement.description }} />{' '}
                    </p>
                  </CCardBody>
                  <CCardBody>
                    <strong>Objectifs: </strong>{' '}
                    <span dangerouslySetInnerHTML={{ __html: deroulement.objectifs }} />{' '}
                  </CCardBody>
                  <CCardBody>
                    <Link
                      to={`/emploiDuTemps/deroulement/Modifierderoulement/${id}/${idseance}/${deroulement.id}`}
                    >
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
                  </CCardBody>
                  <CCardBody>
                    <Link to={`/emploiDuTemps/seance/Seance/Emploi/${id}`}>
                      <CButton color="info">Retourner a la seances</CButton>
                    </Link>
                  </CCardBody>
                </CCard>
              </div>
            ) : (
              <>
                <strong style={{ color: 'red', fontSize: '30px' }}>
                  Y a pas encore de Deroulement
                </strong>
                <Link
                  className="text-center"
                  to={`/emploiDuTemps/deroulement/AjouterDeroulement/${id}/${idseance}`}
                >
                  <br></br>
                  <CButton color="primary">Ajouter un Deroulement</CButton>
                </Link>
              </>
            )}
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}
