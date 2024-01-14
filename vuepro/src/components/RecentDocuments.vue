<template>
    <div class="recent-documents-container">
      <h2 class="recent-documents-title">Dernières Documents Ajoutés</h2>
      <div class="recent-documents">
        <div class="document-card" v-for="document in recentDocs" :key="document.id">
          <img class="document-image" :src="document.cover" :alt="document.title" />
          <div class="document-title">{{ document.title }}</div>
          <div class="document-author">{{ document.author }}</div>
          <!-- Additional document info if needed -->
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'RecentDocuments',
    props: {
      recentDocs: {
        type: Array,
        required: true
      }
    }
  }
  </script>
  
  <style scoped>
.recent-documents-container {
  margin: 20px;
  padding: 15px;
  background: #f8f9fa;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.recent-documents-title {
  font-size: 1.5rem;
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

.recent-documents {
  display: flex;
  flex-wrap: wrap;
  gap: 15px;
  justify-content: center;
}

.document-card {
  width: calc(33.333% - 10px);
  background: #fff;
  
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.document-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.document-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.document-info {
  padding: 10px;
}

.document-title {
  font-size: 1rem;
  font-weight: bold;
  color: #333;
  margin-bottom: 5px;
}

.document-author {
  font-size: 0.85rem;
  color: #666;
}

@media (max-width: 768px) {
  .document-card {
    width: calc(50% - 10px);
  }
}

@media (max-width: 480px) {
  .document-card {
    width: 100%;
  }
}
</style>