import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierSemestre() {
  const { id } = useParams()
  const [semestre, setSemestre] = useState({})
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setSemestre({
      ...semestre,
      [name]: value,
    })
  }

  useEffect(() => {
    const getEC = () => {
      fetch(SERVER_URL + `maquette/semestre/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setSemestre(data)
        })
        .catch((error) => console.error('Error fetching Semestre:', error))
    }

    getEC()
  }, [id])

  const updateSemestre = (semestreModifier, semestreId) => {
    fetch(SERVER_URL + `maquette/semestre/${semestreId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(semestreModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/semestre/Semestre')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
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
                Modification de Semestre
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
            value={semestre.libelle}
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
            value={semestre.description}
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
            <CButton color="primary" onClick={() => updateSemestre(semestre, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
