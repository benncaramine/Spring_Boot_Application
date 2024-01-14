<template>
  <Sidebar/>
  <div class="statistics">
    <topbox />
    <bookImages />
  </div>
</template>



<script>
  import Sidebar from '../components/Sidebar.vue'
  import topbox from '../components/topbox.vue';
  import bookImages from '../components/bookImages.vue';

export default {
components: {
  'Sidebar': Sidebar,
  'topbox': topbox,
  'bookImages':bookImages,
},
// Your page options
};
</script>

<style>
/* Ajoutez des styles globaux ou spécifiques à la page principale ici */



</style>
