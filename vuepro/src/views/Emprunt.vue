<template>
  <Sidebar/>
  <div class="all">
    <!-- Tableau -->
    <div class="projects p-20  rad-10 m-20">
      <div class="one">
        <h1 class="mt-0 mb-20">Emprunts</h1>
      </div>
      <div class="">
        <table>
          <thead>
            <tr>
              <td>emprunt_id</td>
              <td>date_emprunt</td>
              <td>date_retour</td>
              <td>abonnement_id</td>
              <td>document_id</td>
              <td>Actions</td>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in items" :key="index" :class="{ 'selected-row': index === selectedIndex }">
             
              <td>{{ item.emprunt_id }}</td>
              <td>{{ item.date_emprunt }}</td>
              <td>{{ item.date_retour }}</td>
              <td>{{ item.abonnement_id }}</td>
              <td>{{ item.document_id }}</td>
              <td>
                <button @click="selectionnerLigne(index)">Sélectionner</button>
                <!-- <button @click="sauvegarderLigne(index)" :disabled="!isEditing(index)">Sauvegarder</button>
                <button @click="ajouterOuAnnuler(index)">Ajouter/Annuler</button> -->
                <button @click="supprimerLigne(index)" :disabled="selectedIndex === null">Supprimer</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <!-- Formulaire -->
    <div class="form-container">
      <div class="form-group">
      
      <div class="form">
        <div class="form-group">
        <label for="emprunt_id">Emprunt_Id</label>
        <input v-model="editedItem.emprunt_id" type="text" />
      </div>
      <div class="form-group">
        <label for="date_emprunt">D_emprunt</label>
        <input v-model="editedItem.date_emprunt" type="date" />
      </div>
      <div class="form-group">
        <label for="date_retour">D_retour</label>
        <input v-model="editedItem.date_retour" type="date">
      </div>
      <div class="form-group">
        <label for="abonnement_id">Id_abonnement</label>
        <input v-model="editedItem.abonnement_id" type="number" />
      </div>
      <div class="form-group">
        <label for="document_id">Id_document</label>
        <input v-model="editedItem.document_id" type="text" />
      </div>      
      <button @click="sauvegarderLigne()" :disabled="selectedIndex === null">Sauvegarder</button>
      <button @click="ajouterLigne()" v-show="selectedIndex === null">Ajouter</button>
    </div>
  </div>
  </div>
  </div>
</template>

<script>
import Sidebar from '../components/Sidebar.vue';
export default {
  components: {
  'Sidebar': Sidebar,
},
  data() {
    return {
      items: [
        { emprunt_id: 1, date_emprunt: '23/04/2022', date_retour: '25/04/2022', abonnement_id: 10, document_id: 5 },
        // ... Autres éléments selon vos besoins
      ],
      selectedIndex: null,
      editedItem: { emprunt_id: 0, date_emprunt: '', date_retour: '', abonnement_id: 0, document_id: 0 },
    };
  },
  methods: {
    selectionnerLigne(index) {
      this.selectedIndex = index;
      // Pré-remplir le formulaire avec les données de la ligne sélectionnée
      this.editedItem = { ...this.items[index] };
    },
    ajouterOuAnnuler(index) {
      // Ajouter une nouvelle ligne si l'index est null, sinon annuler la sélection
      if (this.selectedIndex === null) {
        this.ajouterLigne();
      } else {
        this.annulerSelection();
      }
    },
    ajouterLigne() {
      // Ajouter une nouvelle ligne
      this.items.push({ ...this.editedItem, id: this.items.length + 1 });
      // Réinitialiser la sélection et le formulaire
      this.annulerSelection();
    },
    annulerSelection() {
      this.selectedIndex = null;
      this.editedItem = { id: '', nom: '' };
    },
    supprimerLigne(index) {
      // Supprimer la ligne
      if (index !== null && index < this.items.length) {
        this.items.splice(index, 1);
        this.annulerSelection();
      }
    },
    sauvegarderLigne() {
      // Ajouter une nouvelle ligne si l'index est null
      if (this.selectedIndex === null) {
        this.ajouterLigne();
      } else {
        // Mettre à jour la ligne existante
        this.items[this.selectedIndex] = { ...this.editedItem };
        this.annulerSelection();
      }
    },
    isEditing(index) {
      return this.selectedIndex === index;
    },
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
  margin: 50px;
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
  margin-top: 15px;
  padding: 10px;
  background-color: #ee7b00;
  color: #fff;
  border: none;
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
