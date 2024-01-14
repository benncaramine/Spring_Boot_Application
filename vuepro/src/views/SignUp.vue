<template class="sx">
    <div class="container">
      <!-- <label for="show" class="close-btn" title="close">×</label> -->
      <h1>Welcome</h1>
      <form action="#">
        <label for="emailPhone">Email or Phone</label>
        <input type="text" v-model="email" id="emailPhone" name="emailPhone">
        <label for="password">Password</label>
        <input type="password" v-modal="password" id="password" name="password">
        <a href="#">Forgot Password?</a>
        <button type="submit">Submit</button>
        <div class="link">Not a member? <a href="#">Sign up here</a></div>
      </form>
    </div>
</template>
<style>
/* h1{ color : red;} */
/* .show-btn{
    padding: 10px 20px;
    font-size: 20px;
    font-weight: 500;
    color: rgb(9, 8, 8)e;
    cursor: pointer;
    background: rgba(84, 84, 84, 0.48);
;
}
.show-btn{
    position: absolute;
    top: 45%;
    left: 30%;
    transform: translate(-50%, -50%);
} */
.sx{
    background-color: #334155;
    justify-content: center;
    align-items: center;
    display: flex;
    width: 100vh;
    background-image: url("../src/assets/photos/ooo.jpg");
}
input[type="checkbox"]{
    display: none;
}
#show:checked ~ .container{
    display: block;
}
.container{
    /* display: none; */
    width: 350px;
    padding: 20px;
    border-radius: 4px;
    background:#64748b;
;
    border: 1px solid rgba(84, 84, 84, 0.48);
;
}
.container{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%)
}
.container .close-btn{
    position: absolute;
    right: 20px;
    top: 15px;
    font-size: 25px;
    cursor: pointer;
}
.close-btn:hover{
    color: red;
}
h1{
    text-align: center;
    color: rgb(2, 2, 2);
    text-transform: uppercase;
}
form{
    margin: 20px;
}
label{
    display: block;
    color: rgb(0, 0, 0);
    font-size: 18px;
    margin-top: 10px;
}
input{
    display: block;
    width: 90%;
    background: transparent;
    border: none;
    outline: none;
    border-bottom: 1px solid white;
    padding: 10px;
    color: rgb(0, 0, 0);
}
button{
    display: block;
    width: 95%;
    padding: 8px;
    border: none;
    outline: none;
    background: #4ade80;
    color: rgb(0, 0, 0);
    font-size: 18px;
    cursor: pointer;
    margin-top: 20px;
}
a{
    text-decoration: none;
    color: #20002c;
}
.link{
    margin-top: 30px;
    text-align: center;
    color:rgb(0, 0, 0);
}
a:hover{
    text-decoration: underline;
}
</style>
<script>
// import axios from 'axios'
//     export default {
//         name : 'SignUp',
//         data(){
//             return{
//                 email:'',
//                 password:''
//             }
//         },
//         methods:{
//             async signup()
//             {
//                 let result = axios.post('path//3030/users_data',{
//                     email:this.email,
//                     password:this.password,
//                 });
//                 console.warn(result);
//                 if(result.status--201)
//                 {
//                     alert("sign uo done");
//                 }
//             }
//         }
//     }
</script>