import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierModule() {
  const { id } = useParams()
  const [module, setModule] = useState({})
  const [listUE, setListUE] = useState([])
  const [listEC, setListEC] = useState([])
  const [listMaquette, setListMaquette] = useState([])
  const [listSemestre, setListSemestre] = useState([])
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setModule({
      ...module,
      [name]: value,
    })
  }

  useEffect(() => {
    const getModule = () => {
      fetch(SERVER_URL + `maquette/module/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setModule(data)
        })
        .catch((error) => console.error('Error fetching Module:', error))
    }

    getModule()
  }, [id])

  const updateModule = (moduleModifier, moduleId) => {
    fetch(SERVER_URL + `maquette/module/${moduleId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(moduleModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/module/Module')
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
        .catch((error) => console.error('Error fetching UE:', error))
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
        .catch((error) => console.error('Error fetching UE:', error))
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
        .catch((error) => console.error('Error fetching UE:', error))
    }

    fetchUE()
    fetchEC()
    fetchMaquette()
    fetchSemestre()
  }, [id])

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

  const backward = () => {
    navigate('/maquette/module/Module')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification de Module
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
            value={module.nom}
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <div className="mb-3">
          <CFormSelect
            label="Selection l'UE a modifier"
            feedbackInvalid="Selection un UE valide"
            aria-label="select example"
            required
            name="ue"
            onChange={handleChangeUE}
          >
            <option selected="" value="">
              {'Code : '} {module.ue && module.ue.code} {' Libelle : '}{' '}
              {module.ue && module.ue.libelle}{' '}
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
            name="ec"
            onChange={handleChangeEC}
          >
            <option selected="" value="">
              {'Libelle : '} {module.ec && module.ec.libelle}
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
            name="maquette"
            onChange={handleChangeMaquette}
          >
            <option selected="" value="">
              {'Intitule : '} {module.maquette && module.maquette.intitule}
            </option>
            {listMaquette.map((maquette, index) => (
              <option key={index} value={index}>
                {'Maquette de  : '} {maquette?.formation}-{maquette?.filiere}
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
            name="semestre"
            onChange={handleChangeSemestre}
          >
            <option selected="" value="">
              {'Libelle : '} {module.semestre && module.semestre.libelle}
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
            <CButton color="primary" onClick={() => updateModule(module, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
