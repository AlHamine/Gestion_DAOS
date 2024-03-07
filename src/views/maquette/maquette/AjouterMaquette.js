import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormTextarea } from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterMaquette() {
  const navigate = useNavigate()
  const [maquette, setMaquette] = useState({
    credit: '',
    coefUe: '',
    intitule: '',
    cm: '',
    td: '',
    tp: '',
    cumule: '',
    tpe: '',
    vh: '',
    coef: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setMaquette({
      ...maquette,
      [name]: value,
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
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Credit"
            defaultValue=""
            name="credit"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="CoefUe"
            defaultValue=""
            name="coefUe"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="CM"
            defaultValue=""
            name="cm"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="TD"
            defaultValue=""
            name="td"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="TP"
            defaultValue=""
            name="tp"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Cumule"
            defaultValue=""
            name="cumule"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="TPE"
            defaultValue=""
            name="tpe"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="VH"
            defaultValue=""
            name="vh"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Coef"
            defaultValue=""
            name="coef"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <div className="mb-3">
          <CFormTextarea
            feedbackInvalid="SVP entrer l'intitule du maquette."
            id="validationTextarea"
            label="Entrer l'Intitule du maquette"
            placeholder="L'intitule du maquette."
            required
            name="intitule"
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
