<template>
        <!-- <FileCard/> -->
        <Sidebar/>
        
        <div class="files-content d-grid gap-20">
            <FileCard v-for="(file, index) in files" :key="index" :file="file" />
        </div>
  </template>
  
  <script>
  import FileCard from '../components/FileCard.vue'; // Assurez-vous d'ajuster le chemin selon votre structure de projet
  import Sidebar from '../components/Sidebar.vue';
  
  export default {
    data() {
      return {
        files: [
          { name: 'my-file.pdf', icon: '../../src/assets/photos/antigone.jpg', user: 'Elzero', date: '20/06/2020', size: '5.5MB' },
          { name: 'my-file.pdf', icon: '../../src/assets/photos/antigone.jpg', user: 'Elzero', date: '20/06/2020', size: '5.5MB' },
          { name: 'my-file.pdf', icon: '../../src/assets/photos/antigone.jpg', user: 'Elzero', date: '20/06/2020', size: '5.5MB' },
          { name: 'my-file.pdf', icon: '../../src/assets/photos/antigone.jpg', user: 'Elzero', date: '20/06/2020', size: '5.5MB' },
          { name: 'my-file.pdf', icon: '../../src/assets/photos/antigone.jpg', user: 'Elzero', date: '20/06/2020', size: '5.5MB' },
          // Ajoutez d'autres fichiers avec leurs informations
        ],
      };
    },
    components: {
    Sidebar,
    FileCard,
    
},
  };
  </script>

<style>
.files-content{
    display: flex;
    margin-top: 40px;
    margin-left: 40px;
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
  