import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierEC() {
  const { id } = useParams()
  const [ec, setEC] = useState({})
  const [listUE, setListUE] = useState([])
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setEC({
      ...ec,
      [name]: value,
    })
  }

  useEffect(() => {
    const getEC = () => {
      fetch(SERVER_URL + `maquette/ec/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setEC(data)
        })
        .catch((error) => console.error('Error fetching EC:', error))
    }

    getEC()
  }, [id])

  const updateEC = (ecModifier, ecId) => {
    fetch(SERVER_URL + `maquette/ec/${ecId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ecModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/ec/EC')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  useEffect(() => {
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

    fetchUE()
  }, [id])

  const handleChangeUE = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedUE = listUE[selectedModuleIndex]
    setEC({
      ...ec,
      ue: selectedUE,
    })
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
              <strong style={{ display: 'block', textAlign: 'center' }}>Modification de EC</strong>
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
            value={ec.libelle}
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
            value={ec.description}
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
            value={ec.coefficient}
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
            value={ec.code}
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
            value={ec.cm}
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
            value={ec.td}
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
            value={ec.tp}
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
            value={ec.tpe}
            onChange={handleChange}
            required
            min="0"
          />
        </CCol>
        <div className="mb-3">
          <CFormSelect
            label="Selection le module a modifier"
            feedbackInvalid="Selection un module valide"
            aria-label="select example"
            required
            // name="module"
            // onChange={handleChangeAtelier}

            // value={atelier.module ? atelier.module.id : ''}
            // value={ec.ue.description}
            onChange={handleChangeUE}
          >
            <option selected="" value="">
              {'Code : '} {ec.ue && ec.ue.code} {' Libelle : '} {ec.ue && ec.ue.libelle}
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
            <CButton color="primary" onClick={() => updateEC(ec, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
