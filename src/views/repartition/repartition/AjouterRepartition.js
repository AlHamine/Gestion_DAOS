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
    const selectedEnseignement = enseignements.find((e) => e.id == selectedId)
    console.log(selectedEnseignement)
    setRepartition((prevState) => ({
      ...prevState,
      enseignement: { id: selectedEnseignement.id },
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
          backward()
          return response.json()
        } else {
          alert('Something went wrong')
        }
        // navigate('/repartition/repartition/Repartition')
      })
      .then((data) => {
        console.log('TESTTTTTTTTTTTTTT SECOND FTECH')
        console.log(data)
        if (SERVER_URL == 'http://localhost:8080/') {
          fetch(SERVER_URL + 'emploi/repartition', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data),
          }).then((response2) => {
            if (response2.ok) alert('Repartition ajoutée avec succès Cote Slave')
            navigate('/repartition/repartition/Repartition')
          })
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addRepartition(repartition)
  }

  return (
    <div style={{ transform: 'scale(1.4)' }}>
      <br></br>
      <h1 className="text-center">AJOUT D{"'"}UNE REPARTITION</h1>
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
              invalid={true}
            >
              <option disabled selected formNoValidate value="">
                Selectionner un enseignement
              </option>
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
              required
              invalid={true}
            >
              <option disabled selected formNoValidate value="">
                Selectionner un enseignant
              </option>
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
