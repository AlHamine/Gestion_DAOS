import { CButton, CFormInput, CFormTextarea, CInputGroup, CInputGroupText } from '@coreui/react'
import React, { useState } from 'react'
import { SERVER_URL } from 'src/constantURL'

export default function EditUe() {
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

  // const addUe = (uesave) => {
  //   fetch(SERVER_URL + 'maquette/ue', {
  //     method: 'POST',
  //     headers: { 'Content-Type': 'application/json' },
  //     body: JSON.stringify(uesave),
  //   })
  //     .then((response) => {
  //       if (response.ok) {
  //         // fetchUE()
  //         alert('UE ajouter avec successful')
  //       } else {
  //         alert('Something went wrong')
  //       }
  //     })
  //     .catch((err) => console.error(err))
  // }

  const updateUE = (ueModifier, ueId) => {
    console.log('UE DESC = ' + ueModifier.description + ' ID = ' + ueId)
    fetch(SERVER_URL + `maquette/ue/${ueId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ueModifier),
    })
      .then((response) => {
        if (response.ok) {
          alert('UE mofifier')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  // const handleSave = () => {
  //   updateUE(ue)
  // }

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
          <CButton color="primary" size="sm" onClick={() => updateUE(ue, 1)}>
            Modifier UE
          </CButton>
        </div>
      </div>
    </div>
  )
}
