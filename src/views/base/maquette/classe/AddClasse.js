import { CButton, CFormInput, CFormTextarea, CInputGroup, CInputGroupText } from '@coreui/react'
import React, { useState } from 'react'
import { SERVER_URL } from 'src/constantURL'

export default function AddClasse(props) {
  const [Classe, setClasse] = useState({
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
    const { name, valClasse } = event.target
    setClasse({
      ...Classe,
      [name]: valClasse,
    })
  }

  const addClasse = (Classesave) => {
    fetch(SERVER_URL + 'maqClassette/Classe', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(Classesave),
    })
      .then((response) => {
        if (response.ok) {
          // fetchClasse()
          alert('Classe ajouter avec successful')
        } else {
          alert('Something went wrong')
        }
      })
      .catch((err) => console.error(err))
  }

  const handleSave = () => {
    addClasse(Classe)
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
            // valClasse={Classe.code}
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
            // valClasse={Classe.libelle}
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
            // valClasse={Classe.credit}
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
            // valClasse={Classe.coefficient}
            name="coefficient"
            onChange={handleChange}
          />
        </CInputGroup>
        <CInputGroup>
          <CInputGroupText>La description du Classe</CInputGroupText>
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
            Creer un Classe
          </CButton>
        </div>
      </div>
    </div>
  )
}
