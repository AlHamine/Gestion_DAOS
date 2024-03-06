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

export default function ModifierSalle() {
  const { id } = useParams()
  const navigate = useNavigate()

  const [batiments, setbatiments] = useState([])
  const [salle, setSalle] = useState({
    numero: '',
    capacite: '',
    batiment: {},
  })

  const backward = () => {
    navigate('/emploiDuTemps/salle/Salle')
  }
  useEffect(() => {
    const chargerSalle = () => {
      fetch(SERVER_URL + `emploi/salle/${id}`, {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setSalle(data))
        .catch((err) => console.error(err))
    }

    const chargerbatiments = () => {
      fetch(SERVER_URL + 'emploi/batiment', {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setbatiments(data))
        .catch((err) => console.error(err))
    }
    chargerSalle()
    chargerbatiments()
  }, [])

  // const handleChangeSalle = (e) => {
  //   const selectedId = e.target.value
  //   const selectedSalle = batiments.find((e) => e.id == id)
  //   console.log(selectedSalle)
  //   // selectedSalle.type = selectedSalle.matricule ? 'PER' : 'VAC'
  //   setSalle((prevState) => ({
  //     ...prevState,
  //     batiment: selectedSalle,
  //   }))
  //   console.log(salle)
  // }
  const handleChange = (event) => {
    const { name, value } = event.target
    setSalle({
      ...salle,
      [name]: value,
    })
  }

  const addSalle = (repartition) => {
    const selectedSalle = batiments.find((e) => e.id == salle.batimentId)
    salle.batiment = selectedSalle
    console.log('TEST FETCHING', repartition)
    fetch(SERVER_URL + 'emploi/salle', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(repartition),
    })
      .then((response) => {
        if (response.ok) {
          alert('Salle modifiée avec succès')
          backward()
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addSalle(salle)
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
                Creation de Salle
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={6} className="text-center">
          <CFormInput
            type="text"
            id="validationServer01"
            label="Numero"
            defaultValue=""
            name="numero"
            onChange={handleChange}
            valid
            required
            value={salle.numero}
          />
        </CCol>
        <CCol md={6} className="text-center">
          <CFormInput
            type="text"
            id="validationServer01"
            label="Capacite"
            defaultValue=""
            name="capacite"
            onChange={handleChange}
            valid
            required
            value={salle.capacite}
          />
        </CCol>
        <CCardBody>
          <CFormSelect
            aria-label="Default select example"
            name="batiment"
            // on={handleChangeSalle}
            // onChange={handleChangeSalle}
            value={salle.batimentId}
            // disabled={true}
          >
            <option>Selectionner un enseignant</option>
            {batiments.map((e) => (
              <option key={e.id} value={e.id}>
                {e.id} - {e.nom}
              </option>
            ))}
          </CFormSelect>
        </CCardBody>

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
