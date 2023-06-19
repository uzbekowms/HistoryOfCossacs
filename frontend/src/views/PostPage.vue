<template>
  <div class="container">
    <div class="post__container">
      <video
        controls
        class="post__vid"
        :src="
          'http://localhost:8000/api/v1/files/' + props.post.previewImagePath
        "
        v-if="post.postType.name === 'Відеоматеріали'"
      ></video
      ><audio
        class="post__audio"
        v-else-if="post.postType.name === 'Аудіоматеріали'"
        controls
        :src="
          'http://localhost:8000/api/v1/files/' + props.post.previewImagePath
        "
        alt=""
        srcset=""
      ></audio>
      <img
        v-else
        :src="
          'http://localhost:8000/api/v1/files/' + props.post?.previewImagePath
        "
        alt="Post Image"
        class="post__img"
      />
      <button class="post__close-btn" @click="emit('closeModal')"></button>
      <div class="post__body">
        <h2 class="post__title">
          {{ props.post?.title }}
          <span
            class="post__dates"
            v-show="props.post?.dateStart || props.post?.dateEnd"
          >
            ({{ formatDate(props.post?.dateStart) }} —
            {{ formatDate(props.post?.dateEnd) }})</span
          >
        </h2>
        <p class="post__description">
          {{ props.post?.description }}
        </p>
        <div class="post__comments"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { defineProps, defineEmits } from "vue";
import { formatDate } from "@/utills/formatter";

const props = defineProps({
  post: Object,
});

const emit = defineEmits(["closeModal"]);
</script>

<style scoped>
.container {
  width: 100%;
  height: 90vh;
  overflow: auto;
}
.post__container {
  position: relative;
  width: 100%;
  background-color: #1a1515;
  overflow: auto;
}
.post__vid {
  width: 100%;
  margin: 0 auto;
}
.post__img,
.post__vid {
  width: 100%;
  height: 40vh;
  object-fit: cover;
}
.post__body {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  text-align: left;
  padding: 1.5rem;
}

.post__title {
  font-size: 2.5rem;
  font-weight: 600;
}

.post__dates {
  font-size: 0.8em;
  font-weight: 400;
}

.post__description {
  line-height: 1.4rem;
}

.post__close-btn {
  position: absolute;
  top: 0rem;
  right: 0rem;
  border: none;
}

.post__close-btn::after {
  position: absolute;
  font-size: 4rem;
  right: 0;
  top: 0;
  content: "\00d7";
  color: var(--accent-color);
  padding: 0 1rem;
  transition: all ease 0.2s;
  cursor: pointer;
}

.post__close-btn:hover::after {
  background-color: rgba(0, 0, 0, 0.2);
  color: #fff;
}
</style>
