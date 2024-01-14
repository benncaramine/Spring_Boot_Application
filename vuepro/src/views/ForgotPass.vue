<template>
    <div id="container">
      <div class="page front">
        <div class="content">
          <svg xmlns="http://www.w3.org/2000/svg" width="96" height="96" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-user-plus">
            <path d="M16 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"/>
            <circle cx="8.5" cy="7" r="4"/>
            <line x1="20" y1="8" x2="20" y2="14"/>
            <line x1="23" y1="11" x2="17" y2="11"/>
          </svg>
          <h1>Hello, friend!</h1>
          <p>Restaurer votre mot de passe</p>
          <router-link to="/signIn">
            <button id="register">Login
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-right-circle">
                <circle cx="12" cy="12" r="10"/>
                <polyline points="12 16 16 12 12 8"/>
                <line x1="8" y1="12" x2="16" y2="12"/>
              </svg>
            </button>
          </router-link>
        </div>
      </div>
      <div class="login">
        <div class="content">
          <h2>Restaurer votre mot de passe</h2>
          <form @submit.prevent="login">
            <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
            <input v-model="email" type="email" placeholder="Email">
            <button type="submit">Récuperer</button>
          </form>
          <span class="copy">&copy; 2024</span>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  import axios from 'axios';
  
  export default {
    // ... Autres options de composant ...
  
    setup() {
      const email = ref('');
      const password = ref('');
      const errorMessage = ref('');
  
      const login = () => {
        axios.post('http://localhost:8081/user/motDePaseeOublie', { email: email.value })
          .then(() => {
            // Authentification réussie, rediriger vers la page d'accueil
            window.location.href = '/signIn';
            clearForm();
          })
          .catch(error => {
            // Authentification échouée, afficher un message d'erreur
            console.error('Error during login:', error);
            errorMessage.value = 'ce mail n\'existe pas.';
          });
      };


      const forgotpassword = () => {
        axios.post('http://localhost:8081/user/motDePaseeOublie', { email: email.value })
          .then(() => {
            // Authentification réussie, rediriger vers la page d'accueil
            window.location.href = '/';
            clearForm();
          })
          .catch(error => {
            // Authentification échouée, afficher un message d'erreur
            console.error('Error during login:', error);
            errorMessage.value = 'Failed to login. Please check your credentials.';
          });
      };
  
      const clearForm = () => {
        email.value = '';
        password.value = '';
      };
  
      return {
        email,
        password,
        login,
        clearForm,
        errorMessage
      };
    }
  };
  </script>

<style>
    @import url("https://fonts.googleapis.com/css?family=Montserrat:400,700");

    .error-message {
        color: #ff0000; /* Rouge */
        background-color: #ffebee; /* Fond rouge clair */
        padding: 10px;
        border-radius: 5px;
        margin-top: 10px;
      }

      
      


::after,*::before{
	margin: 0;
	padding: 0;
	box-sizing: inherit;
} 
html{
	height: 100%;
 font-size: 65.2%;
	box-sizing: border-box;
	font-family: Montserrat, sans-serif;
 -webkit-font-smoothing: antialiased; 
	font-weight: 400;
}

body{
    background-image: url('../../src/assets/photos/back1.jpg');
    background-size: cover;
    background-attachment: fixed;
	height: 100%;
	color: #1d2129;
	display: flex;
	align-items: center;
	flex-direction: column;
	justify-content: center;
	perspective: 1500px;
}
h1{
		font-weight: 700;
		font-size: 3.5em;
		text-align: center;
}
.version{
	position:absolute;
	bottom: 1em;
	right: 2em;
	border-radius: 40px;
	background: #ff4b2b;
	color: #fff;
	font-size: 1em;
	font-weight: bold;
	padding: .8em 2em;
	letter-spacing: 1px;
	transition: transform 80ms ease-in;
}
form input {
    background: #eee;
    border: none;
    padding: 12px 15px;
    margin: 8px 0;
    width: 100%;
				font-size: 1.4em;
}
span{
				color: #333;
    font-size: 1.4em;
				display: inline-block;
    margin: 15px auto;
				font-weight: 100;
}
span.remember{
	float: left;
		&::before{
			content:"";
			display: inline-block;
			width: 1em;
			height: 1em;
			border: 2px solid #999;
			vertical-align: top;
			margin-right: 4px;
		}
}
span.forget{
	float: right;
}
span.clearfix{
  clear: both;
  display: table;
}

span.loginwith{ 
	display: block;
	width: 100%;
	margin-top: 1em;
	white-space: nowrap;
	overflow: hidden;
	display: flex;
	justify-content: center;
	align-items:center;
		&::before{
			content:"";
			display: inline-block;
			width: 42%; 
			height:1px;
			background: #aaa;
			vertical-align: middle;
			margin-right: 5%;
		}
		&::after{
			content:"";
			display: inline-block;
			width: 45%; 
			height: 1px;
			background: #aaa;
			vertical-align: middle;
			margin-left: 5%;
		}
}
span.copy{
	display: block;
	position: absolute;
	bottom: 0;
	font-size: 1em;
}

button {
				display: block;
				margin: 1em auto;
    border-radius: 40px;
    border: 1px solid #ff4b2b;
    background: #ff4b2b;
    color: #fff;
    font-size: 1.2em;
    font-weight: bold;
				padding: .8em 2em;
    letter-spacing: 1px;
    text-transform: uppercase;
    transition: transform 80ms ease-in;
	
				svg{
						vertical-align: middle;
				}
} 
button:hover {
    cursor:pointer;
}
button:active {
    transform: scale(.95);
}
button:focus {
    outline: none;
}



#container{
    opacity: 0.9;
	width: 95%;
	max-width: 800px;
	height: 500px;
	position: relative;
	border-radius: 20px;
	box-shadow: 0 14px 28px -10px rgba(0, 0, 0, .1), 0 10px 10px -10px rgba(0, 0, 0, .02);
	transform-style: preserve-3d;
	
	&>div{
		position: absolute;
		width: 50%;
		min-width: 350px;
		height: 100%;
		top:0;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		
	}
}

.content{
		width: 100%;
		padding: 2em 4em;
		text-align: center;
		p{
			font-size: 1.4em;
		}
}

.login{
		left:0;
		background:#FAFAFA;
		border-radius: 0px 20px 20px 0;
		button{
			border-radius: 0px;
			width: 100%;
		}
	svg{
		margin: 1em; 
		stroke: #999; 
	}
}

.register{
		right: 0;
		z-index: 1;
		border-radius: 20px 0 0 20px ;
		background:#FAFAFA;
		button{
			border-radius: 0px;
			width: 100%;
		}
		svg{
			margin: 1em; 
			stroke: #999; 
		}
}
.page{
		right:0; 
		color: #fff;
		border-radius:  20px  0 0 20px; 
		transform-origin: left center;
		transition: animation 1s linear;
	

		button{
			border-color: #fff;
			background: transparent;
		}
		p{
			margin: 2em auto;
		}
}
.front{
		background:linear-gradient(-45deg, #FFCF00 0%, #FC4F4F 100%) no-repeat 0 0 / 200%;
		z-index: 3;
	
}
.back{
		background:linear-gradient(135deg, #FC4F4F 0%, #FFCF00 100%,) no-repeat 0 0 / 200%; 
		z-index: 2;
	
		.content{
			transform: rotateY(180deg)
		}	
}

.active .front{
			animation: rot-front .6s ease-in-out normal forwards;
}
.active .back {
			animation: rot-back .6s ease-in-out normal forwards;
}

.close .front {
			animation: close-rot-front .6s ease-in-out normal forwards;
}
.close .back{ 
			animation: close-rot-back .6s ease-in-out normal forwards;
}
 
@keyframes rot-front{ 
	from{
		transform: translateZ(2px) rotateY(0deg); 
	}
	to{
		transform: translateZ(1px) rotateY(-180deg);
	}
}
@keyframes close-rot-front{ 
	from{
		transform: translateZ(1px) rotateY(-180deg); 
	}
	to{
		transform: translateZ(2px) rotateY(0deg);
	}
}
@keyframes rot-back{ 
	from{
			transform: translateZ(1px) rotateY(0deg); 
	}
	to{
		transform: translateZ(2px) rotateY(-180deg);
	}
}
@keyframes close-rot-back{ 
	from{
			transform: translateZ(2px) rotateY(-180deg); 
	}
	to{
		transform: translateZ(1px) rotateY(0deg);
	}
}



.active .register .content{
		animation: show .7s ease-in-out normal forwards
}
.close .register .content{
		animation: hide .7s ease-in-out normal forwards
}
.active .login .content{
		animation: hide .7s ease-in-out normal forwards
}
.close .login .content{
		animation: show .7s ease-in-out normal forwards
}


@keyframes show{
	from{
			opacity: 0;
			transform: scale(0.8)
	}
	to{
			opacity: .99;
			transform: scale(.99)
	}
} 
@keyframes hide{
	from{
			opacity: .99;
			transform: scale(0.99)
	}
	to{
			opacity: 0;
			transform: scale(0.8)
	}
}
</style>


  
  

  
  