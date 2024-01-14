
<template>
  <Sidebar />
  <div>
    
    <div class="form-container mb-10">
      <!-- Ajout du formulaire -->
      <div class="form">
        <div class="form-group">
          <label for="abonnement_id">Abonnement_id</label>
          <input type="number" id="abonnement_id" v-model="abonnement_id" />
        </div>
        <div class="form-group">
          <label for="date_expiration">Date_expiration</label>
          <input type="date" id="date_expiration" v-model="date_expiration" />
        </div>
        <div class="form-group">
          <label for="date_inscription">date_inscription</label>
          <input type="date" id="date_inscription" v-model="date_inscription" />
        </div>
        <div class="form-buttons">
          <button @click="validerFormulaire">Ajouter</button>
        </div>
      </div>
    </div>

    <!-- Tableau des documents -->
    <div class="projects p-5 rad-10 m-20">
      <div class="one">
        <h1 class="mt-0 mb-20">Liste des Abonnements</h1>
      </div>
      <div class="">
        <table>
          <thead>
            <tr>
              <td>abonnement_id</td>
              <td>date_expiration</td>
              <td>date_inscription</td>
              <td>Actions</td>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(document, index) in abonnement" :key="index">
              <td>{{ document.abonnement_id }}</td>
              <td>{{ document.date_expiration }}</td>
              <td>{{ document.date_inscription }}</td>
              <td class="form-buttons">
                <button @click="supprimerAbonnement(index)" >Supprimer</button>
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
      abonnement_id: null,
      date_expiration: null,
      date_inscription: '',
      abonnement: [],
    };
  },
  methods: {
    validerFormulaire() {
      if (this.abonnement_id && this.date_expiration && this.date_inscription) {
        this.abonnement.push({
          abonnement_id: this.abonnement_id,
          date_expiration: this.date_expiration,
          date_inscription: this.date_inscription,
        });

        // Réinitialiser les champs du formulaire
        this.abonnement_id = '';
        this.date_expiration = null;
        this.date_inscription = '';
      }
    },
    supprimerAbonnement(index) {
      this.abonnement.splice(index, 1);
    },
  },
};

</script>

<style scoped>
.projects {
  width: calc(100% - 300px);
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

.form-buttons {
  margin-left: 10px;
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
.btn {
    margin-top: 15px;
    margin-right: 10px;
    padding: 8px 15px;
    border: none;
    border-radius: 4px;
    background-color: #22c55e;
    color: #fff;
    cursor: pointer;
    background-color: #22c55e;
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
    background-color: #ee7b00;
    color: #fff;
    cursor: pointer;
  }
  
  .form-buttons button:hover {
    background-color: #f58206;
  }
</style>
