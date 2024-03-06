import { CButton, CFormInput, CFormTextarea, CInputGroup, CInputGroupText } from '@coreui/react'
import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useParams } from 'react-router-dom'
export default function ModifierVacataire() {
  const { id } = useParams()
  const navigate = useNavigate()
  const [vacataire, setVacataire] = useState({
    prenom: '',
    nom: '',
    grade: '',
    // matricule: '',
    specialite: '',
    // createdAt: new Date().toISOString().split('.')[0] + 'Z',
    // utilisateur: null,
    // credit: '',
    // coefficient: '',
    // code: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setVacataire({
      ...vacataire,
      [name]: value,
    })
  }
  const getVacataire = () => {
    fetch(SERVER_URL + `repartition/vacataire/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }

        return response.json()
      })
      .then((data) => {
        setVacataire(data)
      })
      .catch((error) => console.error('Error fetching UE:', error))
  }

  useEffect(() => {
    getVacataire()
  }, [])

  const addVacataire = (uesave) => {
    fetch(SERVER_URL + 'repartition/vacataire', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchVacataire()
          alert('vacataire modifier avec successful')
          navigate('/repartition/vacataire/Vacataire')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addVacataire(vacataire)
  }

  return (
    <div>
      <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Prenom
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            value={vacataire.prenom}
            name="prenom"
            onChange={handleChange}
          />
        </CInputGroup>
        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Nom
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            value={vacataire.nom}
            name="nom"
            onChange={handleChange}
          />
        </CInputGroup>
        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Grade
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            value={vacataire.grade}
            name="grade"
            onChange={handleChange}
          />
        </CInputGroup>
        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Specialite
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            value={vacataire.specialite}
            name="specialite"
            onChange={handleChange}
          />
        </CInputGroup>

        <div style={{ marginTop: '20px' }}>
          <CButton color="danger" size="sm" className="me-4">
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
