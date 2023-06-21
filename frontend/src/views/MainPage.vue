<template>
  <main class="main_content">
    <PostViewer @selectPost="selectPost" />
    <TheChat />
    <ModalWindow v-show="modalIsVisible" @click="modalIsVisible = false">
      <PostPage :post="currentPost" @click.stop="" @close-modal="closeModal" />
    </ModalWindow>
  </main>
</template>

<script setup>
import { ref, reactive } from "vue";
import PostViewer from "../components/PostViewer.vue";
import TheChat from "@/components/TheChat.vue";
import ModalWindow from "@/components/ModalWindow.vue";
import PostPage from "./PostPage.vue";

let modalIsVisible = ref(false);
let currentPost = reactive({
  postType: { name: null },
  dateEnd: null,
  description: null,
  title: null,
});

function selectPost(post) {
  currentPost = post;
  modalIsVisible.value = true;
}

function closeModal() {
  modalIsVisible.value = false;
}
</script>

<style scoped>
.main_content {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 91%;
}
</style>
