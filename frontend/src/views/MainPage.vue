<template>
  <main class="main_content">
    <h1 class="post_type__title">Історія козацтва</h1>
    <PostViewer @select-post="selectPost" />
    <TheChat />
    <ModalWindow v-show="modalIsVisible" @click="modalIsVisible = false">
      <PostPage :post="currentPost" @click.stop="" />
    </ModalWindow>
  </main>
</template>

<script setup>
import { ref } from "vue";
import PostViewer from "../components/PostViewer.vue";
import TheChat from "@/components/TheChat.vue";
import ModalWindow from "@/components/ModalWindow.vue";
import PostPage from "./PostPage.vue";

let modalIsVisible = ref(false);
let currentPost = ref();

function selectPost(post) {
  currentPost.value = post;
  modalIsVisible.value = true;
}
</script>

<style scoped>
.post_type__title {
  font-family: "Inter" serif;
  font-size: 3rem;
  transform: translateY(3vh);
  padding: 0.8em;
  z-index: 2;
  font-weight: 600;
}
.main_content {
  display: flex;
  height: 93.5%;
  flex-direction: column;
  justify-content: space-evenly;
}
</style>
