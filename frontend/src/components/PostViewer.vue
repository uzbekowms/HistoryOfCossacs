<template>
  <div class="wrapper">
    <div class="slider">
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
import ThePost from "./ThePost.vue";
</script>

<style>
.wrapper {
  height: 100%;
  width: 100%;
  overflow-x: hidden;
  overflow-y: visible;
}

.slider {
  height: 100%;
  display: flex;
  align-items: center;
  gap: 5rem;
  padding: 3rem calc(50vw - 160px);
  overflow-x: scroll;
}

.slider::-webkit-scrollbar {
  display: none;
}

.slider:nth-child(even) > .card_wrapper .post_card {
  height: 480px;
}

.slider:nth-child(even) > .card_wrapper .post_card__img {
  aspect-ratio: 1 / 1.5;
}
</style>
