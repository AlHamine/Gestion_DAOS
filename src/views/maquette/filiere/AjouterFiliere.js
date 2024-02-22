import { CButton, CFormInput, CFormTextarea, CInputGroup, CInputGroupText } from '@coreui/react'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'

export default function AjouterFiliere() {
  const navigate = useNavigate()
  const [filiere, setFiliere] = useState({
    nom: '',
    // description: '',
    // createdAt: new Date().toISOString().split('.')[0] + 'Z',
    // utilisateur: null,
    // credit: '',
    // coefficient: '',
    // code: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setFiliere({
      ...filiere,
      [name]: value,
    })
  }

  const addFiliere = (uesave) => {
    fetch(SERVER_URL + 'maquette/filiere', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchFiliere()
          alert('filiere ajouter avec successful')
          navigate('/maquette/filiere/Filiere')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addFiliere(filiere)
  }

  return (
    <div>
      <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Nom du filiere
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            // value={filiere.code}
            name="nom"
            onChange={handleChange}
          />
        </CInputGroup>

        <div style={{ marginTop: '20px' }}>
          <CButton color="danger" size="sm" className="me-4">
            Annuler
          </CButton>
          <CButton color="primary" size="sm" onClick={handleSave}>
            Creer une filiere
          </CButton>
        </div>
      </div>
    </div>
  )
}
