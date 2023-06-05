<template>
  <TheHeader />
  <router-view />
</template>

<script setup>
import TheHeader from "@/components/TheHeader.vue";
</script>

<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  --accent-color: #3baf2a;
  --error-color: #f10808;
}

#app {
  font-family: "Playfair Display", serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: white;
  background-color: #1a1515;
}

html {
  height: 100vh;
}

::-webkit-scrollbar {
  display: none;
}

body,
#app {
  height: 100%;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 30px;
}
</style>
