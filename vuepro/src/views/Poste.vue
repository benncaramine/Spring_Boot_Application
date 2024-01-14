<template>
  <Sidebar />
  <div class="document-page">
    <h2 class="page-title">Post de Consultation</h2>
    <div class="document-container">
      <div v-for="(post, index) in posts" :key="index" class="document-box">
        <img
          :src="getDocumentImage(post)"
          :alt="getDocumentAlt(post)"
          class="document-image img-thumbnail col-sm-12"
        />
        <div v-if="post.document" class="document-details">
          <div class="document-name">{{ post.document.titre }}</div>
          <div class="document-type">{{ post.document.type }}</div>
          <!-- Ajoutez d'autres champs du document selon vos besoins -->
          <div class="abonnement-details">
            <div class="abonnement-date-expiration">{{ post.abonnement.date_expiration }}</div>
            <!-- Ajoutez d'autres champs de l'abonnement selon vos besoins -->
          </div>
        </div>
        <div v-else class="empty-document">No Document</div>
      </div>
    </div>
  </div>
</template>

<script>
import Sidebar from '../components/Sidebar.vue';
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
  name: 'PostConsultation',
  components: {
    Sidebar,
  },
  setup() {
    const posts = ref([]);
    const token = localStorage.getItem('token');

    const fetchPosts = async () => {
      try {
        const response = await axios.get('http://localhost:8081/posts/get', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        posts.value = response.data;
      } catch (error) {
        console.error('Error fetching posts:', error);
        // Handle error
      }
    };

    const getDocumentImage = (post) => {
  if (post.etat) {
    return post.document && post.document.image ? post.document.image : '../../src/assets/photos/poston.png';
  } else {
    return '../../src/assets/photos/poston1.png';
  }
};



    const getDocumentAlt = (post) => {
      if (post.etat && post.document) {
        return post.document.titre ? post.document.titre : 'Document Off';
      } else {
        return 'Document Off';
      }
    };

    onMounted(fetchPosts);

    return {
      posts,
      getDocumentImage,
      getDocumentAlt,
    };
  },
};
</script>



  
  <style scoped>
  .document-page {
    margin: 20px;
    width: calc(100% - 200px);
    margin-left: 200px;
  }
  
  .page-title {
    text-align: center;
    font-size: 1.5rem;
    color: #333;
  }
  
  .document-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
  }
  
  .document-box {
    width: 20%;
    margin: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  
  .document-image {
    width: 100%;
    height: auto;
    border-radius: 8px;
    
  }
  
  .document-details {
    margin-top: 10px;
    text-align: center;
  }
  
  .document-name {
    font-size: 1rem;
    font-weight: bold;
    color: #333;
  }
  
  .document-lecturer,
  .document-id {
    font-size: 0.9rem;
    color: #666;
  }
  </style>
  