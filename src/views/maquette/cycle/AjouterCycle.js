import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput } from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterFiliere() {
  const navigate = useNavigate()
  const [cycle, setCycle] = useState({
    nom: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setCycle({
      ...cycle,
      [name]: value,
    })
  }

  const addCycle = (cycleSave) => {
    fetch(SERVER_URL + 'maquette/cycle', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(cycleSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Cycle ajouter avec successful')
          navigate('/maquette/cycle/Cycle')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addCycle(cycle)
  }

  const backward = () => {
    navigate('/maquette/cycle/Cycle')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du Cycle</strong>
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
