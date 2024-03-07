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

export default function AjouterGroupe() {
  const navigate = useNavigate()
  const [listClasse, setListClasse] = useState([])
  const [groupe, setGroupe] = useState({
    libelle: '',
    effectif: '',
    description: '',
    classe: null,
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setGroupe({
      ...groupe,
      [name]: value,
    })
  }

  useEffect(() => {
    const fetchClasse = () => {
      fetch(SERVER_URL + 'maquette/classe')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListClasse(data)
        })
        .catch((error) => console.error('Error fetching Classe:', error))
    }

    fetchClasse()
  }, [])

  const addGroupe = (groupeSave) => {
    fetch(SERVER_URL + 'maquette/groupe', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(groupeSave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Groupe ajouter avec successful')
          navigate('/maquette/groupe/Groupe')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleChangeClasse = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedClasse = listClasse[selectedModuleIndex]
    setGroupe({
      ...groupe,
      classe: selectedClasse,
    })
  }

  const handleSave = () => {
    addGroupe(groupe)
  }

  const backward = () => {
    navigate('/maquette/groupe/Groupe')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>Creation du Groupe</strong>
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
            type="number"
            id="validationServer01"
            label="Effectif"
            defaultValue=""
            name="effectif"
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <div className="mb-3">
          <CFormTextarea
            feedbackInvalid="SVP entrer la description du groupe."
            id="validationTextarea"
            label="Description"
            placeholder="L'objectif du groupe."
            required
            name="description"
            onChange={handleChange}
          ></CFormTextarea>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection la classe de ce groupe"
            feedbackInvalid="Selection une classe valide"
            aria-label="select example"
            required
            name="classe"
            onChange={handleChangeClasse}
          >
            <option selected="" value="">
              Selection son classe
            </option>
            {listClasse.map((classe, index) => (
              <option key={index} value={index}>
                {'Code : '} {classe.code} {' Libelle : '} {classe.libelle}{' '}
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
