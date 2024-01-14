import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import PrimeVue from 'primevue/config';
import 'primevue/resources/themes/lara-light-green/theme.css';
import 'primevue/resources/primevue.min.css';
//import 'primevue/primeicons.css';
import InputText from 'primevue/inputtext';
// import Button from 'primevue/button';
//caroussel files
import Carousel from 'primevue/carousel';


const app = createApp(App)
app.use(PrimeVue);
// app.component('Button', Button);
app.component('InputText',InputText);

app.use(router).mount('#app');