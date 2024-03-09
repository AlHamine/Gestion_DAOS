import React, { useEffect, useState } from 'react'
import ReactQuill from 'react-quill'
import 'react-quill/dist/quill.snow.css'
import { CButton, CCard, CCardBody, CCardHeader, CCol, CPagination, CRow } from '@coreui/react'
import { SERVER_URL } from 'src/constantURL'
import { useParams } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'

export default function ModifierDeroulement() {
  const [deroulement, setDeroulement] = useState(null)
  const [description, setDescription] = useState('')
  const [objectif, setObjectif] = useState('')
  const { id } = useParams()
  const { idE } = useParams()
  const { idseance } = useParams()
  const navigate = useNavigate()

  useEffect(() => {
    fetchDeroulement()
  }, [])

  const fetchDeroulement = () => {
    fetch(SERVER_URL + 'emploi/deroulement/' + id)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then((data) => {
        setDeroulement(data)
        setDescription(data.description)
        setObjectif(data.objectifs)
      })
      .catch((error) => console.error('Error fetching deroulement:', error))
  }

  const handleChangeDescription = (value) => {
    setDescription(value)
  }

  const handleChangeObjectif = (value) => {
    setObjectif(value)
  }

  const backward = () => {
    navigate(`/emploiDuTemps/deroulement/Deroulement/${idE}/${idseance}`)
  }

  const handleSave = () => {
    const donne = {
      id: deroulement.id,
      description: description,
      objectifs: objectif,
    }
    console.log(donne)
    UpdateDeroulement(donne)
  }

  const UpdateDeroulement = (uesave) => {
    fetch(SERVER_URL + `emploi/deroulement/${id}`, {
      method: 'PATCH',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          alert('Deroulement modifié avec succès')
          backward()
        } else {
          alert('Une erreur est survenue')
        }
      })
      .catch((err) => console.error(err))
  }

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <h2 className="text-center">Modification du Deroulement </h2>
          </CCardHeader>
          <CCardBody>
            <div className="mb-3">
              {/* Utilisez l'éditeur de texte ReactQuill pour la description */}
              <ReactQuill theme="snow" value={description} onChange={handleChangeDescription} />
            </div>
          </CCardBody>
        </CCard>
        <CCard className="mb-4">
          <CCardBody>
            <div className="mb-3">
              {/* Utilisez l'éditeur de texte ReactQuill pour l'objectif */}
              <ReactQuill theme="snow" value={objectif} onChange={handleChangeObjectif} />
            </div>
          </CCardBody>
        </CCard>
      </CCol>
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
    </CRow>
  )
}
