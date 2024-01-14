<template>
  <Sidebar/>
  <div class="container-fluid">
    <!-- Tableau -->
    <div class="projects mt-5">
      <div class="one">
        <h1 class="mt-0 mb-4">Documents</h1>
      </div>
      <div class="table-responsive">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">IdDocument</th>
              <th scope="col">Titre</th>
              <th scope="col">Type</th>
              <th scope="col">Prix</th>
              <th scope="col">Qte</th>
              <th scope="col">QteDispo</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in items" :key="index" :class="{ 'table-active': index === selectedIndex }">
              <td>{{ item.document_id }}</td>
              <td>{{ item.titre }}</td>
              <td>{{ item.type }}</td>
              <td>{{ item.prix }}</td>
              <td>{{ item.quantite }}</td>
              <td>{{ item.quantite_disponible }}</td>
              <td>
                <button @click="selectionnerLigne(index)" class="btn btn-primary">Sélectionner</button>
                <!-- <button @click="supprimerLigne(index)" :disabled="selectedIndex === null" class="btn btn-danger">Supprimer</button> -->
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <!-- Formulaire -->
    <div class="form-container mt-5">
      <div class="form">
        <div class="form-group">
          <label for="titre">Titre</label>
          <input v-model="editedItem.titre" type="text" class="form-control" />
        </div>
        <div class="form-group">
          <label for="type">Type</label>
          <select v-model="editedItem.type" class="form-control">
            <option value="cd">CD</option>
            <option value="livre">Livre</option>
            <option value="microfilm">Microfilm</option>
            <option value="journal">Journal</option>
          </select>
        </div>
        <div class="form-group" v-if="editedItem.type === 'livre'">
          <label for="auteur">Auteur</label>
          <input v-model="editedItem.auteur" type="text" class="form-control" />
        </div>
        <div class="form-group">
          <label for="prix">Prix</label>
          <input v-model="editedItem.prix" type="text" class="form-control" />
        </div>
        <div class="form-group">
          <label for="qte">Qte</label>
          <input v-model="editedItem.quantite" type="text" class="form-control" />
        </div>
        <div class="form-group">
          <label for="qtedispo">QteDispo</label>
          <input v-model="editedItem.quantite_disponible" type="text" class="form-control" />
        </div>
        <button @click="sauvegarderLigne()" :disabled="selectedIndex === null" class="btn btn-primary">Sauvegarder</button>
        <button @click="ajouterLigne()" v-show="selectedIndex === null" class="btn btn-success">Ajouter</button>
      </div>
    </div>
  </div>
</template>


<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import Sidebar from '../components/Sidebar.vue';

export default {
  components: {
    Sidebar,
  },
  setup() {
    const items = ref([]);
    const selectedIndex = ref(null);
    const editedItem = ref({ id: '', titre: '', type: 'CD', prix: 0, quantite: 0, quantite_disponible: 0 });

    const selectionnerLigne = (index) => {
      selectedIndex.value = index;
      editedItem.value = { ...items.value[index] };
    };

    const clearForm = () => {
      editedItem.value = { id: '', titre: '', type: 'CD', prix: 0, quantite: 0, quantite_disponible: 0 };
    };

    const ajouterLigne = () => {
      const token = localStorage.getItem('token');
      const config = {
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      };
      const data = {
        auteur: editedItem.value.auteur,
        document: {
          titre: editedItem.value.titre,
          type: editedItem.value.type,
          quantite: editedItem.value.quantite,
          prix: editedItem.value.prix,
          quantite_disponible: editedItem.value.quantite_disponible
        }
      };
      axios.post(`http://localhost:8081/Mediatheque/${editedItem.value.type}/save`, data, config)
        .then(response => {
          console.log('Document ajouté avec succès:', response.data);
          clearForm();
          getAllDocuments(); // Mettre à jour la liste des documents après l'ajout
        })
        .catch(error => {
          console.error('Erreur lors de l\'ajout du document:', error);
        });
    };

    const sauvegarderLigne = () => {
      // ... (code de sauvegarde de ligne)
    };

    const supprimerLigne = (index) => {
      // ... (code de suppression de ligne)
    };

    const getAllDocuments = () => {
      const token = localStorage.getItem('token');
      const config = {
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      };
      axios.get('http://localhost:8081/Mediatheque/Document/getAllDocuments', config)
        .then(response => {
          console.log('Documents récupérés avec succès:', response.data);
          items.value = response.data;
        })
        .catch(error => {
          console.error('Erreur lors de la récupération des documents:', error);
        });
    };

    // Appeler la fonction getAllDocuments au chargement du composant
    onMounted(getAllDocuments);

    return {
      items,
      selectedIndex,
      editedItem,
      selectionnerLigne,
      ajouterLigne,
      sauvegarderLigne,
      supprimerLigne,
    };
  },
};
</script>




<style scoped>
.projects {
  width: calc(100% - 200px);
  margin-left: 200px;
}
.projects .responsive-table {
  overflow-x: auto;
}
.projects table {
  min-width: none;
  border-spacing: 0;
}
.projects thead td {
  background-color: #eee;
  font-weight: bold;
}
.projects table td {
  padding: 15px;
}
.projects tbody td {
  border-bottom: 1px solid #eee;
  border-left: 1px solid #eee;
  transition: 0.3s;
}
.projects table tbody tr td:last-child {
  border-right: 1px solid #eee;
}
.projects tbody tr:hover td {
  background-color: #faf7f7;
}
.projects table img {
  width: 32px;
  height: 32px;
  border-radius: 50%;
  padding: 2px;
  background-color: white;
}
.projects table img:not(:first-child) {
  margin-left: -20px;
}
.projects table .label {
  font-size: 13px;
}

.selected-row {
  background-color: #cce5ff; /* Couleur de fond pour la ligne sélectionnée */
}
.all{
  margin-left: 200px;
}
/* Start Formulaire horizental */
.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  max-width: 600px;
  width: 100%;
  box-shadow: #cce5ff;
  margin-left: 200px;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group input {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}

button {
  margin: 4px;
  padding: 5px;
  background-color: #ee7b00;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
.mt-0{
  margin-left: 30px;
}
/* Start Formulaire horizental */
</style>
