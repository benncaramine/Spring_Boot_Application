<template>
    <!-- <Sidebar/> -->
    <div class="file-container">
      <div class="file bg-white p-10 rad-10">
        <i class="fa-solid fa-download c-grey p-absolute"></i>
        <div class="file-info">
          <div class="file-image-container">
            <img decoding="async" class="file-image" :src="file.icon" alt="" />
          </div>
          <div class="file-details">
            <!-- <div class="txt-c mb-10 fs-14">{{ file.name }}</div>
            <p class="c-grey fs-13">{{ file.user }}</p> -->
          </div>
        </div>
        <button @click="emprunter" class="emprunter-button">{{ buttonText }}</button>
      </div>
    </div>
  </template>
  
  <script>
// import Sidebar from './Sidebar.vue';



  export default {
    props: {
        file: {
            type: Object,
            required: true,
        },
        buttonText: {
            type: String,
            required: true,
        },
    },
    methods: {
        emprunter() {
            // Logique pour gérer l'emprunt du livre
            console.log('Livre emprunté :', this.file.name);
            // Vous pouvez émettre un événement ou appeler une fonction parente ici
        },
    },
    // components: { Sidebar }
};
  </script>
  
  <style scoped>
  .file-container {
    margin-bottom: 5px;
    margin-top: 20px;
    margin-left: 20px;
  }
  
  .file-info {
    /* display: flex; */
    align-items: center;
  }
  
  .file-image-container {
    width: 150px;
    height: 200px;
    overflow: hidden;
  }
  
  .file-image {
    width: 100%;
    height: auto;
  }
  
  .file-details {
    margin-left: 20px;
  }
  
  .emprunter-button {
    background-color: #ee7b00;
    color: white;
    padding: 8px 12px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.3s;
    margin-left: 20px;
    margin-top: 10px;
  }
  
  .emprunter-button:hover {
    background-color: #ae7a42;
  }
  </style>
  