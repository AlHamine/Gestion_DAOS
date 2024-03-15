import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import Checkbox from '@mui/material/Checkbox'
import FormControlLabel from '@mui/material/FormControlLabel'
import AjouterPER from '../per/AjouterPER'
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
import AjouterVacataire from '../vacataire/AjouterVacataire'
export default function AjouterEnseignant() {
  const navigate = useNavigate()
  const label = { inputProps: { 'aria-label': 'Checkbox demoefffffffffdfd' } }
  const [choix, setChoix] = useState('') // Vrai-> PER Faux->Vacataire
  const backward = () => {
    navigate('/repartition/enseignant/Enseignant')
  }

  const handleChange = (event) => {
    const { name, checked } = event.target
    setChoix(checked ? name : '')
  }

  const valider = () => {
    if (choix == 'PER') {
      // eslint-disable-next-line prettier/prettier
      navigate('/repartition/per/AjouterPER')
    } else {
      // eslint-disable-next-line prettier/prettier
      navigate('/repartition/vacataire/AjouterVacataire')
    }
  }
  return (
    <div style={{ transform: 'scale(2.5)' }}>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <CCard>
        <CForm className="text-center" validated={true}>
          <FormControlLabel
            label="Ajouter un PER"
            control={
              <Checkbox
                {...label}
                name="PER"
                color="success"
                sx={{ '& .MuiSvgIcon-root': { fontSize: 28 } }}
                checked={choix === 'PER'}
                onChange={handleChange}
              />
            }
          />

          <FormControlLabel
            label="Ajouter un Vacataire"
            control={
              <Checkbox
                {...label}
                name="Vacataire"
                color="success"
                sx={{ '& .MuiSvgIcon-root': { fontSize: 28 } }}
                checked={choix === 'Vacataire'}
                onChange={handleChange}
              />
            }
          />
          <div>
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={valider}>
              Valider
            </CButton>
          </div>
        </CForm>
      </CCard>
    </div>
  )
}
