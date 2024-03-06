import {
  CButton,
  CFormInput,
  CFormTextarea,
  CInputGroup,
  CInputGroupText,
  CPopover,
} from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function EditFiliere() {
  const { id } = useParams()
  const [filiere, setUE] = useState({})
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setUE({
      ...filiere,
      [name]: value,
    })
  }

  const afterAddUE = () => {
    ;<CPopover
      title="Ajout de la Filiere reussit"
      content="La Filiere a été modifier avec success dans la base de donnée"
      placement="right"
    >
      <CButton color="danger" size="lg">
        Click to toggle popover
      </CButton>
    </CPopover>
  }

  const getUE = () => {
    fetch(SERVER_URL + `maquette/filiere/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }

        return response.json()
      })
      .then((data) => {
        setUE(data)
      })
      .catch((error) => console.error('Error fetching Filiere:', error))
  }

  useEffect(() => {
    getUE()
  }, [])

  const updateUE = (ueModifier, ueId) => {
    fetch(SERVER_URL + `maquette/filiere/${ueId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ueModifier),
    })
      .then((response) => {
        if (response.ok) {
          // afterAddUE()
          navigate('/base/filiere')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  return (
    <div>
      <div className="mx-auto text-center" style={{ maxWidth: '60%' }}>
        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Code
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            name="code"
            value={filiere.code}
            onChange={handleChange}
          />
        </CInputGroup>

        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Libelle
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            name="libelle"
            value={filiere.libelle}
            onChange={handleChange}
          />
        </CInputGroup>

        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Credit
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            name="credit"
            value={filiere.credit}
            onChange={handleChange}
          />
        </CInputGroup>

        <CInputGroup size="sm" className="mb-3">
          <CInputGroupText id="inputGroup-sizing-sm" className="w-25">
            Coefficient
          </CInputGroupText>
          <CFormInput
            aria-label="Sizing example input"
            aria-describedby="inputGroup-sizing-sm"
            name="coefficient"
            value={filiere.coefficient}
            onChange={handleChange}
          />
        </CInputGroup>
        <CInputGroup>
          <CInputGroupText>La description du Filiere</CInputGroupText>
          <CFormTextarea
            aria-label="With textarea"
            name="description"
            value={filiere.description}
            onChange={handleChange}
          ></CFormTextarea>
        </CInputGroup>
        <div style={{ marginTop: '20px' }}>
          <CButton color="danger" size="sm" className="me-4">
            Annuler
          </CButton>
          <CButton color="primary" size="sm" onClick={() => updateUE(filiere, id)}>
            Modifier Filiere
          </CButton>
        </div>
      </div>
    </div>
  )
}