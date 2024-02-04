import { CButton, CFormInput, CFormTextarea, CInputGroup, CInputGroupText } from '@coreui/react'
import React, { useState } from 'react'
import { SERVER_URL } from 'src/constantURL'

export default function AddUe() {
  const [ue, setUE] = useState({
    libelle: '',
    description: '',
    module: [],
    createdAt: new Date().toISOString().split('.')[0] + 'Z',
    utilisateur: null,
    credit: '',
    coefficient: '',
    code: '',
  })

  const handleChange = (event) => {
    const { name, value } = event.target
    setUE({
      ...ue,
      [name]: value,
    })
  }

  const addUe = (uesave) => {
    fetch(SERVER_URL + 'maquette/ue', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(uesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchUE()
          alert('UE ajouter avec successful')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addUe(ue)
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
            // value={ue.code}
            name="code"
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
            // value={ue.libelle}
            name="libelle"
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
            // value={ue.credit}
            name="credit"
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
            // value={ue.coefficient}
            name="coefficient"
            onChange={handleChange}
          />
        </CInputGroup>
        <CInputGroup>
          <CInputGroupText>La description du UE</CInputGroupText>
          <CFormTextarea
            aria-label="With textarea"
            name="description"
            onChange={handleChange}
          ></CFormTextarea>
        </CInputGroup>
        <div style={{ marginTop: '20px' }}>
          <CButton color="danger" size="sm" className="me-4">
            Annuler
          </CButton>
          <CButton color="primary" size="sm" onClick={handleSave}>
            Creer un UE
          </CButton>
        </div>
      </div>
    </div>
  )
}
