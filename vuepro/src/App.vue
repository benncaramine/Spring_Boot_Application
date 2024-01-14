<template>
	<div class="app">
		<!-- Sidebar -->
		<!-- <Sidebar /> -->

		<!-- Content -->
		<router-view />
	</div>
</template>

<script setup>
import Sidebar from './components/Sidebar.vue'
//import  from './components/SignUp.vue'



</script>

<style lang="scss">
:root {
	--primary: #ee7b00;
	--primary-alt: #22c55e;
	--grey: #64748b;
	// --dark: #1e293b;
	--dark: #044a42;
	--dark-alt: #01352c;
	--light: #f1f5f9;
	--sidebar-width: 200px;
}

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Fira sans', sans-serif;
}

body {
	background: var(--light);
}

button {
	cursor: pointer;
	appearance: none;
	border: none;
	outline: none;
	background: none;
}

.app {
	display: flex;

	main {
		flex: 1 1 0;
		padding: 2rem;

		@media (max-width: 1024px) {
			padding-left: 6rem;
		}
	}
}
</style>