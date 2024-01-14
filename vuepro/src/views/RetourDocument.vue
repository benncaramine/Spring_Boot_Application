
<template>
  <Sidebar />
  <div>
    
    <div class="form-container">
      <!-- Ajout du formulaire -->
      <div class="form">
        <div class="form-group">
          <label for="idDocument">ID Document</label>
          <input type="number" id="idDocument" v-model="idDocument" />
        </div>
        <div class="form-group">
          <label for="idLecteur">ID Lecteur</label>
          <input type="number" id="idLecteur" v-model="idLecteur" />
        </div>
        <div class="form-group">
          <label for="typeDocument">Type Document</label>
          <select v-model="typeDocument" id="typeDocument" >
          <option value="CD">CD</option>
          <option value="LIVRE">Livre</option>
          <option value="MICROFILM">Microfilm</option>
          <option value="JOURNAL">Journal</option>
        </select>
        </div>
        <div class="form-buttons">
          <button @click="validerFormulaire">Ajouter</button>
        </div>
      </div>
    </div>

    <!-- Tableau des documents -->
    <div class="projects p-20  rad-10 m-20">
      <div class="one">
        <h1 class="mt-0 mb-20">Liste des Documents</h1>
      </div>
      <div class="responsive-table">
        <table>
          <thead>
            <tr>
              <td>ID Document</td>
              <td>ID Lecteur</td>
              <td>Type Document</td>
              <td>Actions</td>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(document, index) in documents" :key="index">
              <td>{{ document.idDocument }}</td>
              <td>{{ document.idLecteur }}</td>
              <td>{{ document.typeDocument }}</td>
              <td>
                <button @click="supprimerDocument(index)" class="form-buttons">Supprimer</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import Sidebar from '../components/Sidebar.vue'
  export default {
  components: {
  'Sidebar': Sidebar,
  },
  data() {
    return {
      idDocument: null,
      idLecteur: null,
      typeDocument: '',
      documents: [],
    };
  },
  methods: {
    validerFormulaire() {
      if (this.idDocument && this.idLecteur && this.typeDocument) {
        this.documents.push({
          idDocument: this.idDocument,
          idLecteur: this.idLecteur,
          typeDocument: this.typeDocument,
        });

        // Réinitialiser les champs du formulaire
        this.idDocument = null;
        this.idLecteur = null;
        this.typeDocument = '';
      }
    },
    supprimerDocument(index) {
      this.documents.splice(index, 1);
    },
  },
};

</script>

<style scoped>
.projects {
  width: calc(100% - 200px);
  margin-left: 300px;
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
  padding: 40px;
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
.form {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width:100%;
  margin-left: 300px;
  margin-top: 40px;
}

.form-group {
  margin-right: 10px;
}



/* Reste du style CSS inchangé */
.projects {
  /* width: calc(100% - 300px); */
  margin-top: 20px;
 
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
  padding: 40px;
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
.form-container {
  display: flex;
  flex-direction: column;
  gap: 20px;
  justify-content: center;
  align-items: center;
  width: (100% - 200px);
}
.form {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 5px;
  width: 670px;
  background-color: #f9f9f9;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group {
  width: calc(100% - 12px);
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.form-buttons {
  margin-top: 15px;
}
.form-buttons button {
  margin-right: 10px;
  padding: 8px 15px;
  border: none;
  border-radius: 4px;
  background-color: #22c55e;
  color: #fff;
  cursor: pointer;
}

.form-buttons button:hover {
  background-color: #22c55e;
}

</style>
