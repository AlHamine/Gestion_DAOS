import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput } from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterFiliere() {
  const navigate = useNavigate()
  const [filiere, setFiliere] = useState({
    nom: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setFiliere({
      ...filiere,
      [name]: value,
    })
  }

  const addFiliere = (ecsave) => {
    fetch(SERVER_URL + 'maquette/filiere', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ecsave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Filiere ajouter avec successful')
          navigate('/maquette/filiere/Filiere')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addFiliere(filiere)
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
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du Filiere</strong>
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
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <div>
          <CCol xs={12} className="d-flex justify-content-center">
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={handleSave}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
