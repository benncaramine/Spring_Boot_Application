<template>
    <Sidebar/>
    <div class="container-fluid cx">
      <!-- Tableau -->
      <div class="projects ml-5 pl-5 rounded-10 m-4">
        <div class="row">
          <div class="col">
            <h1 class="mt-0 mb-4">Documents</h1>
          </div>
        </div>
        <div class="row">
          <div class="col">
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">IdDocument</th>
                  <th scope="col">Titre</th>
                  <th scope="col">Type</th>
                  <th scope="col">Prix</th>
                  <th scope="col">Qte</th>
                  <th scope="col">QteDispo</th>
                  <th scope="col">Consultable</th>
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
                    <td :class="{ 'text-success': item.consultable, 'text-danger': !item.consultable }">{{ item.consultable }}</td>
                    <td>
                      <button @click="consulter(item.document_id)" class="btn btn-primary">Consulter</button>
                              <!-- <button @click="supprimerLigne(index)" :disabled="selectedIndex === null" class="btn btn-danger">Supprimer</button> -->
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  
  <script>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  import Sidebar from '../components/Sidebar_user.vue';
  
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


      const consulter = (documentId) => {
  const token = localStorage.getItem('token');
  const config = {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }
  };
  const data = {
    document_id: documentId,
  };
  axios.post(`http://localhost:8081/api/consult/add`, data, config)
    .then(response => {
      // Afficher le résultat dans une alerte
      getAllDocuments(); // Mettre à jour la liste des documents après l'ajout

      alert('Document consulté avec succès: ' + response.data);
    })
    .catch(error => {
        alert('Erreur' + response.data);
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
        consulter, // Renvoyer la fonction "consulter" pour l'utiliser dans le template
      };
    },
  };
  </script>
  

  

<style scoped>
.files-content{
display: flex;
margin-top: 40px;
/*margin-left: 40px;*/
}
.files-page {
/* flex-direction: row-reverse; */
/* align-items: flex-start; */
display: flex;
}
@media (max-width: 767px) {
.files-page {
flex-direction: column;
align-items: normal;
}
}
.files-page .files-stats {
min-width: 260px;
}
.files-page .files-stats .icon {
width: 40px;
height: 40px;
margin-right: 10px;
}
.files-page .files-stats .size {
margin-left: auto;
}
.files-page .files-stats .blue {
background-color: rgb(0 117 255 / 20%);
}
.files-page .files-stats .green {
background-color: rgb(34 197 94 / 20%);
}
.files-page .files-stats .red {
background-color: rgb(244 67 54 / 20%);
}
.files-page .files-stats .orange {
background-color: rgb(245 158 11 / 20%);
}
.files-page .files-stats .upload {
margin: 15px auto 0;
padding: 10px 15px;
transition: 0.3s;
}
.cx{
    margin-left: 200px;
}
.files-page .files-stats .upload:hover {
background-color: var(--blue-alt-color);
}
.files-page .files-stats .upload:hover i {
animation: go-up 0.8s infinite;
}
.files-page .files-content {
flex: 1;
grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
}
.files-page .files-content img {
width: 64px;
height: 64px;
transition: 0.3s;
}
.files-page .files-content .file:hover img {
transform: rotate(5deg);
}
.files-page .files-content .info {
border-top: 1px solid #eee;
}
/* End Files Page */
</style>
