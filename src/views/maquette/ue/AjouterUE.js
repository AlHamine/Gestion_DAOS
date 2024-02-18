import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormTextarea } from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterUE() {
  const navigate = useNavigate()
  const [ue, setUE] = useState({
    libelle: '',
    description: '',
    module: [],
    createdAt: new Date().toISOString().split('.')[0] + 'Z',
    utilisateur: null,
    credit: '',
    coefficient: '',
    code: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setUE({
      ...ue,
      [name]: value,
    })
  }

  const addUe = (uesave) => {
    fetch(SERVER_URL + 'maquette/ue', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchUE()
          alert('UE ajouter avec successful')
          navigate('/maquette/ue/UE')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addUe(ue)
  }

  const backward = () => {
    navigate('/maquette/ue/UE')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du UE</strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Code"
            defaultValue=""
            name="code"
            onChange={handleChange}
            valid
            required
          />
        </CCol>
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
            type="number"
            id="validationServer02"
            label="Credit"
            defaultValue=""
            valid
            name="credit"
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="number"
            id="validationServer02"
            label="Coefficient"
            defaultValue=""
            valid
            name="coefficient"
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <div className="mb-3">
          <CFormTextarea
            feedbackInvalid="SVP entrer la description du UE."
            id="validationTextarea"
            label="Description"
            placeholder="L'objectif de l'UE."
            required
            name="description"
            onChange={handleChange}
          ></CFormTextarea>
        </div>
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
