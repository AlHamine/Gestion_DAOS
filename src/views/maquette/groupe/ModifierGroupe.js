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

export default function ModifierEC() {
  const { id } = useParams()
  const [groupe, setGroupe] = useState({})
  const [listClasse, setListClasse] = useState([])
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setGroupe({
      ...groupe,
      [name]: value,
    })
  }

  useEffect(() => {
    const getGroupe = () => {
      fetch(SERVER_URL + `maquette/groupe/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setGroupe(data)
        })
        .catch((error) => console.error('Error fetching Groupe:', error))
    }

    getGroupe()
  }, [id])

  const updateGroupe = (groupeModifier, groupeId) => {
    fetch(SERVER_URL + `maquette/groupe/${groupeId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(groupeModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/groupe/Groupe')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  useEffect(() => {
    const fetchGroupe = () => {
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

    fetchGroupe()
  }, [id])

  const handleChangeClasse = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedClasse = listClasse[selectedModuleIndex]
    setGroupe({
      ...groupe,
      classe: selectedClasse,
    })
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
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification du Groupe
              </strong>
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
            value={groupe.libelle}
            onChange={handleChange}
            valid
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Effectif"
            defaultValue=""
            name="effectif"
            value={groupe.effectif}
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
            value={groupe.description}
            onChange={handleChange}
          ></CFormTextarea>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection la classe de ce groupe"
            feedbackInvalid="Selection une classe valide"
            aria-label="select example"
            name="classe"
            onChange={handleChangeClasse}
          >
            <option selected="" value="">
              {'Code : '} {groupe.classe && groupe.classe.code} {' Libelle : '}{' '}
              {groupe.classe && groupe.classe.libelle}{' '}
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
            <CButton color="primary" onClick={() => updateGroupe(groupe, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
