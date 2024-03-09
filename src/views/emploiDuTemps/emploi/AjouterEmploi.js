import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import {
  CCard,
  CCardHeader,
  CCol,
  CButton,
  CForm,
  CFormInput,
  CCardBody,
  CFormSelect,
  CInputGroupText,
} from '@coreui/react'
import { useParams } from 'react-router-dom'

export default function AjouterEmploi() {
  const { id } = useParams()
  const navigate = useNavigate()

  const [batiments, setbatiments] = useState([])
  const [emploi, setEmploi] = useState({
    dateDebut: '',
    dateFin: '',
  })

  const backward = () => {
    navigate('/emploiDuTemps/emploi/Emploi')
  }

  const handleChange = (event) => {
    const { name, value } = event.target
    setEmploi({
      ...emploi,
      [name]: value,
    })
  }

  const addEmploi = (repartition) => {
    // const selectedBatiment = batiments.find((e) => e.id == emploi.batimentId)
    // emploi.batiment = selectedBatiment
    console.log('TEST FETCHING', repartition)
    fetch(SERVER_URL + 'emploi/emploi', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(repartition),
    })
      .then((response) => {
        if (response.ok) {
          alert('Nouveau Emploi ajouté avec succès')
          backward()
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addEmploi(emploi)
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
                Creation de Emploi
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={6} className="text-center">
          <CFormInput
            type="date"
            id="validationServer01"
            label="Date de Debut"
            name="dateDebut"
            onChange={handleChange}
            valid
            required
            // value={emploi.numero}
          />
        </CCol>
        <CCol md={6} className="text-center">
          <CFormInput
            type="date"
            id="validationServer02"
            label="Date de Fin"
            name="dateFin"
            onChange={handleChange}
            valid
            required
            // value={emploi.numero}
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
