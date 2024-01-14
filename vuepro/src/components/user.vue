<!-- User.vue -->
<template>
    <tr class="users">
      <td>{{ user.id }}</td>
      <td>{{ user.nom }}</td>
      <td>{{ user.prenom }}</td>
      <td>
        <button @click="modifierUtilisateur">Modifier</button>
        <button @click="supprimerUtilisateur">Supprimer</button>
      </td>
    </tr>
  </template>
  
  <script>
  export default {
    props: {
      user: Object, // Propriété pour recevoir les données de l'utilisateur
    },
    methods: {
      modifierUtilisateur() {
        // Logique pour la modification de l'utilisateur
        console.log('Modifier l\'utilisateur avec ID', this.user.id);
      },
      supprimerUtilisateur() {
        // Logique pour la suppression de l'utilisateur
        console.log('Supprimer l\'utilisateur avec ID', this.user.id);
      },
    },
  };
  </script>
  
  <style scoped>
  /* Styles spécifiques au composant User */
  /* User.vue (styles scoped) */

/* Ajoutez des styles spécifiques au composant User ici */
tr {
  border-bottom: 1px solid #ddd;
}
.users{
  width: calc(100% - 300px);
}

td {
  padding: 10px;
}

button {
  cursor: pointer;
  padding: 5px 10px;
  margin-right: 5px;
  background-color: #3498db;
  color: #fff;
  border: none;
  border-radius: 3px;
}

button:hover {
  background-color: #2072a3;
}

  </style>
  