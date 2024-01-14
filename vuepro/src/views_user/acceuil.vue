<template>
    <SidebarUser/>
    <div class="statistics">
      <topbox />
      <bookImages />
    </div>
  </template>
  
  
  
  <script>
    import SidebarUser from '../components/Sidebar_user.vue'
    import topbox from '../components/topbox.vue';
    import bookImages from '../components/bookImages.vue';
  
  export default {
  components: {
     SidebarUser,
    'topbox': topbox,
    'bookImages':bookImages,
  },
  // Your page options
  };
  </script>
  
  <style>
  /* Ajoutez des styles globaux ou spécifiques à la page principale ici */
  body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #ecf0f1;
  }
  
  
  </style>
  