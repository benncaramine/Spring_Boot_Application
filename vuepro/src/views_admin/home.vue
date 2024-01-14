<template>
    <Sidebar_admin/>
    <div class="statistics">
      <topbox />
      <bookImages />
    </div>
  </template>
  
  
  
  <script>
    import Sidebar_admin from '../components/Sidebar_admin.vue'
    import topbox from '../components/topbox.vue';
    import bookImages from '../components/bookImages.vue';
  
  export default {
  components: {
    'Sidebar_admin': Sidebar_admin,
    'topbox': topbox,
    'bookImages':bookImages,
  },
  // Your page options
  };
  </script>
  
  <style>
  
  
  
  </style>
  