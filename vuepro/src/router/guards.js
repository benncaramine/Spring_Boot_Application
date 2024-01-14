// guards.js

import { useRouter } from 'vue-router';

export function isAuthenticated() {
  const router = useRouter();
  const isLoggedIn = localStorage.getItem('isLoggedIn'); // Vérifiez si l'utilisateur est connecté
  if (!isLoggedIn) {
    router.push('/signin'); // Rediriger vers la page de connexion si l'utilisateur n'est pas connecté
  }
}

export function isAdmin() {
  const router = useRouter();
  const role = localStorage.getItem('role'); // Récupérez le rôle de l'utilisateur depuis le local storage
  if (role !== 'admin') {
    router.push('/'); // Rediriger vers la page d'accueil si l'utilisateur n'est pas un administrateur
  }
}

