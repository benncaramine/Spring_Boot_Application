<template>
  <Sidbar_user/>
    <div class="container">
      <div class="text">
        <h1>Changer mot de passe</h1>
      </div>
      <form @submit.prevent="sauvegarderLigne">
        <div class="form-row">
          <!-- <div class="input-data">
            <input type="hidden" required>
            <div class="underline"></div>
            <label for="">Email Address</label>
          </div> -->
          <div class="input-data">
            <input type="password" v-model="old_password" required>
            <div class="underline"></div>
            <label for="">Ancien Password</label>
          </div>
        </div>
        <div class="form-row">
          <div class="input-data" :class="{ 'input-container': true, 'error': !passwordsMatch }">
            <input type="text" v-model="new_password" required @input="testerCorrespondance">
            <div class="underline"></div>
            <label for="">Nouveau Password</label>
          </div>
          <div class="input-data" :class="{ 'input-container': true, 'error': !passwordsMatch }">
            <input type="password" v-model="confirm_password" required @input="testerCorrespondance">
            <div class="underline"></div>
            <label for="">Confirm Password</label>
          </div>
        </div>
        <div class="form-row">
          <div v-if="passwordsMatch" class="message success">Les textes correspondent.</div>
          <div v-else class="message error">Les textes ne correspondent pas.</div>
        </div>
        <div class="form-row"></div>
        <div class="input-data textarea"></div>
        <div class="form-row submit-btn">
          <div class="input-data">
            <div class="inner"></div>
            <input type="submit" value="submit">
            <input type="button" value="Annuler" @click="annulerLigne">
          </div>
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import Sidbar_user from '../components/Sidebar_user.vue';
  
  export default {
    components: {
      Sidbar_user,
    },
    data() {
      return {
        old_password: '',
        new_password: '',
        confirm_password: '',
        passwordsMatch: true,
        successMessage: '',
        errorMessage: '',
      };
    },
    methods: {
  
  
   
      async sauvegarderLigne() {
    // Vérifie si les mots de passe correspondent
    if (this.new_password !== this.confirm_password) {
      this.passwordsMatch = false;
      return;
    }
  
    // Prompt the user to confirm the action
    const confirmed = window.confirm('Êtes-vous sûr de vouloir soumettre le formulaire ?');
    if (!confirmed) {
      return; // Exit the method if the user cancels
    }
  
    try {
      const token = localStorage.getItem('token');
      const config = {
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      };
      const response = await axios.post('http://localhost:8081/user/changePasswd', {
        old_password: this.old_password,
        new_password: this.new_password,
        confirm_password: this.confirm_password,
      }, config);
  
      this.successMessage = response.data;
      this.errorMessage = '';
      this.clearForm();
    } catch (error) {
      this.errorMessage = error.response.data;
      this.successMessage = '';
    }
  },
  
      annulerLigne() {
        // Réinitialisez les champs et la correspondance des mots de passe
        this.old_password = '';
        this.new_password = '';
        this.confirm_password = '';
        this.passwordsMatch = true;
      },
      testerCorrespondance() {
        this.passwordsMatch = this.new_password === this.confirm_password;
      },
      clearForm() {
        // Réinitialiser le formulaire après soumission réussie
        this.old_password = '';
        this.new_password = '';
        this.confirm_password = '';
        this.passwordsMatch = true;
      },
    },
  };
  </script>
  
  <style scoped>
    @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
  *{
    margin: 0;
    padding: 0;
    outline: none;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
  }
  template{
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    padding: 10px;
    font-family: 'Poppins', sans-serif;
    background: #ee7b00;
  }
  .container{
    max-width: 800px;
    background: #fff;
    width: 800px;
    padding: 25px 40px 10px 40px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
    /*margin: 200px;*/
    justify-content: center;
    align-items: center;
    width:100vh;
    margin-top: 50px;
    margin-left: 400px;
  }
  .container .text{
    text-align: center;
    font-size: 41px !important;
    font-weight: 600;
    font-family: 'Poppins', sans-serif;
    background: #ee7b00;
    color: white !important;
  }
  .container form{
    padding: 30px 0 0 0;
  }
  .container form .form-row{
    display: flex;
    margin: 32px 0;
  }
  form .form-row .input-data{
    width: 100%;
    height: 40px;
    margin: 0 20px;
    position: relative;
  }
  form .form-row .textarea{
    height: 70px;
  }
  .input-data input,
  .textarea textarea{
    display: block;
    width: 100%;
    height: 100%;
    border: none;
    font-size: 17px;
    border-bottom: 2px solid rgba(0,0,0, 0.12);
  }
  .input-data input:focus ~ label, .textarea textarea:focus ~ label,
  .input-data input:valid ~ label, .textarea textarea:valid ~ label{
    transform: translateY(-20px);
    font-size: 14px;
    color: #22c55e;
  }
  .textarea textarea{
    resize: none;
    padding-top: 10px;
  }
  .input-data label{
    position: absolute;
    pointer-events: none;
    bottom: 10px;
    font-size: 16px;
    transition: all 0.3s ease;
  }
  .textarea label{
    width: 100%;
    bottom: 40px;
    background: #fff;
  }
  .input-data .underline{
    position: absolute;
    bottom: 0;
    height: 2px;
    width: 100%;
  }
  .input-data .underline:before{
    position: absolute;
    content: "";
    height: 2px;
    width: 100%;
    background: #ee7b00;
    transform: scaleX(0);
    transform-origin: center;
    transition: transform 0.3s ease;
  }
  .input-data input:focus ~ .underline:before,
  .input-data input:valid ~ .underline:before,
  .textarea textarea:focus ~ .underline:before,
  .textarea textarea:valid ~ .underline:before{
    transform: scale(1);
  }
  .submit-btn .input-data{
    overflow: hidden;
    height: 45px!important;
    width: 25%!important;
  }
  .submit-btn .input-data .inner{
    height: 100%;
    width: 300%;
    position: absolute;
    left: -100%;
    background: #ee7b00;
    transition: all 0.4s;
  }
  .submit-btn .input-data:hover .inner{
    left: 0;
  }
  .submit-btn .input-data input{
    background: none;
    border: none;
    color: #fff;
    font-size: 17px;
    font-weight: 500;
    text-transform: uppercase;
    letter-spacing: 1px;
    cursor: pointer;
    position: relative;
    z-index: 2;
  }
  @media (max-width: 700px) {
    .container .text{
      font-size: 30px;
    }
    .container form{
      padding: 10px 0 0 0;
    }
    .container form .form-row{
      display: block;
    }
    form .form-row .input-data{
      margin: 35px 0!important;
    }
    .submit-btn .input-data{
      width: 40%!important;
    }
  }
  .message.success {
    color: green;
  }
  
  .message.error {
    color: red;
  }
  
  </style>