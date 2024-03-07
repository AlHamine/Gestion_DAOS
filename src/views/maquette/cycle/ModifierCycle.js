import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierCycle() {
  const { id } = useParams()
  const [cycle, setCycle] = useState({})
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setCycle({
      ...cycle,
      [name]: value,
    })
  }

  useEffect(() => {
    const getCycle = () => {
      fetch(SERVER_URL + `maquette/cycle/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setCycle(data)
        })
        .catch((error) => console.error('Error fetching Cycle:', error))
    }

    getCycle()
  }, [id])

  const updateCycle = (cycleModifier, cycleId) => {
    fetch(SERVER_URL + `maquette/cycle/${cycleId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(cycleModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/cycle/Cycle')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
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
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification du Cycle
              </strong>
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
            value={cycle.nom}
            onChange={handleChange}
            valid
          />
        </CCol>
        <div>
          <CCol xs={12} className="d-flex justify-content-center">
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={() => updateCycle(cycle, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
