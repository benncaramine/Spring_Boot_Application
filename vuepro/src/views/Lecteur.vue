<template>
  <div>
    <Sidebar />
    <div class="cent">
      <div class="form-container">
        <!-- ... (le reste du formulaire reste inchangé) -->
      </div>

      <!-- Tableau des demandes en attente -->
      <!-- <div class="projects p-20 bg-white rad-10 m-20">
        <div class="one">
          <h1 class="mt-0 mb-20">Demandes en attente</h1>
        </div>
        <div class="p-grid">
          <div class="p-col-12">
            <table class="table table-striped table-bordered fs-15 w-full">
              <thead>
                <tr>
                  <th>ID Demande</th>
                  <th>Nom Complet</th>
                  <th>UserName</th>
                  <th>Email</th>
                  <th>Type</th>
                  <th>Rôle</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(demande, index) in demandesEnAttente" :key="index">
                  <td>{{ demande.id }}</td>
                  <td>{{ demande.firstname }} {{ demande.lastname }}</td>
                  <td>{{ demande.username }}</td>
                  <td>{{ demande.email }}</td>
                  <td>{{ demande.type }}</td>
                  <td>{{ demande.role }}</td>
                  <td>
                    <button @click="supprimerDemandeEnAttente(index)" class="btn btn-danger">Supprimer</button>
                    <button @click="accepterDemande(demande.id)" class="btn btn-success">Accepter</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div> -->

      <!-- Tableau des lecteurs acceptés -->
      <div class="projects p-20 rad-10 m-20">
        <div class="one">
          <h1 class="mt-0 mb-20">Liste des Lecteurs</h1>
        </div>
        <div class="p-grid">
          <div class="p-col-12">
            <table class="table table-striped table-bordered fs-15 w-full">
              <thead>
                <tr>
                  <th>ID Lecteur</th>
                  <th>Nom</th>
                  <th>Prénom</th>
                  <th>Email</th>
                  <th>Type</th>
                  <th>Rôle</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(lecteur, index) in lecteursAcceptes" :key="index">
                  <td>{{ lecteur.id }}</td>
                  <td>{{ lecteur.firstname }} {{ lecteur.lastname }}</td>
                  <td>{{ lecteur.username }}</td>
                  <td>{{ lecteur.email }}</td>
                  <td>{{ lecteur.type }}</td>
                  <td>{{ lecteur.role }}</td>
                  <td>
                    <button @click="supprimerLecteur(index)" class="btn btn-danger">Supprimer</button>
                    <button @click="modifierLecteur(index)" class="btn btn-primary">Modifier</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Sidebar from '../components/Sidebar.vue';
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
  components: {
    Sidebar,
  },
  setup() {
    const demandesEnAttente = ref([]);
    const lecteursAcceptes = ref([]);

    const supprimerDemandeEnAttente = (index) => {
      // Logique pour supprimer une demande en attente
    };

    const accepterDemande = (idDemande) => {
      const token = localStorage.getItem('token');
      const config = {
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      };
      const data = { id: idDemande };
      axios.post('http://localhost:8081/user/update', data, config)
        .then(response => {
          console.log('Demande acceptée avec succès:', response.data);
          getDemandes();
        })
        .catch(error => {
          console.error('Erreur lors de l\'acceptation de la demande:', error);
        });
    };

    const supprimerLecteur = (index) => {
      // Logique pour supprimer un lecteur accepté
    };

    const modifierLecteur = (index) => {
      // Logique pour modifier un lecteur accepté
    };

    const getDemandes = () => {
      const token = localStorage.getItem('token');
      const config = {
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      };
      axios.get('http://localhost:8081/user/getdemandes', config)
        .then(response => {
          console.log('Demandes récupérées avec succès:', response.data);
          demandesEnAttente.value = response.data;
        })
        .catch(error => {
          console.error('Erreur lors de la récupération des demandes:', error);
        });
    };

    const getLecteursAcceptes = () => {
      const token = localStorage.getItem('token');
      const config = {
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      };
      axios.get('http://localhost:8081/user/get', config)
        .then(response => {
          console.log('Lecteurs récupérés avec succès:', response.data);
          lecteursAcceptes.value = response.data;
        })
        .catch(error => {
          console.error('Erreur lors de la récupération des lecteurs:', error);
        });
    };

    onMounted(() => {
      getDemandes();
      getLecteursAcceptes();
    });

    return {
      demandesEnAttente,
      lecteursAcceptes,
      supprimerDemandeEnAttente,
      accepterDemande,
      supprimerLecteur,
      modifierLecteur
    };
  }
};
</script>



<style scoped>
.cent{
  align-items: center;
  margin-left: 300px;
  margin-top: 30px;
  
}
button{
  margin-right: 10px;
    padding: 8px 15px;
    border: none;
    border-radius: 4px;
    background-color: #ee7b00;
    color: #fff;
    cursor: pointer;
    margin-top: 15px;
    background-color: #ee7b00;
}

/* Ajoutez vos styles CSS ici */
</style>