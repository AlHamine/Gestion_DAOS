import { CButton, CCard, CCardHeader, CCol, CForm, CFormSelect, CFormTextarea } from '@coreui/react'
import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterMaquette() {
  const navigate = useNavigate()
  const [listFormation, setListFormation] = useState([])
  const [maquette, setMaquette] = useState({
    formation: null,
    module: null,
  })

  useEffect(() => {
    const fetchFormation = () => {
      fetch(SERVER_URL + 'maquette/formation')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListFormation(data)
        })
        .catch((error) => console.error('Error fetching Formation:', error))
    }

    fetchFormation()
    // fetchSemestre()
  }, [])

  const handleChange = (event) => {
    const { name, value } = event.target
    setMaquette({
      ...maquette,
      [name]: value,
    })
  }
  const handleChangeFormation = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedFormation = listFormation[selectedModuleIndex]
    setMaquette({
      ...maquette,
      formation: selectedFormation,
    })
  }

  const addMaquette = (maquetteSave) => {
    fetch(SERVER_URL + 'maquette/maquette', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(maquetteSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Maquette ajouter avec successful')
          navigate('/maquette/maquette/Maquette')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addMaquette(maquette)
  }

  const backward = () => {
    navigate('/maquette/maquette/Maquette')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Creation du Maquette
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <div className="mb-3">
          <CFormSelect
            label="Selection la formation de classe"
            feedbackInvalid="Selection une formation valide"
            aria-label="select example"
            required
            name="formation"
            onChange={handleChangeFormation}
          >
            <option selected="" value="">
              Selection son formation
            </option>
            {listFormation.map((formation, index) => (
              <option key={index} value={index}>
                {'Nom : '} {formation && formation.nom}
              </option>
            ))}
          </CFormSelect>
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
