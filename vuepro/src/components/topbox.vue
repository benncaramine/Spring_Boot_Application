<!-- TopBoxes.vue -->
<!-- <template> -->
    <!-- <div class="top-boxes">
      <-- Statistique 1 --
      <div class="box">
          <h5>Total Documents</h5>
          <p>{{ stat1Value }}</p>
        </div>
  
        !-- Statistique 2 
        <div class="box">
          <h2>Statistique 2</h2>
          <p>{{ stat2Value }}</p>
        </div>
  
         Statistique 3 -
        <div class="box">
          <h2>Statistique 3</h2>
          <p>{{ stat3Value }}</p>
        </div>
  
        Statistique 4 
        <div class="box">
          <h2>Statistique 4</h2>
          <p>{{ stat4Value }}</p>
        </div>
    </div> -->
    <!-- Start Ticket Widget -->
    <!--  -->
          <!-- End Ticket Widget -->
  <!-- </template> -->
  
  <!-- <script>
  export default {
    data() {
      return {
        stat1Value: 150,
        stat2Value: 30,
        stat3Value: 80,
        stat4Value: 200
        // livres: [
        //   { id: 1, titre: 'Livre 1', auteur: 'Auteur 1', image: 'photos/antigone.jpg' },
        //   { id: 2, titre: 'Livre 2', auteur: 'Auteur 2', image: 'lien_image_2.jpg' },
        //   { id: 3, titre: 'Livre 3', auteur: 'Auteur 3', image: 'lien_image_3.jpg' },
        //   { id: 4, titre: 'Livre 4', auteur: 'Auteur 4', image: 'lien_image_4.jpg' }
        // ]
      };
    }
  };

  </script> -->
  
  <!-- <style scoped> -->
  <!-- /* .top-boxes {
    /* display: flex;
    justify-content: space-around; */
    /* align-items: center; */
    /* background-color: #3498db; 
    display: flex;
    justify-content: space-between;
    color: #fff;
    padding: 20px;
    padding-bottom: 300px;
  }
  
  .box {
    width: 200px;
    height: 100px;
    background-color: #2c3e50;
    text-align: center;
    line-height: 100px;
    border-radius: 5px;
    font-size: 18px;
    margin-right: 50px;
  } */

  /* Start Tickets */
/* End Tickets */
  /* </style> */ -->
  <template>
    <div class="tickets-container tickets">
      <h2 class="tickets-heading">Statistics</h2>
      <div class="tickets-stats">
        <div class="ticket-box total box">
          <span class="stat-value">250</span>
          <span class="stat-label">Documents</span>
        </div>
        <div class="ticket-box pending box">
          <span class="stat-value">50</span>
          <span class="stat-label">Emprunt</span>
        </div>
        <div class="ticket-box closed box">
          <span class="stat-value">19</span>
          <span class="stat-label">Readers</span>
        </div>
        <div class="ticket-box deleted box">
          <span class="stat-value">15</span>
          <span class="stat-label">Rendus</span>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    // Your component logic goes here
  };
  </script>
  
   <style scoped>

   
   .tickets-container {
    padding: 20px;
    /* background-color: #ffffff; */
    border-radius: 10px;
    margin-bottom: 100px;
    width: 100%;
    margin-left: 250px;
  }
  
  .tickets-heading {
    margin-top: 0;
    margin-bottom: 10px;
  }
  
  .tickets-description {
    margin-top: 0;
    margin-bottom: 20px;
    color: #666666;
    font-size: 15px;
  }
  
  .tickets-stats {
    display: flex;
    text-align: center;
    gap: 20px;
    flex-wrap: wrap;
  }
  
  .ticket-box {
    /*padding: 20px;*/
    border-radius: 10px;
    font-size: 13px;
    color: #666666;
    justify-content: space-between;
  }
  
  .total {
    background-color: #ffcc99; /* Orange background color */
  }
  
  .pending {
    background-color: #cce5ff; /* Blue background color */
  }
  
  .closed {
    background-color: #ccffcc; /* Green background color */
  }
  
  .deleted {
    background-color: #ffc4c4; /* Red background color */
  }
  
  .icon {
    font-size: 2x;
    margin-bottom: 10px;
  }
  .tickets .box {
  border: 1px solid #ccc;
  width: calc(40% - 10px);
}
@media (max-width: 767px) {
  .tickets .box {
    width: 100%;
  }
}
  
  .rectangle-list::before {
    content: "\f12b"; /* Unicode for rectangle-list */
  }
  
  .spinner::before {
    content: "\f110"; /* Unicode for spinner */
  }
  
  circle-check::before {
    content: "\f10c"; /* Unicode for circle-check */
  }
  
  rectangle-xmark::before {
    content: "\f146"; /* Unicode for rectangle-xmark */
  }
  
  .stat-value {
    display: block;
    color: #000000;
    font-weight: bold;
    font-size: 25px;
    margin-bottom: 5px;
  }
  
  .stat-label {
    display: block;
  } 
  </style>
  