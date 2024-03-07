import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterEC() {
  const navigate = useNavigate()
  const [listCycle, setListCycle] = useState([])
  const [niveau, setNiveau] = useState({
    nom: '',
    cycle: null,
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setNiveau({
      ...niveau,
      [name]: value,
    })
  }

  useEffect(() => {
    fetchCycle()
  }, [])

  const fetchCycle = () => {
    fetch(SERVER_URL + 'maquette/cycle')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListCycle(data)
      })
      .catch((error) => console.error('Error fetching Cycle:', error))
  }

  const addNiveau = (niveauSave) => {
    fetch(SERVER_URL + 'maquette/niveau', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(niveauSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Niveau ajouter avec successful')
          navigate('/maquette/niveau/Niveau')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleChangeCycle = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedCycle = listCycle[selectedModuleIndex]
    setNiveau({
      ...niveau,
      cycle: selectedCycle,
    })
  }

  const handleSave = () => {
    addNiveau(niveau)
  }

  const backward = () => {
    navigate('/maquette/niveau/Niveau')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du Niveau</strong>
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
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <div className="mb-3">
          <CFormSelect
            label="Selection le cycle de ce niveau"
            feedbackInvalid="Selection un cycle valide"
            aria-label="select example"
            required
            name="cycle"
            onChange={handleChangeCycle}
          >
            <option selected="" value="">
              Selection son cycle
            </option>
            {listCycle.map((cycle, index) => (
              <option key={index} value={index}>
                {'Nom : '} {cycle && cycle.nom}
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
