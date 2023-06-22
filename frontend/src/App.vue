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
  --accent-color: #17bd49;
  --error-color: #f10808;
}

#app {
  font-family: "Playfair Display", serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: rgb(230, 230, 230);
  background-color: #313131;
}

html {
  height: 100vh;
  overflow: auto;
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

.primary-btn,
.secondary-btn {
  transition: all ease 0.2s;
  padding: 0.5em 2em;
}

.primary-btn {
  background-color: white;
  color: #1a1515;
}

.secondary-btn {
  background-color: transparent;
  outline: white 2px solid;
  color: white;
}

.primary-btn:hover,
.secondary-btn:hover {
  outline: none;
  background-color: var(--accent-color);
  color: white;
}

@media (max-width: 600px) {
  html {
    font-size: 14px;
  }
}

@media (max-width: 400px) {
  html {
    font-size: 12px;
  }
}
</style>
