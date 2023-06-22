<template>
  <div class="favorites__container">
    <h1 class="favorites__title">Обрані пости</h1>
    <div class="favorites_posts__container">
      <div v-for="post in posts" :key="post.id">
        <PostCard
          :favorites="true"
          :post="post"
          @click="openPost(post)"
        ></PostCard>
        <div class="post-card__buttons">
          <button @click="removePostFromFav(user.id, post.id)">
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
                <path
                  d="M4 7H20"
                  stroke="#ffffff"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                ></path>
                <path
                  d="M6 7V18C6 19.6569 7.34315 21 9 21H15C16.6569 21 18 19.6569 18 18V7"
                  stroke="#ffffff"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                ></path>
                <path
                  d="M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z"
                  stroke="#ffffff"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                ></path>
              </g>
            </svg>
          </button>
        </div>
      </div>
    </div>
    <ModalWindow
      v-show="postModalIsVisible"
      @click="postModalIsVisible = false"
    >
      <PostPage
        :post="currentPost"
        @close-modal="postModalIsVisible = false"
        @click.stop=""
      />
    </ModalWindow>
  </div>
</template>

<script setup>
import { onMounted, reactive, ref } from "vue";
import profileApi from "@/utills/profile";
import PostCard from "@/components/PostCard.vue";
import ModalWindow from "@/components/ModalWindow.vue";
import PostPage from "./PostPage.vue";

const { user, getUserByIDAndPosts, posts, removePostFromFav } = profileApi();

let postModalIsVisible = ref(false);
let currentPost = reactive({
  postType: { name: null },
  dateEnd: null,
  description: null,
  title: null,
});

const openPost = (post) => {
  currentPost = post;
  postModalIsVisible.value = true;
};

onMounted(async () => {
  await getUserByIDAndPosts();
});
</script>

<style scoped>
.post-card__buttons {
  display: flex;
  gap: 0.5rem;
  width: 100%;
  align-items: center;
  justify-content: center;
}

.post-card__buttons button {
  background-color: transparent;
  border: none;
  cursor: pointer;
}
.post-card__buttons svg {
  height: 100%;
}

.post-card__buttons svg * {
  transition: all ease 0.1s;
  stroke: #888888;
}
.post-card__buttons button:hover svg * {
  stroke: white;
}
.favorites_posts__container {
  display: grid;
  gap: 40px;
  grid-template-columns: 1fr 1fr 1fr;
}
.favorites__container {
  margin: auto;
  width: 66%;
}

.favorites__title {
  font-size: 40px;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>
