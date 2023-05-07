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
}

#app {
  font-family: "Inter";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

html,
body,
#app {
  min-height: 100vh;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
}
</style>
