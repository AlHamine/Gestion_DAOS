import {
  CButton,
  CCard,
  CCardHeader,
  CCol,
  CForm,
  CFormInput,
  CFormSelect,
  CFormTextarea,
} from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterClasse() {
  const navigate = useNavigate()
  const [listFormation, setListFormation] = useState([])
  const [listSemestre, setListSemestre] = useState([])
  const [classe, setClasse] = useState({
    libelle: '',
    effectif: '',
    nbreGroupe: '',
    description: '',
    semestre: null,
    formation: null,
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setClasse({
      ...classe,
      [name]: value,
    })
  }

  useEffect(() => {
    const fetchFormation = () => {
      fetch(SERVER_URL + 'maquette/formation')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListFormation(data)
        })
        .catch((error) => console.error('Error fetching Formation:', error))
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

    fetchFormation()
    fetchSemestre()
  }, [])

  const addClasse = (classeSave) => {
    fetch(SERVER_URL + 'maquette/classe', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(classeSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Classe ajouter avec successful')
          navigate('/maquette/classe/Classe')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleChangeFormation = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedFormation = listFormation[selectedModuleIndex]
    setClasse({
      ...classe,
      formation: selectedFormation,
    })
  }

  const handleChangeSemestre = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedSemestre = listSemestre[selectedModuleIndex]
    setClasse({
      ...classe,
      semestre: selectedSemestre,
    })
  }

  const handleSave = () => {
    addClasse(classe)
  }

  const backward = () => {
    navigate('/maquette/classe/Classe')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du Classe</strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={4}>
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
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Effectif"
            defaultValue=""
            name="effectif"
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="NbreGroupe"
            defaultValue=""
            name="nbreGroupe"
            onChange={handleChange}
            valid
            required
            min="0"
          />
        </CCol>
        <div className="mb-3">
          <CFormTextarea
            feedbackInvalid="SVP entrer la description de la classe."
            id="validationTextarea"
            label="Description"
            placeholder="L'objectif de la classe."
            required
            name="description"
            onChange={handleChange}
          ></CFormTextarea>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection la formation de classe"
            feedbackInvalid="Selection une formation valide"
            aria-label="select example"
            required
            name="formation"
            onChange={handleChangeFormation}
          >
            <option selected="" value="">
              Selection son formation
            </option>
            {listFormation.map((formation, index) => (
              <option key={index} value={index}>
                {'Nom : '} {formation && formation.nom}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection le semestre de ce classe"
            feedbackInvalid="Selection un semestre valide"
            aria-label="select example"
            required
            name="semestre"
            onChange={handleChangeSemestre}
          >
            <option selected="" value="">
              Selection le semestre
            </option>
            {listSemestre.map((semestre, index) => (
              <option key={index} value={index}>
                {'Libelle : '} {semestre && semestre.libelle}
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
