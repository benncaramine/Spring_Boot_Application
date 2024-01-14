<template>
	<aside :class="`${is_expanded ? 'is-expanded' : ''}` ">
		<div class="logo">
		  <img :src="logoURL" alt="Vue" block="inline"/>
		  <h2  class="text">{{ username }}</h2 >
		</div>

		<h3>Menu</h3>
		<div class="menu">
			<router-link to="/user/home" class="button">
				<span class="material-icons">home</span>
				<span class="text">Accueil</span>
			</router-link>
			<router-link to="/user/biblio" class="button">
				<span class="material-icons">folder_open</span>
				<span class="text">Emprunter</span>
			</router-link>
			<router-link to="/user/achat" class="button">
				<span class="material-icons">shopping_cart</span>
				<span class="text">Acheter</span>
			</router-link>
			<router-link to="/user/consult" class="button">
				<span class="material-icons">book</span>
				<span class="text">Consulter</span>
			</router-link>
			<router-link to="/user/profil" class="button">
				<span class="material-icons">account_circle</span>
				<span class="text">Profil</span>
			</router-link>
		</div>

		<div class="flex"></div>
		
		<div class="menu">
			<router-link @click="Logout" to="/sup" class="button">
				<span class="material-icons">logout</span>
				<span class="text">Déconnexion</span>
			</router-link>
		</div>
	</aside>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router';
import logoURL from '../assets/photos/media2.png'

const router = useRouter(); // Ajout de l'import du routeur

const is_expanded = ref(localStorage.getItem("is_expanded") === "true")
const username = localStorage.getItem("username") || "Unknown User"

const ToggleMenu = () => {
  is_expanded.value = !is_expanded.value
  localStorage.setItem("is_expanded", is_expanded.value)
}

const Logout = () => {
  localStorage.removeItem("token");
  localStorage.removeItem("username");
  localStorage.removeItem("email");
  localStorage.removeItem("isLoggedIn");
  localStorage.removeItem("role");

  router.push('/');
}
</script>



<style lang="scss" scoped>
aside {
	display: flex;
	flex-direction: column;

	box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;

	background-color: var(--dark);
	color: var(--light);

	/*width: calc(2rem + 32px);*/
	width: 200px;
	overflow: hidden;
	min-height: 100vh;
	padding: 1rem;

	transition: 0.2s ease-in-out;

	.flex {
		flex: 1 1 0%;
	}

	.logo {
		margin-bottom: 1rem;
		align-items: center;

		img {
			width: 100%;
		}
	}

	.menu-toggle-wrap {
		display: flex;
		justify-content: flex-end;
		margin-bottom: 1rem;

		position: relative;
		top: 0;
		transition: 0.2s ease-in-out;

		.menu-toggle {
			transition: 0.2s ease-in-out;
			.material-icons {
				font-size: 2rem;
				color: var(--light);
				transition: 0.2s ease-out;
			}
			
			&:hover {
				.material-icons {
					color: var(--primary);
					transform: translateX(0.5rem);
				}
			}
		}
	}

	h3, .button .text {
		//opacity: 0;
		transition: opacity 0.3s ease-in-out;
	}

	h3 {
		color: var(--grey);
		font-size: 0.875rem;
		margin-bottom: 0.5rem;
		text-transform: uppercase;
	}

	.menu {
		margin: 0 -1rem;

		.button {
			display: flex;
			align-items: center;
			text-decoration: none;

			transition: 0.2s ease-in-out;
			padding: 0.5rem 1rem;

			.material-icons {
				font-size: 2rem;
				color: var(--light);
				transition: 0.2s ease-in-out;
			}
			.text {
				color: var(--light);
				transition: 0.2s ease-in-out;
			}

			&:hover {
				background-color: var(--dark-alt);

				.material-icons, .text {
					color: var(--primary);
				}
			}

			&.router-link-exact-active {
				background-color: var(--dark-alt);
				border-right: 5px solid var(--primary);

				.material-icons, .text {
					color: var(--primary);
				}
			}
		}
	}

	.footer {
		opacity: 0;
		transition: opacity 0.3s ease-in-out;

		p {
			font-size: 0.875rem;
			color: var(--grey);
		}
	}

	&.is-expanded {
		width: var(--sidebar-width);

		.menu-toggle-wrap {
			top: -3rem;
			
			.menu-toggle {
				transform: rotate(-180deg);
			}
		}

		h3, .button .text {
			opacity: 1;
		}

		.button {
			.material-icons {
				margin-right: 1rem;
			}
		}

		.footer {
			opacity: 0;
		}
	}

	@media (min-width: 1024px) {
		position: absolute;
		z-index: 99;
	}
}
/*aside {
	display: flex;
	flex-direction: column;
	box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;
	background-color: var(--dark);
	color: var(--light);
	overflow: hidden;
	min-height: 100vh;
	padding: 1rem;
	transition: 0.2s ease-in-out;
  }
  
  .logo {
	margin-bottom: 1rem;
	align-items: center;
	img {
	  width: 100%;
	}
  }
  
  .menu-toggle-wrap {
	display: flex;
	justify-content: flex-end;
	margin-bottom: 1rem;
	position: relative;
	top: 0;
	transition: 0.2s ease-in-out;
	.menu-toggle {
	  transition: 0.2s ease-in-out;
	  .material-icons {
		font-size: 2rem;
		color: var(--light);
		transition: 0.2s ease-out;
	  }
	  &:hover {
		.material-icons {
		  color: var(--primary);
		  transform: translateX(0.5rem);
		}
	  }
	}
  }
  
  h3, .button .text {
	opacity: 0;
	transition: opacity 0.3s ease-in-out;
  }
  
  h3 {
	color: var(--grey);
	font-size: 0.875rem;
	margin-bottom: 0.5rem;
	text-transform: uppercase;
  }
  
  .menu {
	margin: 0 -1rem;
	.button {
	  display: flex;
	  align-items: center;
	  text-decoration: none;
	  transition: 0.2s ease-in-out;
	  padding: 0.5rem 1rem;
	  .material-icons {
		font-size: 2rem;
		color: var(--light);
		transition: 0.2s ease-in-out;
	  }
	  .text {
		color: var(--light);
		transition: 0.2s ease-in-out;
	  }
	  &:hover {
		background-color: var(--dark-alt);
		.material-icons, .text {
		  color: var(--primary);
		}
	  }
	  &.router-link-exact-active {
		background-color: var(--dark-alt);
		border-right: 5px solid var(--primary);
		.material-icons, .text {
		  color: var(--primary);
		}
	  }
	}
  }
  
  .footer {
	opacity: 0;
	transition: opacity 0.3s ease-in-out;
	p {
	  font-size: 0.875rem;
	  color: var(--grey);
	}
  }
  
  // Styles spécifiques à la taille d'écran moyenne (MD)
  @media (min-width: 768px) {
	aside {
	  width: calc(2rem + 32px);
	  .flex {
		flex: 1 1 0%;
	  }
	  .menu-toggle-wrap {
		.menu-toggle {
		  .material-icons {
			font-size: 2rem;
		  }
		}
	  }
	  h3, .button .text {
		opacity: 0;
	  }
	  .footer {
		opacity: 0;
	  }
	  &.is-expanded {
		width: var(--sidebar-width);
		.menu-toggle-wrap {
		  top: -3rem;
		  .menu-toggle {
			transform: rotate(-180deg);
		  }
		}
		h3, .button .text {
		  opacity: 1;
		}
		.button {
		  .material-icons {
			margin-right: 1rem;
		  }
		}
		.footer {
		  opacity: 0;
		}
	  }
	}
  }
  
  // Styles spécifiques à la taille d'écran grande (LG)
  @media (min-width: 992px) {
	aside {
	  position: absolute;
	  z-index: 99;
	}
  }*/
</style>