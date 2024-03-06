import {
  CCard,
  CCardHeader,
  CCol,
  CButton,
  CForm,
  CFormInput,
  CFormTextarea,
  CInputGroup,
  CInputGroupText,
} from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterBatiment() {
  const navigate = useNavigate()
  const [batiment, setBatiment] = useState({
    nom: '',
    // createdAt: new Date().toISOString().split('.')[0] + 'Z',
    // utilisateur: null,
    // credit: '',
    // coefficient: '',
    // code: '',
  })
  const backward = () => {
    navigate('/emploiDuTemps/batiment/Batiment')
  }

  const handleChange = (event) => {
    const { name, value } = event.target
    setBatiment({
      ...batiment,
      [name]: value,
    })
  }

  const addBatiment = (uesave) => {
    fetch(SERVER_URL + 'emploi/batiment', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchBatiment()
          alert('batiment ajouter avec successful')
          backward()
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addBatiment(batiment)
  }

  return (
    <div style={{ transform: 'scale(1.2)' }}>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong
                className="btn alert-success"
                style={{ display: 'block', textAlign: 'center' }}
              >
                Creation de Batiment
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol xs={12} className="text-center">
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
          <CCol xs={12} className="text-center">
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
