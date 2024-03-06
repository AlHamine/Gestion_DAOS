import {
  CButton,
  CFormInput,
  CForm,
  CFormTextarea,
  CInputGroup,
  CInputGroupText,
} from '@coreui/react'
import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useParams } from 'react-router-dom'
export default function ModifierPER() {
  const { id } = useParams()
  const navigate = useNavigate()
  const [per, setPER] = useState({
    prenom: '',
    nom: '',
    grade: '',
    matricule: '',
    specialite: '',
    // createdAt: new Date().toISOString().split('.')[0] + 'Z',
    // utilisateur: null,
    // credit: '',
    // coefficient: '',
    // code: '',
  })
  const backward = () => {
    navigate('/repartition/per/PER')
  }
  const handleChange = (event) => {
    const { name, value } = event.target
    setPER({
      ...per,
      [name]: value,
    })
  }
  const getPER = () => {
    fetch(SERVER_URL + `repartition/per/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }

        return response.json()
      })
      .then((data) => {
        setPER(data)
      })
      .catch((error) => console.error('Error fetching UE:', error))
  }

  useEffect(() => {
    getPER()
  }, [])

  const addPER = (uesave) => {
    fetch(SERVER_URL + 'repartition/per', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchPER()
          alert('per MODIFIE avec success')
          navigate('/repartition/per/PER')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addPER(per)
  }

  return (
    <div style={{ transform: 'scale(1.5)' }}>
      <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
        <CForm className="row g-3" validated={true}>
          <CInputGroup size="sm" className="mb-3">
            <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
              Prenom
            </CInputGroupText>
            <CFormInput
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              value={per.prenom}
              name="prenom"
              onChange={handleChange}
              required
            />
          </CInputGroup>
          <CInputGroup size="sm" className="mb-3">
            <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
              Nom
            </CInputGroupText>
            <CFormInput
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              value={per.nom}
              name="nom"
              onChange={handleChange}
              required
            />
          </CInputGroup>
          <CInputGroup size="sm" className="mb-3">
            <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
              Grade
            </CInputGroupText>
            <CFormInput
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              value={per.grade}
              name="grade"
              onChange={handleChange}
              required
            />
          </CInputGroup>
          <CInputGroup size="sm" className="mb-3">
            <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
              Matricule
            </CInputGroupText>
            <CFormInput
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              value={per.matricule}
              name="matricule"
              onChange={handleChange}
              required
            />
          </CInputGroup>
          <CInputGroup size="sm" className="mb-3">
            <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
              Specialite
            </CInputGroupText>
            <CFormInput
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-sm"
              value={per.specialite}
              name="specialite"
              onChange={handleChange}
              required
            />
          </CInputGroup>

          <div style={{ marginTop: '20px' }}>
            <CButton color="danger" size="sm" className="me-4" onClick={backward}>
              Annuler
            </CButton>
            <CButton color="primary" size="sm" onClick={handleSave}>
              Modifier
            </CButton>
          </div>
        </CForm>
      </div>
    </div>
  )
}
