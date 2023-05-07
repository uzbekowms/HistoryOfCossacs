<template>
  <main class="main_content">
    <h1 class="post_type__title">Історія козацтва</h1>
    <PostViewer />
  </main>
</template>

<script setup>
import PostViewer from "../components/PostViewer.vue";
</script>

<style scoped>
.post_type__title {
  font-size: 3rem;
}
.main_content {
  display: flex;
  height: 93.5%;
  flex-direction: column;
  justify-content: space-evenly;
}
</style>
