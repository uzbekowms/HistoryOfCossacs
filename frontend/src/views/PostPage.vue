<template>
  <div class="container">
    <div class="post__container">
      <img
        :src="
          'http://localhost:8000/api/v1/files/' + props.post?.previewImagePath
        "
        alt="Post Image"
        class="post__img"
      />
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
          {{ props.post?.description }} Lorem, ipsum dolor sit amet consectetur
          adipisicing elit. Incidunt expedita aspernatur praesentium fugiat modi
          magni, ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos. Lorem, ipsum dolor
          sit amet consectetur adipisicing elit. Incidunt expedita aspernatur
          praesentium fugiat modi magni, ratione iusto quis? Cumque
          reprehenderit corporis pariatur est aspernatur deserunt ad ipsa ullam
          sapiente quos. Lorem, ipsum dolor sit amet consectetur adipisicing
          elit. Incidunt expedita aspernatur praesentium fugiat modi magni,
          ratione iusto quis? Cumque reprehenderit corporis pariatur est
          aspernatur deserunt ad ipsa ullam sapiente quos.
        </p>
        <div class="post__comments"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { defineProps } from "vue";
import { formatDate } from "@/utills/formatter";

const props = defineProps({
  post: Object,
});
</script>

<style scoped>
.container {
  width: 100%;
  height: 90vh;
  overflow: auto;
}
.post__container {
  width: 100%;
  background-color: #1a1515;
  overflow: auto;
}
.post__img {
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
</style>
