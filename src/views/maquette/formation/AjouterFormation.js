import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterFormation() {
  const navigate = useNavigate()
  const [listFiliere, setListFiliere] = useState([])
  const [listMaquette, setListMaquette] = useState([])
  const [listNiveau, setListNiveau] = useState([])
  const [formation, setFormation] = useState({
    nom: '',
    filiere: null,
    maquette: null,
    niveau: null,
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setFormation({
      ...formation,
      [name]: value,
    })
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

    fetchFiliere()
    fetchMaquette()
    fetchNiveau()
  }, [])

  const addFormation = (formationSave) => {
    fetch(SERVER_URL + 'maquette/formation', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(formationSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Formation ajouter avec successful')
          navigate('/maquette/formation/Formation')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

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

  const handleSave = () => {
    addFormation(formation)
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
                Creation du Formation
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
            onChange={handleChange}
            valid
            required
          />
        </CCol>

        <div className="mb-3">
          <CFormSelect
            label="Selection la filiere de cette formation"
            feedbackInvalid="Selection une formation valide"
            aria-label="select example"
            required
            name="filiere"
            onChange={handleChangeFiliere}
          >
            <option selected="" value="">
              Selection la filiere
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
            required
            name="maquette"
            onChange={handleChangeMaquette}
          >
            <option selected="" value="">
              Selection le maquette
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
            required
            name="niveau"
            onChange={handleChangeNiveau}
          >
            <option selected="" value="">
              Selection le niveau
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
            <CButton color="primary" onClick={handleSave}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
