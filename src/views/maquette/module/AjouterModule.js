import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterModule() {
  const navigate = useNavigate()
  const [listUE, setListUE] = useState([])
  const [listEC, setListEC] = useState([])
  const [listMaquette, setListMaquette] = useState([])
  const [listSemestre, setListSemestre] = useState([])
  const [module, setModule] = useState({
    nom: '',
    ue: null,
    ec: null,
    semestre: null,
    maquette: null,
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setModule({
      ...module,
      [name]: value,
    })
  }

  useEffect(() => {
    fetchUE()
    fetchEC()
    fetchMaquette()
    fetchSemestre()
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

  const fetchEC = () => {
    fetch(SERVER_URL + 'maquette/ec')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListEC(data)
      })
      .catch((error) => console.error('Error fetching EC:', error))
  }

  const fetchMaquette = () => {
    fetch(SERVER_URL + 'maquette/maquette')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListMaquette(data)
      })
      .catch((error) => console.error('Error fetching Maquette:', error))
  }

  const fetchSemestre = () => {
    fetch(SERVER_URL + 'maquette/semestre')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
        setListSemestre(data)
      })
      .catch((error) => console.error('Error fetching Semestre:', error))
  }

  const addModule = (moduleSave) => {
    fetch(SERVER_URL + 'maquette/module', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(moduleSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Module ajouter avec successful')
          navigate('/maquette/module/Module')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleChangeUE = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedUE = listUE[selectedModuleIndex]
    setModule({
      ...module,
      ue: selectedUE,
    })
  }

  const handleChangeEC = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedEC = listEC[selectedModuleIndex]
    setModule({
      ...module,
      ec: selectedEC,
    })
  }

  const handleChangeMaquette = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedMaquette = listMaquette[selectedModuleIndex]
    setModule({
      ...module,
      maquette: selectedMaquette,
    })
  }

  const handleChangeSemestre = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedSemestre = listSemestre[selectedModuleIndex]
    setModule({
      ...module,
      semestre: selectedSemestre,
    })
  }

  const handleSave = () => {
    addModule(module)
  }

  const backward = () => {
    navigate('/maquette/module/Module')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du Module</strong>
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
            label="Selection l'ue de cet module"
            feedbackInvalid="Selection un ue valide"
            aria-label="select example"
            required
            // name="module"
            // value={atelier.module ? atelier.module.id : ''}
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
        <div className="mb-3">
          <CFormSelect
            label="Selection l'ec de cet module"
            feedbackInvalid="Selection un ec valide"
            aria-label="select example"
            required
            // name="module"
            // value={atelier.module ? atelier.module.id : ''}
            onChange={handleChangeEC}
          >
            <option selected="" value="">
              Selection son ec
            </option>
            {listEC.map((ec, index) => (
              <option key={index} value={index}>
                {'Code : '} {ec.code} {' Libelle : '} {ec.libelle}{' '}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection le maquette de cet module"
            feedbackInvalid="Selection un maquette valide"
            aria-label="select example"
            required
            // name="module"
            // value={atelier.module ? atelier.module.id : ''}
            onChange={handleChangeMaquette}
          >
            <option selected="" value="">
              Selection son maquette
            </option>
            {listMaquette.map((maquette, index) => (
              <option key={index} value={index}>
                {'Intitule : '} {maquette.intitule}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection le semestre de cet module"
            feedbackInvalid="Selection un semestre valide"
            aria-label="select example"
            required
            // name="module"
            // value={atelier.module ? atelier.module.id : ''}
            onChange={handleChangeSemestre}
          >
            <option selected="" value="">
              Selection son semestre
            </option>
            {listSemestre.map((semestre, index) => (
              <option key={index} value={index}>
                {'Libelle : '} {semestre.libelle}
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
