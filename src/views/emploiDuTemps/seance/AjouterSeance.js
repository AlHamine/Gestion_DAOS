import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { CButton, CForm, CCardBody, CFormSelect, CCol, CFormInput } from '@coreui/react'

export default function AjouterSeance() {
  const navigate = useNavigate()
  const [repartitions, setRepartitions] = useState([])
  const [salles, setSalles] = useState([])
  const [seance, setSeance] = useState({
    repartition: { id: '' },
    salle: { id: '' },
    heureDebut: '',
    dureee: '',
  })
  useEffect(() => {
    // repartition
    const chargerRepartitions = () => {
      fetch(SERVER_URL + 'repartition/repartition ', {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setRepartitions(data))
        .catch((err) => console.error(err))
    }

    const chargerSalles = () => {
      fetch(SERVER_URL + 'emploi/salle', {
        headers: { 'Content-Type': 'application/json' },
      })
        .then((response) => {
          if (response.ok) {
            return response.json()
          } else {
            throw new Error('Network response was not ok')
          }
        })
        .then((data) => setSalles(data))
        .catch((err) => console.error(err))
    }

    chargerRepartitions()
    chargerSalles()
  }, [])

  const handleChangeReparttion = (e) => {
    const selectedIdd = e.target.value
    console.log(selectedIdd)
    const selectedRepartition = repartitions.find((e) => e.id == selectedIdd)
    console.log(selectedRepartition)
    setSeance((prevState) => ({
      ...prevState,
      repartition: { id: selectedRepartition.id },
    }))
  }
  const backward = () => {
    navigate('/emploiDuTemps/seance/Seance')
  }
  const handleChangeSalle = (e) => {
    const selectedId = e.target.value
    const selectedSalle = salles.find((e) => e.id == selectedId)
    console.log(selectedSalle)
    // selectedSalle.type = selectedSalle.matricule ? 'PER' : 'VAC'
    setSeance((prevState) => ({
      ...prevState,
      salle: { id: selectedSalle.id },
    }))
    console.log(seance)
  }

  const handleChange = (event) => {
    const { name, value } = event.target
    // Mettre à jour la valeur de duree
    // setDuree(value)
    setSeance({
      ...seance,
      [name]: value,
    })
  }
  const verifierFormatHeure = (heure) => {
    // Expression régulière pour vérifier le format HH:MM
    const regex = /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/
    return regex.test(heure)
  }
  const addSeance = (seance) => {
    console.log('Test FETCHING', seance)
    fetch(SERVER_URL + 'emploi/seance', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(seance),
    })
      .then((response) => {
        if (response.ok) {
          alert('Seance ajoutée avec succès')
          setSeance({
            repartition: { id: '' },
            salle: { id: '' },
            heureDebut: '',
            dureee: '',
          })
          backward()
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addSeance(seance)
  }

  return (
    <div style={{ transform: 'scale(1.2)' }}>
      <br></br>
      <h2 className="text-center">AJOUT D{"'"}UNE SEANCE</h2>
      <CForm className="row g-3" validated={true}>
        <br />
        <br />
        <br />
        <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
          <CCardBody>
            <CFormSelect
              aria-label="Default select example"
              name="repartition"
              onChange={handleChangeReparttion}
              required
              invalid={true}
            >
              <option disabled selected formNoValidate value="">
                Selectionner une repartition
              </option>
              {repartitions.map((e) => (
                <option key={e.id} value={e.id}>
                  {e.enseignant.prenom} {e.enseignant.nom} {e.enseignant.grade} en{' '}
                  {e.enseignant.specialite} - {e.enseignement.libelle}- {e.enseignement.classe}{' '}
                  {e.enseignement.groupe ? ` - Groupe : ${e.enseignement.groupe}` : '-'}
                  {e.enseignement.module}-{e.enseignement.semestre}
                </option>
              ))}
            </CFormSelect>
          </CCardBody>
          <br />
          <CCardBody>
            <CFormSelect
              aria-label="Default select example"
              name="salle"
              onChange={handleChangeSalle}
              required
              invalid={true}
            >
              <option disabled selected formNoValidate value="">
                Selectionner une salle
              </option>
              {salles.map((e) => (
                <option key={e.id} value={e.id}>
                  {e.batimentNom}- Salle {e.numero} avec une capacite de {e.capacite} places
                </option>
              ))}
            </CFormSelect>
          </CCardBody>
          <CCardBody>
            <CCol md={6}>
              <CFormInput
                type="text"
                id="validationServer01"
                label="Heure de Debut"
                defaultValue=""
                name="heureDebut"
                onChange={handleChange}
                valid
                placeholder="hh:mm"
                required
                pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" // Expression régulière pour HH:MM
              />
            </CCol>
          </CCardBody>
          <CCardBody>
            <CCol md={6}>
              <CFormInput
                type="text"
                id="validationServer013"
                placeholder="hh:mm"
                label="Duree"
                defaultValue=""
                name="dureee"
                onChange={handleChange}
                valid
                required
                // invalid={!!dureeError2}
                // step="60"
                pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]"
              />
            </CCol>
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
