import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierNiveau() {
  const { id } = useParams()
  const [niveau, setNiveau] = useState({})
  const [listCycle, setListCycle] = useState([])
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setNiveau({
      ...niveau,
      [name]: value,
    })
  }

  useEffect(() => {
    const getEC = () => {
      fetch(SERVER_URL + `maquette/niveau/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setNiveau(data)
        })
        .catch((error) => console.error('Error fetching Niveau:', error))
    }

    getEC()
  }, [id])

  const updateEC = (ecModifier, ecId) => {
    fetch(SERVER_URL + `maquette/niveau/${ecId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ecModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/niveau/Niveau')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  useEffect(() => {
    const getCycle = () => {
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

    getCycle()
  }, [id])

  const handleChangeCycle = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedCycle = listCycle[selectedModuleIndex]
    setNiveau({
      ...niveau,
      cycle: selectedCycle,
    })
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
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification de Niveau
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
            value={niveau.nom}
            onChange={handleChange}
            required
          />
        </CCol>
        <div className="mb-3">
          <CFormSelect
            label="Selection le cycle de ce niveau"
            feedbackInvalid="Selection un cycle valide"
            aria-label="select example"
            name="cycle"
            onChange={handleChangeCycle}
          >
            <option selected="" value="">
              {'Nom : '} {niveau.cycle && niveau.cycle.nom}
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
            <CButton color="primary" onClick={() => updateEC(niveau, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
