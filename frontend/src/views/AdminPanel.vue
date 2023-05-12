<template>
  <div class="search__container">
    <div class="container">
      <nav class="search">
        <div class="search__field">
          <TheInput title="Пошук" class="search__input" id="search" />
          <button class="search__button">
            <svg
              width="64px"
              height="64px"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
              <g
                id="SVGRepo_tracerCarrier"
                stroke-linecap="round"
                stroke-linejoin="round"
              ></g>
              <g id="SVGRepo_iconCarrier">
                <g id="Interface / Search_Magnifying_Glass">
                  <path
                    id="Vector"
                    d="M15 15L21 21M10 17C6.13401 17 3 13.866 3 10C3 6.13401 6.13401 3 10 3C13.866 3 17 6.13401 17 10C17 13.866 13.866 17 10 17Z"
                    stroke="#ffffff"
                    stroke-width="2"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  ></path>
                </g>
              </g>
            </svg>
          </button>
        </div>
        <button
          class="search__add-button"
          @click="
            {
              modalWindowIsVisible = !modalWindowIsVisible;
              isPost = false;
            }
          "
        >
          <svg
            width="64px"
            height="64px"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
            <g
              id="SVGRepo_tracerCarrier"
              stroke-linecap="round"
              stroke-linejoin="round"
            ></g>
            <g id="SVGRepo_iconCarrier">
              <g id="Edit / Add_Plus_Circle">
                <path
                  id="Vector"
                  d="M8 12H12M12 12H16M12 12V16M12 12V8M12 21C7.02944 21 3 16.9706 3 12C3 7.02944 7.02944 3 12 3C16.9706 3 21 7.02944 21 12C21 16.9706 16.9706 21 12 21Z"
                  stroke="#ffffff"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                ></path>
              </g>
            </g>
          </svg>
        </button>
      </nav>
      <div class="posts__container">
        <div class="posts__wrapper">
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
          <PostCard />
        </div>
      </div>
    </div>
  </div>
  <ModalWindow
    v-show="modalWindowIsVisible"
    @click.prevent="modalWindowIsVisible = !modalWindowIsVisible"
  ></ModalWindow>
</template>

<script setup>
import { ref } from "vue";
import TheInput from "@/components/TheInput.vue";
import PostCard from "@/components/PostCard.vue";
import ModalWindow from "../components/ModalWindow.vue";

let modalWindowIsVisible = ref(false);
let isPost = ref(false);
</script>

<style scoped>
.search__container {
  width: 100%;
  margin-top: 1rem;
}
.search {
  display: flex;
  justify-content: space-between;
}
.search__field {
  display: flex;
}

.search__field svg {
  cursor: pointer;
  height: 2.5rem;
}
.search__field path {
  stroke: #888888;
}
.search__input:focus ~ .search__button svg {
  fill: var(--accent-color);
}
.search__button {
  background-color: transparent;
  border: none;
}
.posts__container {
  height: 85vh;
  padding: 2rem 1rem;
  overflow-y: scroll;
}

.posts__wrapper {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.posts__container::-webkit-scrollbar {
  display: none;
}

.search__add-button,
.search__add-button svg {
  height: 2.5rem;
  width: 2.5rem;
}
.search__add-button svg * {
  stroke: #888888;
  transition: all ease 0.1s;
}

.search__add-button:hover svg * {
  stroke: var(--accent-color);
}

.search__add-button {
  background-color: transparent;
  border: none;
  cursor: pointer;
}
</style>
