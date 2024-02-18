import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormTextarea } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierUE() {
  const { id } = useParams()
  const [ue, setUE] = useState({})
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setUE({
      ...ue,
      [name]: value,
    })
  }

  useEffect(() => {
    const getUE = () => {
      fetch(SERVER_URL + `maquette/ue/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setUE(data)
        })
        .catch((error) => console.error('Error fetching UE:', error))
    }

    getUE()
  }, [id])

  const updateUE = (ueModifier, ueId) => {
    fetch(SERVER_URL + `maquette/ue/${ueId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ueModifier),
    })
      .then((response) => {
        if (response.ok) {
          // afterAddUE()
          navigate('/maquette/ue/UE')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
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
              <strong style={{ display: 'block', textAlign: 'center' }}>Modification du UE</strong>
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
            value={ue.code}
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
            value={ue.libelle}
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
            value={ue.credit}
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
            value={ue.coefficient}
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
            value={ue.description}
            onChange={handleChange}
          ></CFormTextarea>
        </div>
        <div>
          <CCol xs={12} className="d-flex justify-content-center">
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={() => updateUE(ue, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
