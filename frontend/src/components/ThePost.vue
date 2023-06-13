<template>
  <div class="card_wrapper">
    <div class="post_card">
      <img
        :src="
          'http://localhost:8000/api/v1/files/' + props.post?.previewImagePath
        "
        alt="Post Image"
        class="post_card__img"
      />
      <div class="post_card__text-wrapper">
        <h2 class="post_card__title">{{ props.post.title }}</h2>
        <p class="post_card__description">
          {{ props.post.description }}
        </p>
      </div>
    </div>
    <div
      class="date_separator"
      v-show="props.post.dateStart || props.post.dateEnd"
    >
      <div class="vertical_line"></div>
      <span class="date"
        >{{ formatDate(props.post.dateStart) }} —
        {{ formatDate(props.post.dateEnd) }}</span
      >
    </div>
  </div>
</template>

<script setup>
import { defineProps } from "vue";
import { formatDate } from "@/utills/formatter.js";

const props = defineProps({ post: Object });
</script>

<style scoped>
.post_card {
  position: relative;
  width: 320px;
  height: 320px;
  cursor: pointer;
  z-index: 2;
  transition: all 0.4s ease;

  scroll-snap-align: center;
  scroll-snap-stop: always;
}

.post_card__text-wrapper {
  position: absolute;
  display: flex;
  flex-direction: column;
  gap: 0.4em;
  bottom: 0.8rem;
  left: 0.8rem;
  right: 0.8rem;
  text-align: left;
  transform: translateY(1.5em);
  opacity: 0;
  transition: all 0.4s ease;
  max-height: 40%;
  overflow: hidden;
}

.post_card__title {
  font-size: 1.6rem;
  font-weight: 600;
}

.post_card__description {
  text-overflow: ellipsis;
}

.date_separator {
  display: flex;
  flex-direction: column;
  position: relative;
  align-items: center;
}

.date_separator .vertical_line {
  position: absolute;
  width: 1px;
  height: 20vh;
  background-color: #fff;
  opacity: 0.1;
  z-index: 1;
}

.date_separator .date {
  position: absolute;
  top: 21vh;
  font-size: 1.6rem;
  font-weight: 400;
  color: #999999;
}

.card_wrapper {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  transform: translateY(-10vh);
}

.post_card__img {
  object-fit: cover;
  height: 100%;
  aspect-ratio: 1 / 1;
  filter: grayscale(1) brightness(0.4);
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.post_card:hover {
  transform: scale(1.2);
}

.post_card:hover .post_card__text-wrapper {
  transform: translateY(0);
  opacity: 1;
}
</style>
