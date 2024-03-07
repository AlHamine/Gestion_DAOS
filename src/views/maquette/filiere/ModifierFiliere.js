import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierFiliere() {
  const { id } = useParams()
  const [filiere, setFiliere] = useState({})
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setFiliere({
      ...filiere,
      [name]: value,
    })
  }

  useEffect(() => {
    const getFiliere = () => {
      fetch(SERVER_URL + `maquette/filiere/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setFiliere(data)
        })
        .catch((error) => console.error('Error fetching Filiere:', error))
    }

    getFiliere()
  }, [id])

  const updateFiliere = (filiereModifier, filiereId) => {
    fetch(SERVER_URL + `maquette/filiere/${filiereId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(filiereModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/filiere/Filiere')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  const backward = () => {
    navigate('/maquette/filiere/Filiere')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification de Filiere
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={12}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Nom"
            defaultValue=""
            name="nom"
            value={filiere.nom}
            onChange={handleChange}
            valid
          />
        </CCol>
        <div>
          <CCol xs={12} className="d-flex justify-content-center">
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={() => updateFiliere(filiere, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
