<template>
  <div class="wrapper">
    <div class="slider" v-hscroll>
      <ThePost />
      <ThePost />
      <ThePost />
      <ThePost />
      <ThePost />
      <ThePost />
      <ThePost />
    </div>
  </div>
</template>

<script setup>
import HScroll from "@koas/v-hscroll";
import ThePost from "./ThePost.vue";
</script>

<style>
.wrapper {
  height: 100%;
  width: 100%;
  padding: 3rem 0;
  overflow-x: hidden;
  overflow-y: visible;
}

.slider {
  height: 100%;
  display: flex;
  align-items: center;
  gap: 5rem;
  overflow-x: scroll;
}

.slider::-webkit-scrollbar {
  display: none;
}

.slider:nth-child(even) .post_card {
  height: 480px;
}

.slider:nth-child(even) .post_card__img {
  aspect-ratio: 1 / 1.5;
}
</style>
