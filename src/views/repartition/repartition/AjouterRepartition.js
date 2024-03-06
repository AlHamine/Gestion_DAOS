import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { CButton, CForm, CCardBody, CFormSelect } from '@coreui/react'

export default function AjouterRepartition() {
  const navigate = useNavigate()
  const [enseignements, setEnseignements] = useState([])
  const [enseignants, setEnseignants] = useState([])
  const [repartition, setRepartition] = useState({
    enseignement: { id: '' },
    enseignant: { id: '' },
  })

  useEffect(() => {
    const chargerEnseignements = () => {
      fetch(SERVER_URL + 'maquette/enseignement', {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setEnseignements(data))
        .catch((err) => console.error(err))
    }

    const chargerEnseignants = () => {
      fetch(SERVER_URL + 'repartition/enseignant', {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setEnseignants(data))
        .catch((err) => console.error(err))
    }

    chargerEnseignements()
    chargerEnseignants()
  }, [])

  const handleChangeEnseignement = (e) => {
    const selectedId = e.target.value
    console.log(selectedId)
    const selectedEnseignement = enseignements.find((e) => {
      // console.log(selectedEnseignement)
      return e.id == selectedId
    })
    console.log(selectedEnseignement)
    setRepartition((prevState) => ({
      ...prevState,
      enseignement: selectedEnseignement,
    }))
  }
  const backward = () => {
    navigate('/repartition/repartition/Repartition')
  }
  const handleChangeEnseignant = (e) => {
    const selectedId = e.target.value
    const selectedEnseignant = enseignants.find((e) => e.id == selectedId)
    console.log(selectedEnseignant)
    selectedEnseignant.type = selectedEnseignant.matricule ? 'PER' : 'VAC'
    setRepartition((prevState) => ({
      ...prevState,
      enseignant: selectedEnseignant,
    }))
    console.log(repartition)
  }

  const addRepartition = (repartition) => {
    console.log('Test FETCHING', repartition)
    fetch(SERVER_URL + 'repartition/repartition', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(repartition),
    })
      .then((response) => {
        if (response.ok) {
          alert('Repartition ajoutée avec succès')
          navigate('/repartition/repartition/Repartition')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addRepartition(repartition)
  }

  return (
    <div style={{ transform: 'scale(1.4)' }}>
      <CForm className="row g-3" validated={true}>
        <br />
        <br />
        <br />
        <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
          <CCardBody>
            <CFormSelect
              aria-label="Default select example"
              name="enseignement"
              onChange={handleChangeEnseignement}
              required
            >
              <option>Selectionner un enseignement</option>
              {enseignements.map((e) => (
                <option key={e.id} value={e.id}>
                  Classe: {e.groupe.classe.libelle} - Groupe: {e.groupe.libelle} {e.module.nom}
                </option>
              ))}
            </CFormSelect>
          </CCardBody>
          <br />
          <CCardBody>
            <CFormSelect
              aria-label="Default select example"
              name="enseignant"
              onChange={handleChangeEnseignant}
              required
            >
              <option>Selectionner un enseignant</option>
              {enseignants.map((e) => (
                <option key={e.id} value={e.id}>
                  {e.id} - {e.prenom} {e.nom} {e.grade} en {e.specialite}
                </option>
              ))}
            </CFormSelect>
          </CCardBody>

          <div style={{ marginTop: '20px' }}>
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Annuler
            </CButton>
            <CButton color="primary" size="sm" onClick={handleSave}>
              Enregistrer
            </CButton>
          </div>
        </div>
      </CForm>
    </div>
  )
}
