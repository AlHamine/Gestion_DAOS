import { CButton, CCard, CCardHeader, CCol, CForm, CFormInput, CFormSelect } from '@coreui/react'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { SERVER_URL } from 'src/constantURL'
import { useNavigate } from 'react-router-dom'

export default function ModifierEnseignement() {
  const { id } = useParams()
  const [enseignement, setEnseignement] = useState({})
  const [listModule, setListModule] = useState([])
  const [listClasse, setListClasse] = useState([])
  const [listGroupe, setListGroupe] = useState([])
  const navigate = useNavigate()

  const handleChange = (event) => {
    const { name, value } = event.target
    setEnseignement({
      ...enseignement,
      [name]: value,
    })
  }

  useEffect(() => {
    const getEnseignement = () => {
      fetch(SERVER_URL + `maquette/enseignement/${id}`)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          setEnseignement(data)
        })
        .catch((error) => console.error('Error fetching Enseignement:', error))
    }

    getEnseignement()
  }, [id])

  const updateEnseignement = (enseignementModifier, enseignementId) => {
    fetch(SERVER_URL + `maquette/enseignement/${enseignementId}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(enseignementModifier),
    })
      .then((response) => {
        if (response.ok) {
          navigate('/maquette/enseignement/Enseignement')
        } else {
          alert("Une erreur s'est produite lors de la modification.")
        }
      })
      .catch((err) => console.error(err))
  }

  useEffect(() => {
    const fetchModule = () => {
      fetch(SERVER_URL + 'maquette/module')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListModule(data)
        })
        .catch((error) => console.error('Error fetching Module:', error))
    }

    const fetchClasse = () => {
      fetch(SERVER_URL + 'maquette/classe')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListClasse(data)
        })
        .catch((error) => console.error('Error fetching Classe:', error))
    }

    const fetchGroupe = () => {
      fetch(SERVER_URL + 'maquette/groupe')
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok')
          }
          return response.json()
        })
        .then((data) => {
          data.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
          setListGroupe(data)
        })
        .catch((error) => console.error('Error fetching Groupe:', error))
    }

    fetchModule()
    fetchClasse()
    fetchGroupe()
  }, [id])

  const handleChangeModule = (event) => {
    const selectedModuleIndex = event.target.value
    const selectModule = listModule[selectedModuleIndex]
    setEnseignement({
      ...enseignement,
      module: selectModule,
    })
  }

  const handleChangeClasse = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedClasse = listClasse[selectedModuleIndex]
    setEnseignement({
      ...enseignement,
      classe: selectedClasse,
    })
  }

  const handleChangeGroupe = (event) => {
    const selectedModuleIndex = event.target.value
    const selectedGroupe = listGroupe[selectedModuleIndex]
    setEnseignement({
      ...enseignement,
      groupe: selectedGroupe,
    })
  }
  const backward = () => {
    navigate('/maquette/enseignement/Enseignement')
  }

  return (
    <div>
      <CForm className="row g-3" validated={true}>
        <CCard className="mb-4">
          <CCardHeader>
            <div>
              <strong style={{ display: 'block', textAlign: 'center' }}>
                Modification de Enseignement
              </strong>
            </div>
          </CCardHeader>
        </CCard>
        <CCol md={6}>
          <CFormInput
            type="text"
            id="validationServer01"
            label="Libelle"
            defaultValue=""
            name="libelle"
            value={enseignement.libelle}
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
            value={enseignement.description}
            onChange={handleChange}
            valid
            required
          />
        </CCol>
        <div className="mb-3">
          <CFormSelect
            label="Selection le module de cet enseignement"
            feedbackInvalid="Selection un ue valide"
            aria-label="select example"
            name="module"
            onChange={handleChangeModule}
          >
            <option selected="" value="">
              {'Nom : '} {enseignement.module && enseignement.module.nom}
            </option>
            {listModule.map((module, index) => (
              <option key={index} value={index}>
                {'Nom : '} {module && module.nom}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection la classe de cet enseignement"
            feedbackInvalid="Selection un classe valide"
            aria-label="select example"
            name="classe"
            onChange={handleChangeClasse}
          >
            <option selected="" value="">
              {'Code : '} {enseignement.classe && enseignement.classe.code} {' Libelle : '}{' '}
              {enseignement.classe && enseignement.classe.libelle}{' '}
            </option>
            {listClasse.map((classe, index) => (
              <option key={index} value={index}>
                {'Code : '} {classe.code} {' Libelle : '} {classe.libelle}{' '}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div className="mb-3">
          <CFormSelect
            label="Selection le groupe de cet enseignement"
            feedbackInvalid="Selection un groupe valide"
            aria-label="select example"
            name="groupe"
            onChange={handleChangeGroupe}
          >
            <option selected="" value="">
              {'Libelle : '} {enseignement.groupe && enseignement.groupe.libelle}
            </option>
            {listGroupe.map((groupe, index) => (
              <option key={index} value={index}>
                {'Libelle : '} {groupe.libelle}
              </option>
            ))}
          </CFormSelect>
        </div>
        <div>
          <CCol xs={12} className="d-flex justify-content-center">
            <CButton color="danger" type="submit" className="me-2" onClick={backward}>
              Retour
            </CButton>
            <CButton color="primary" onClick={() => updateEnseignement(enseignement, id)}>
              Valider
            </CButton>
          </CCol>
        </div>
      </CForm>
    </div>
  )
}
