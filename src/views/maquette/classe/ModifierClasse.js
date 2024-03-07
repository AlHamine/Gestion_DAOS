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
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierClasse() {
  const { id } = useParams()
  const [classe, setClasse] = useState({})
  const [listSemestre, setListSemestre] = useState([])
  const [listFormation, setListFormation] = useState([])
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setClasse({
      ...classe,
      [name]: value,
    })
  }

  useEffect(() => {
    const getClasse = () => {
      fetch(SERVER_URL + `maquette/classe/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setClasse(data)
        })
        .catch((error) => console.error('Error fetching Classe:', error))
    }

    getClasse()
  }, [id])

  const updateClasse = (classeModifier, classeId) => {
    fetch(SERVER_URL + `maquette/classe/${classeId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(classeModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/classe/Classe')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  useEffect(() => {
    const fectSemestre = () => {
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

    fectSemestre()
    fetchFormation()
  }, [id])

  const handleChangeSemestre = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedSemestre = listSemestre[selectedModuleIndex]
    setClasse({
      ...classe,
      semestre: selectedSemestre,
    })
  }

  const handleChangeFormation = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedFormation = listFormation[selectedModuleIndex]
    setClasse({
      ...classe,
      formation: selectedFormation,
    })
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
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification de Classe
              </strong>
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
            value={classe.libelle}
            onChange={handleChange}
            valid
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Effectif"
            defaultValue=""
            name="effectif"
            value={classe.effectif}
            onChange={handleChange}
            valid
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="NbreGroupe"
            defaultValue=""
            name="nbreGroupe"
            value={classe.nbreGroupe}
            onChange={handleChange}
            valid
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
            value={classe.description}
            onChange={handleChange}
          ></CFormTextarea>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection la formation de classe"
            feedbackInvalid="Selection une formation valide"
            aria-label="select example"
            name="formation"
            onChange={handleChangeFormation}
          >
            <option selected="" value="">
              {'Nom : '} {classe.formation && classe.formation.nom}
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
            name="semestre"
            onChange={handleChangeSemestre}
          >
            <option selected="" value="">
              {'Libelle : '} {classe.semestre && classe.semestre.libelle}
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
            <CButton color="primary" onClick={() => updateClasse(classe, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
