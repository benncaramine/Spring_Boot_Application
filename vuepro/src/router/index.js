import { createRouter, createWebHistory} from 'vue-router'
import { isAuthenticated, isAdmin } from './guards'; // Importez vos fonctions de guard depuis un fichier séparé
//import Home from '../views/Home.vue'


const router = createRouter({
  history: createWebHistory(),
  routes:[
    {
      path:'/',
      component: ()=>import('../views/newSignIn.vue')
    },
    {
      path:'/admin/',
      component: ()=>import('../views/newSignIn.vue')
    },
    {
      path:'/user/',
      component: ()=>import('../views/newSignIn.vue')
    },
    {
      path:'/employe/',
      component: ()=>import('../views/newSignIn.vue'),
    },
    {
      path:'/employe/home',
      component: ()=>import('../views/Home.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/user/home',
      component: ()=>import('../views_user/acceuil.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/sup',
      component: ()=>import('../views/SignUp.vue')
    },
    {
      path:'/employe/doc',
      component: ()=>import('../views/Documents.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/achat',
      component: ()=>import('../views/Achat.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/user/achat',
      component: ()=>import('../views_user/AchatDoc.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/employe/abonnement',
      component: ()=>import('../views/Abonnement.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/employe/emprunt',
      component: ()=>import('../views/Emprunt.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/employe/lecteur',
      component: ()=>import('../views/Lecteur.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/user/biblio',
      component: ()=>import('../views_user/biblio.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/employe/postinfo',
      component: ()=>import('../views/Poste.vue'),
      meta: { requiresAuth: true }
    },
    
    {
      path:'/employe/profil',
      component: ()=>import('../views/Profil.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/user/profil',
      component: ()=>import('../views_user/Profil.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/user/consult',
      component: ()=>import('../views_user/consult.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/employe/retour',
      component: ()=>import('../views/RetourDocument.vue'),
      meta: { requiresAuth: true }
    },
    // {
    //   path:'/signin',
    //   component: ()=>import('../views/SignIn.vue')
    // },
    {
      path:'/forgotpass',
      component: ()=>import('../views/ForgotPass.vue'),
    },
    {
      path:'/aliii',
      component: ()=>import('../views/SigninAli.vue')
    },
    {
      path:'/test',
      component: ()=>import('../views/test.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/signIn',
      component: ()=>import('../views/newSignIn.vue')
    },
    {
      path:'/signUp',
      component: ()=>import('../views/newSignUp.vue')
    },
    {
      path:'/admin/home',
      component: ()=>import('../views_admin/home.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/admin/lecteur',
      component: ()=>import('../views_admin/LecteurA.vue'),
      meta: { requiresAuth: true }
    },
    {
      path:'/admin/profil',
      component: ()=>import('../views_admin/ProfilA.vue'),
      meta: { requiresAuth: true }
    },
    
  ]
})
// Utilisez les fonctions de garde dans vos routes
router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth) {
    isAuthenticated(); // Vérifie si l'utilisateur est connecté
  }
  if (to.meta.requiresAdmin) {
    isAdmin(); // Vérifie si l'utilisateur est un administrateur
  }
  next();
});

export default router;