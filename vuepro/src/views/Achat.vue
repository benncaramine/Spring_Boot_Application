<template>
  <Sidebar/>
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" >
  </head>
  <!-- <div class="form-container">
      <div class="form-group">
      <h2>Ajouter Document</h2>
      <div class="form">
        <div class="form-group">
          <label for="title">IDACHAT</label>
          <input type="number" v-model="idAchat"/>
        </div>
        <div class="form-group">
          <label for="documentType">IDDOCUMENT</label>
          <input type="number" v-model="idDocument" />
        </div>
        <div class="form-group">
          <label for="title">IDPERSONNE</label>
          <input type="number" v-model="idPersonne"/>
        </div>
        <div class="form-group">
          <label for="title">DATEACHAT</label>
          <input type="date" v-model="dateAchat"/>
        </div>
        <div class="form-group">
          <label for="title">TYPEDOCUMENT</label>
          <input type="text" v-model="typeDocument"/>
        </div>
        <div class="form-buttons">
        <button type="submit" @click="ajouterLigne">Ajouter</button>
      </div>
      </div>
      
      </div>
  </div>  -->
  <!-- Start Projects Table -->
  <div class="projects p-20  rad-10 m-20">
          <div class="one">
            <h1 class="mt-0 mb-20">DOCUMENTS</h1>
          </div>

          <div class="p-grid">
            <div class="p-col-12">
            <table class="fs-15 w-full" id="monTableau">
              <thead>
                <tr>
                  <td>IDACHAT</td>
                  <td>IDDOCUMENT</td>
                  <td>IDPERSONNE</td>
                  <td>DATEACHAT</td>
                  <td>TYPEDOCUMENT</td>
                  
                </tr>
              </thead>
              <tbody>
                <tr v-for="(document, index) in documents" :key="index">
                <td>{{ document.idAchat }}</td>
                <td>{{ document.idDocument }}</td>
                <td>{{ document.idPersonne }}</td>
                <td>{{ document.dateAchat }}</td>
                <td>{{ document.typeDocument }}</td>
              </tr>
              
          
              </tbody>
            </table>
          </div>
          </div>
        </div>
        <!-- End Projects Table -->
</template>
<script>
import Sidebar from '../components/Sidebar.vue'

export default {
components: {
  'Sidebar': Sidebar,
},
data(){
  return{
    idAchat: null,
      idDocument: null,
      idPersonne: null,
      dateAchat: null,
      typeDocument: null,
      documents: [],

  };
},
//start click
mounted() {
    // Récupérer les données depuis localStorage lors du chargement de la page
    const storedData = localStorage.getItem("documentData");
    if (storedData) {
      this.documents = JSON.parse(storedData);
    }
  },
  watch: {
    // Observer les changements dans la liste des documents et mettre à jour localStorage
    documents: {
      handler() {
        localStorage.setItem("documentData", JSON.stringify(this.documents));
      },
      deep: true,
    },
  },
methods:{
  ajouterLigne() {
      // // Récupérer les valeurs des champs de formulaire
      // var idAchat = document.getElementById("idAchat").value;
      // var idDocument = document.getElementById("idDocument").value;
      // var idPersonne = document.getElementById("idPersonne").value;
      // var dateAchat = document.getElementById("dateAchat").value;
      // var typeDocument = document.getElementById("typeDocument").value;
      // console.log("bonjour")

      // // Récupérer la référence du tableau
      // var tableau = document.getElementById("monTableau");

      // // Créer une nouvelle ligne
      // var nouvelleLigne = tableau.insertRow();

      // // Ajouter des cellules à la nouvelle ligne
      // var cellule1 = nouvelleLigne.insertCell(0);
      // var cellule2 = nouvelleLigne.insertCell(1);
      // var cellule3 = nouvelleLigne.insertCell(2);
      // var cellule4 = nouvelleLigne.insertCell(3);
      // var cellule5 = nouvelleLigne.insertCell(4);

      // // Remplir les cellules avec les valeurs du formulaire
      // cellule1.innerHTML = idAchat;
      // cellule2.innerHTML = idDocument;
      // cellule3.innerHTML = idPersonne;
      // cellule4.innerHTML = dateAchat;
      // cellule5.innerHTML = typeDocument;
      this.documents.push({
        idAchat: this.idAchat,
        idDocument: this.idDocument,
        idPersonne: this.idPersonne,
        dateAchat: this.dateAchat,
        typeDocument: this.typeDocument,
      });

      // Réinitialiser les champs du formulaire
      this.idAchat = null;
      this.idDocument = null;
      this.idPersonne = null;
      this.dateAchat = null;
      this.typeDocument = null;
    }
// end click
  }}
</script>

<style scoped>
  /* Start Projects Table */
.projects{
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
/* End Projects Table */
.one h1 {
  text-align: center;
  text-transform: uppercase;
  padding-bottom: 5px;
}
.one h1:before {
  width: 28px;
  height: 5px;
  display: block;
  content: "";
  position: absolute;
  bottom: 3px;
  left: 50%;
  margin-left: -14px;
  background-color: #b80000;
}
.one h1:after {
  width: 100px;
  height: 1px;
  display: block;
  content: "";
  position: relative;
  margin-top: 25px;
  left: 50%;
  margin-left: -50px;
  background-color: #b80000;
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
    width: 300px;
    background-color: #f9f9f9;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  .form-group label {
    display: block;
    margin-bottom: 5px;
  }
  
  .form-group input,
  .form-group select {
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
  /* h1{
    margin-left: 20px;
  } */
</style>