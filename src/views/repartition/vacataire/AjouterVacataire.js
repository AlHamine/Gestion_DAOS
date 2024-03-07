import {
  CCard,
  CCardHeader,
  CCol,
  CButton,
  CForm,
  CFormInput,
  CFormTextarea,
  CInputGroup,
  CInputGroupText,
} from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterVacataire() {
  const navigate = useNavigate()
  const [vacataire, setVacataire] = useState({
    prenom: '',
    nom: '',
    grade: '',
    // matricule: '',
    specialite: '',
    type: 'VAC',
    // createdAt: new Date().toISOString().split('.')[0] + 'Z',
    // utilisateur: null,
    // credit: '',
    // coefficient: '',
    // code: '',
  })
  const backward = () => {
    navigate('/repartition/vacataire/Vacataire')
  }
  const handleChange = (event) => {
    const { name, value } = event.target
    setVacataire({
      ...vacataire,
      [name]: value,
    })
  }

  const addVacataire = (uesave) => {
    fetch(SERVER_URL + 'repartition/vacataire', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchVacataire()
          alert('vacataire ajouter avec successful')
          navigate('/repartition/vacataire/Vacataire')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    console.log(vacataire)
    addVacataire(vacataire)
  }

  return (
    <div>
      <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
        <CForm className="row g-3" validated={true}>
          <CInputGroup size="sm" className="mb-3" validated={true}>
            <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
              Prenom
            </CInputGroupText>
            <CFormInput
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              // value={vacataire.code}
              required
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
              // value={vacataire.code}
              required
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
              // value={vacataire.code}
              required
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
              // value={vacataire.code}
              required
              name="specialite"
              onChange={handleChange}
            />
          </CInputGroup>

          <div style={{ marginTop: '20px' }}>
            <CButton onClick={backward} color="danger" size="sm" className="me-4">
              Annuler
            </CButton>
            <CButton color="primary" size="sm" onClick={handleSave}>
              Enregistrer
            </CButton>
          </div>
        </CForm>
      </div>
    </div>
  )
}
