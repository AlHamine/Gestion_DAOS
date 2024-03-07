import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput } from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterSemestre() {
  const navigate = useNavigate()
  const [semestre, setSemestre] = useState({
    libelle: '',
    description: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setSemestre({
      ...semestre,
      [name]: value,
    })
  }

  const addSemestre = (semestreSave) => {
    fetch(SERVER_URL + 'maquette/semestre', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(semestreSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Semestre ajouter avec successful')
          navigate('/maquette/semestre/Semestre')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addSemestre(semestre)
  }

  const backward = () => {
    navigate('/maquette/semestre/Semestre')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Creation du Semestre
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Libelle"
            defaultValue=""
            name="libelle"
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Description"
            defaultValue=""
            name="description"
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
