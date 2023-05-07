<template>
  <header class="container">
    <button @click="menuVisible = !menuVisible" class="menu__button">
      <div class="hamburger-lines">
        <span class="line line1"></span>
        <span class="line line2"></span>
        <span class="line line3"></span>
      </div>
      <nav v-if="menuVisible" class="menu__dropdown">
        <ul>
          <li v-for="postType in postTypes" :key="postType">{{ postType }}</li>
        </ul>
      </nav>
    </button>
    <button>
      <img src="../assets/ico/pfp.png" alt="" />
    </button>
  </header>
</template>

<script>
import { ref, onMounted } from "vue";
import { getPostTypes } from "@/utills/api.js";

export default {
  setup() {
    let menuVisible = ref(false);
    let postTypes = ref([]);

    onMounted(async () => {
      postTypes = await getPostTypes();
    });

    return { menuVisible, postTypes };
  },
};
</script>

<style scoped>
button {
  background-color: transparent;
  border: none;
  cursor: pointer;
}

header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.hamburger-lines {
  display: block;
  height: 26px;
  width: 32px;
  top: 17px;
  left: 20px;
  z-index: 2;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.hamburger-lines .line {
  display: block;
  height: 4px;
  width: 100%;
  border-radius: 10px;
  background: #0e2431;
}

.hamburger-lines .line1 {
  transform-origin: 0% 0%;
  transition: transform 0.4s ease-in-out;
}

.hamburger-lines .line2 {
  transition: transform 0.2s ease-in-out;
}

.hamburger-lines .line3 {
  transform-origin: 0% 100%;
  transition: transform 0.4s ease-in-out;
}

.menu__button {
  position: relative;
}

.menu__dropdown {
  position: absolute;
  background-color: white;
}
</style>
