<!-- BookImages.vue -->
<template>
    <h2 class="title">Documents Publiés Récemment</h2>
    <div class="book-images">
        
      <img src="../../src/assets/photos/image2.jpg" alt="Book 1">
      <img src="../../src/assets/photos/image3.jpg" alt="Book 2">
      <img src="../../src/assets/photos/image4.jpg" alt="Book 3">
      <img src="../../src/assets/photos/image5.jpg" alt="Book 4">
      <img src="../../src/assets/photos/image5.jpg" alt="Book 4">
      <img src="../../src/assets/photos/image5.jpg" alt="Book 4">
      
    </div>
  </template>
  
  <script>
  export default {
    // Composant des images de livres en bas de la page
  };
  </script>
  
  <style scoped>
  .book-images {
    display: flex;
    justify-content: space-around;
    align-items: center;
    margin-top: 20px;
    margin-left: 250px;
  }
  .title{
    margin-left: 250px;
  }
  
  img {
    width: 150px;
    height: 200px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    margin: 5px;
    justify-content: space-between;
  }
  h2{
    padding-left: 20px;
  } 
  </style>
  