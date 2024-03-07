import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterEC() {
  const navigate = useNavigate()
  const [listUE, setListUE] = useState([])
  const [ec, setEC] = useState({
    libelle: '',
    cm: null,
    td: null,
    tp: null,
    tpe: null,
    coefficient: null,
    description: '',
    ue: null,
    code: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setEC({
      ...ec,
      [name]: value,
    })
  }

  useEffect(() => {
    fetchUE()
  }, [])

  const fetchUE = () => {
    fetch(SERVER_URL + 'maquette/ue')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListUE(data)
      })
      .catch((error) => console.error('Error fetching UE:', error))
  }

  const addEC = (ecsave) => {
    fetch(SERVER_URL + 'maquette/ec', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ecsave),
    })
      .then((response) => {
        if (response.ok) {
          alert('EC ajouter avec successful')
          navigate('/maquette/ec/EC')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleChangeUE = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedUE = listUE[selectedModuleIndex]
    setEC({
      ...ec,
      ue: selectedUE,
    })
  }

  const handleSave = () => {
    addEC(ec)
  }

  const backward = () => {
    navigate('/maquette/ec/EC')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du EC</strong>
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
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Coefficient"
            defaultValue=""
            name="coefficient"
            onChange={handleChange}
            valid
            required
            min="0"
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer02"
            label="Code"
            defaultValue=""
            valid
            name="code"
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="number"
            id="validationServer02"
            label="CM"
            defaultValue=""
            valid
            name="cm"
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="number"
            id="validationServer02"
            label="TD"
            defaultValue=""
            valid
            name="td"
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="number"
            id="validationServer02"
            label="TP"
            defaultValue=""
            valid
            name="tp"
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="number"
            id="validationServer02"
            label="TPE"
            defaultValue=""
            valid
            name="tpe"
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <div className="mb-3">
          <CFormSelect
            label="Selection le module de cette atelier"
            feedbackInvalid="Selection un module valide"
            aria-label="select example"
            required
            name="ue"
            onChange={handleChangeUE}
          >
            <option selected="" value="">
              Selection son ue
            </option>
            {listUE.map((ue, index) => (
              <option key={index} value={index}>
                {'Code : '} {ue.code} {' Libelle : '} {ue.libelle}{' '}
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
