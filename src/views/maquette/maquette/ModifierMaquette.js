import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormTextarea } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierMaquette() {
  const { id } = useParams()
  const [maquette, setMaquette] = useState({})
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setMaquette({
      ...maquette,
      [name]: value,
    })
  }

  useEffect(() => {
    const getMaquette = () => {
      fetch(SERVER_URL + `maquette/maquette/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setMaquette(data)
        })
        .catch((error) => console.error('Error fetching Maquette:', error))
    }

    getMaquette()
  }, [id])

  const updateMaquette = (maquetteModifier, maquetteId) => {
    fetch(SERVER_URL + `maquette/maquette/${maquetteId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(maquetteModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/maquette/Maquette')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  const backward = () => {
    navigate('/maquette/maquette/Maquette')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification de Maquette
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        {/* <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Libelle"
            defaultValue=""
            name="libelle"
            value={maquette.libelle}
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Description"
            defaultValue=""
            name="description"
            value={maquette.description}
            onChange={handleChange}
            valid
            required
          />
        </CCol> */}

        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Credit"
            defaultValue=""
            name="credit"
            value={maquette.credit}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="CoefUe"
            defaultValue=""
            name="coefUe"
            value={maquette.coefUe}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="CM"
            defaultValue=""
            name="cm"
            value={maquette.cm}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="TD"
            defaultValue=""
            name="td"
            value={maquette.td}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="TP"
            defaultValue=""
            name="tp"
            value={maquette.tp}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Cumule"
            defaultValue=""
            name="cumule"
            value={maquette.cumule}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="TPE"
            defaultValue=""
            name="tpe"
            value={maquette.tpe}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="VH"
            defaultValue=""
            name="vh"
            value={maquette.vh}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <CCol md={4}>
          <CFormInput
            type="number"
            id="validationServer01"
            label="Coef"
            defaultValue=""
            name="coef"
            value={maquette.coef}
            onChange={handleChange}
            valid
            required
            min={0}
          />
        </CCol>
        <div className="mb-3">
          <CFormTextarea
            feedbackInvalid="SVP entrer l'intitule du maquette."
            id="validationTextarea"
            label="Entrer l'Intitule du maquette"
            placeholder="L'intitule du maquette."
            required
            name="intitule"
            value={maquette.intitule}
            onChange={handleChange}
          ></CFormTextarea>
        </div>

        <div>
          <CCol xs={12} className="d-flex justify-content-center">
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={() => updateMaquette(maquette, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
