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
import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useParams } from 'react-router-dom'

export default function ModifierBatiment() {
  const navigate = useNavigate()
  const { id } = useParams()
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
  const getBatiment = () => {
    fetch(SERVER_URL + `emploi/batiment/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }

        return response.json()
      })
      .then((data) => {
        setBatiment(data)
      })
      .catch((error) => console.error('Error fetching UE:', error))
  }

  useEffect(() => {
    getBatiment()
    console.log(batiment)
  }, [])

  const addBatiment = (uesave) => {
    fetch(SERVER_URL + 'emploi/batiment', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchBatiment()
          alert('batiment modifie avec successful')
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
                Modification de Batiment
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol xs={12} className="text-center">
          <CFormInput
            type="text"
            id="validationServer01"
            label="Nom"
            value={batiment.nom}
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
