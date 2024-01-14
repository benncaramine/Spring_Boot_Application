<template>
    <div class="statistics">
      <div class="statistic" v-for="(value, key) in stats" :key="key">
        <div class="statistic-value">{{ value }}</div>
        <div class="statistic-key">{{ key }}</div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'ItemsStatistics',
    props: {
      stats: {
        type: Object,
        required: true
      }
    }
  }
  </script>
  
  <style scoped>
  .statistics {
    display: flex;
    /* justify-content: center; */
    flex-wrap: wrap;
    align-items: center; 
    padding: 1em;
    background: #f5f5f5;
    border-radius: 8px;
    
  }
  
  .statistic {
    text-align: center;
    margin: 1em;
    border: thick double #4ade80;
    width: 200px;
  }
  
  .statistic-value {
    font-size: 2em;
    font-weight: bold;
  }
  
  .statistic-key {
    font-size: 1em;
    margin-top: 0.5em;
    text-transform: uppercase;
    color: #555;
  }
  </style>