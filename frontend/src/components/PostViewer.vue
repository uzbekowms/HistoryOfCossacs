<template>
  <div class="wrapper">
    <div class="slider" ref="slider">
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
import { ref, onMounted } from "vue";
import ThePost from "./ThePost.vue";

const slider = ref(null);

onMounted(() => {
  const sliderElement = slider.value;
  let isScrolling = false;

  function handleScroll(event) {
    event.preventDefault();
    if (!isScrolling) {
      isScrolling = true;
      const delta = Math.sign(event.deltaY);
      sliderElement.scrollBy({
        left: delta,
        behavior: "smooth",
      });
      setTimeout(() => {
        isScrolling = false;
      }, 500);
    }
  }

  sliderElement.addEventListener("wheel", handleScroll);
});
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
  -ms-scroll-snap-destination: 0 0;
  scroll-snap-destination: 0 0;
  -ms-scroll-snap-type: x mandatory;
  scroll-snap-type: x mandatory;
}

.slider::-webkit-scrollbar {
  display: none;
}

.slider .card_wrapper:nth-child(even) .post_card {
  height: 480px;
}

.slider .card_wrapper:nth-child(even) .post_card__img {
  aspect-ratio: 1 / 1.5;
}
.slider .card_wrapper:nth-child(even) .vertical_line {
  height: 14vh;
}
.slider .card_wrapper:nth-child(even) .date {
  top: 15vh;
}
</style>
