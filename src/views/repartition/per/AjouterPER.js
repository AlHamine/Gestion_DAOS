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

export default function AjouterPER() {
  const navigate = useNavigate()

  const [per, setPER] = useState({
    prenom: '',
    nom: '',
    grade: '',
    matricule: '',
    specialite: '',
    type: 'PER',
    // createdAt: new Date().toISOString().split('.')[0] + 'Z',
    // utilisateur: null,
    // credit: '',
    // coefficient: '',
    // code: '',
  })
  const backward = () => {
    navigate('/repartition/per/PER')
  }

  const handleChange = (event) => {
    const { name, value } = event.target
    setPER({
      ...per,
      [name]: value,
    })
  }

  const addPER = (uesave) => {
    fetch(SERVER_URL + 'repartition/per', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchPER()
          alert('per ajouter avec successful')
          navigate('/repartition/per/PER')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addPER(per)
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
                Creation de PER
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Prenom"
            defaultValue=""
            name="prenom"
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <CCol md={6}>
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
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Grade"
            defaultValue=""
            name="grade"
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Matricule"
            defaultValue=""
            name="matricule"
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Specialite"
            defaultValue=""
            name="specialite"
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
