import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierFormation() {
  const { id } = useParams()
  const [formation, setFormation] = useState({})
  const [listFiliere, setListFiliere] = useState([])
  const [listMaquette, setListMaquette] = useState([])
  const [listNiveau, setListNiveau] = useState([])
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setFormation({
      ...formation,
      [name]: value,
    })
  }

  useEffect(() => {
    const getFormation = () => {
      fetch(SERVER_URL + `maquette/formation/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setFormation(data)
        })
        .catch((error) => console.error('Error fetching Formation:', error))
    }

    getFormation()
  }, [id])

  const updateFormation = (formationModifier, formationId) => {
    fetch(SERVER_URL + `maquette/formation/${formationId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formationModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/formation/Formation')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  useEffect(() => {
    const fetchFiliere = () => {
      fetch(SERVER_URL + 'maquette/filiere')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListFiliere(data)
        })
        .catch((error) => console.error('Error fetching Filiere:', error))
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

    const fetchNiveau = () => {
      fetch(SERVER_URL + 'maquette/niveau')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListNiveau(data)
        })
        .catch((error) => console.error('Error fetching Niveau:', error))
    }

    fetchMaquette()
    fetchNiveau()
    fetchFiliere()
  }, [])

  const handleChangeFiliere = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedFiliere = listFiliere[selectedModuleIndex]
    setFormation({
      ...formation,
      filiere: selectedFiliere,
    })
  }

  const handleChangeMaquette = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedMaquette = listMaquette[selectedModuleIndex]
    setFormation({
      ...formation,
      maquette: selectedMaquette,
    })
  }

  const handleChangeNiveau = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedNiveau = listNiveau[selectedModuleIndex]
    setFormation({
      ...formation,
      niveau: selectedNiveau,
    })
  }

  const backward = () => {
    navigate('/maquette/formation/Formation')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification de Formation
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
            value={formation.nom}
            onChange={handleChange}
            valid
          />
        </CCol>
        <div className="mb-3">
          <CFormSelect
            label="Selection la filiere de cette formation"
            feedbackInvalid="Selection une formation valide"
            aria-label="select example"
            name="filiere"
            onChange={handleChangeFiliere}
          >
            <option selected="" value="">
              {'Nom : '} {formation.filiere && formation.filiere.nom}
            </option>
            {listFiliere.map((filiere, index) => (
              <option key={index} value={index}>
                {'Nom : '} {filiere && filiere.nom}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection le maquette de cette formation"
            feedbackInvalid="Selection un maquette valide"
            aria-label="select example"
            name="maquette"
            onChange={handleChangeMaquette}
          >
            <option selected="" value="">
              {'Intitule : '} {formation.maquette && formation.maquette.intitule}
            </option>
            {listMaquette.map((maquette, index) => (
              <option key={index} value={index}>
                {'Intitule : '} {maquette && maquette.intitule}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection le niveau de cette formation"
            feedbackInvalid="Selection un niveau valide"
            aria-label="select example"
            name="niveau"
            onChange={handleChangeNiveau}
          >
            <option selected="" value="">
              {'Nom : '} {formation.niveau && formation.niveau.nom}
            </option>
            {listNiveau.map((niveau, index) => (
              <option key={index} value={index}>
                {'Nom : '} {niveau && niveau.nom}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div>
          <CCol xs={12} className="d-flex justify-content-center">
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={() => updateFormation(formation, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
