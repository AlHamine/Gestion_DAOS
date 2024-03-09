import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { CButton, CCardBody, CFormSelect } from '@coreui/react'
import { useParams } from 'react-router-dom'
export default function ModifierRepartition() {
  const { id } = useParams()
  const navigate = useNavigate()
  const [enseignements, setEnseignements] = useState([])
  const [enseignants, setEnseignants] = useState([])
  const [repartition, setRepartition] = useState({
    enseignement: { id: '' },
    enseignant: { id: '' },
  })

  const backward = () => {
    navigate('/repartition/repartition/Repartition')
  }
  useEffect(() => {
    const chargerRepartition = () => {
      fetch(SERVER_URL + `repartition/repartition/${id}`, {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setRepartition(data))
        .catch((err) => console.error(err))
    }
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
    chargerRepartition()
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
    console.log('TEST FETCHING', repartition)
    fetch(SERVER_URL + 'repartition/repartition/' + repartition.id, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(repartition),
    })
      .then((response) => {
        if (response.ok) {
          alert('Repartition modifiée avec succès')
          navigate('/repartition/repartition/Repartition')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    const typeEns = repartition.enseignement.matricule ? 'PER' : 'VAC'
    const donne = {
      id: repartition.id,
      enseignement: { id: repartition.enseignement.id },
      enseignant: { id: repartition.enseignant.id, type: typeEns },
    }
    console.log(donne)
    addRepartition(donne)
  }

  return (
    <div>
      <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
        <CCardBody>
          <CFormSelect
            aria-label="Default select example"
            name="enseignement"
            onChange={handleChangeEnseignement}
            value={repartition.enseignement.id}
          >
            <option>Selectionner un enseignement</option>
            {enseignements.map((e) => (
              <option key={e.id} value={e.id}>
                Classe: {e.classe} {e.groupe ? ` - Groupe : ${e.groupe}` : ' - '} {e.module}
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
            value={repartition.enseignant.id}
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
          <CButton color="danger" size="sm" className="me-4" onClick={backward}>
            Annuler
          </CButton>
          <CButton color="primary" size="sm" onClick={handleSave}>
            Enregistrer
          </CButton>
        </div>
      </div>
    </div>
  )
}
