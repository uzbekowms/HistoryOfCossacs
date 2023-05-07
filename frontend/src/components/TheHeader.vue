<template>
  <header>
    <div class="container header__container">
      <button @click="menuVisible = !menuVisible" class="menu__button">
        <div class="hamburger-lines">
          <span
            class="line line1"
            :class="{ line1__transform: menuVisible }"
          ></span>
          <span
            class="line line2"
            :class="{ line2__transform: menuVisible }"
          ></span>
          <span
            class="line line3"
            :class="{ line3__transform: menuVisible }"
          ></span>
        </div>
        <nav v-if="menuVisible" class="menu__dropdown">
          <ul class="menu__ul">
            <li
              v-for="postType in postTypes"
              :key="postType.id"
              class="menu__li"
            >
              {{ postType }}
            </li>
          </ul>
        </nav>
      </button>
      <button class="profile_button">
        <svg
          fill="#000000"
          height="800px"
          width="800px"
          version="1.1"
          id="Layer_1"
          xmlns="http://www.w3.org/2000/svg"
          xmlns:xlink="http://www.w3.org/1999/xlink"
          viewBox="0 0 512 512"
          xml:space="preserve"
        >
          <g>
            <g>
              <path
                d="M256,0C114.837,0,0,114.837,0,256s114.837,256,256,256s256-114.837,256-256S397.163,0,256,0z M256,490.667
			c-39.851,0-77.376-10.048-110.272-27.648l43.136-14.379c3.456-1.152,6.101-3.989,6.976-7.531l9.877-39.509
			c0.939-3.755-0.235-7.723-3.051-10.368c-20.245-18.987-33.643-46.827-35.84-74.453c-0.448-5.547-5.077-9.813-10.645-9.813h-3.285
			c-4.779,0-8.811-3.563-9.408-8.299l-5.035-40.299c-0.341-2.731,0.491-5.376,2.304-7.445s4.352-3.2,9.195-3.2
			c3.072,0,5.973-1.301,8-3.605c2.027-2.283,2.965-5.355,2.581-8.384c-1.301-10.325-4.672-39.232-4.672-49.045
			c0-31.125,6.123-59.115,80.107-59.861c2.176-0.021,4.331-0.704,6.101-1.984c22.357-16,46.4-18.155,66.944-18.155
			c28.096,0,47.936,8.533,58.965,25.387c13.163,20.096,7.531,30.443,1.387,36.992l-10.069,10.069
			c-1.877,1.877-2.987,4.373-3.115,7.019l-2.453,50.411c-0.149,2.901,0.896,5.717,2.88,7.829c1.984,2.091,4.736,3.328,7.637,3.349
			c2.752,0.043,5.269,1.195,7.061,3.264c1.792,2.048,2.581,4.672,2.24,7.36l-5.035,40.299c-0.597,4.736-4.629,8.299-10.389,8.299
			c-5.568,0-10.197,4.267-10.645,9.813c-2.24,28.501-16.277,56.875-37.547,75.947c-2.944,2.624-4.181,6.677-3.221,10.517
			l9.472,37.867c0.896,3.541,3.52,6.379,6.976,7.531l43.136,14.379C333.376,480.619,295.851,490.667,256,490.667z M389.909,448.427
			l-54.4-18.133l-6.528-26.133c20.523-20.437,34.581-48.363,38.848-77.077c11.499-3.392,20.352-13.333,21.909-25.749l5.035-40.299
			c1.088-8.683-1.579-17.429-7.339-24.021c-3.285-3.776-7.381-6.635-11.925-8.427l1.813-37.291l7.381-7.381
			c11.499-12.224,21.035-33.173,1.152-63.531c-15.232-23.253-41.088-35.051-76.821-35.051c-14.037,0-46.379,0-76.544,20.203
			c-86.187,1.856-97.92,41.984-97.92,81.131c0,8.96,2.155,28.949,3.584,41.301c-5.099,1.707-9.728,4.736-13.355,8.832
			c-5.845,6.613-8.576,15.445-7.488,24.213l5.035,40.299c1.664,13.269,11.648,23.701,24.299,26.347
			c4.245,27.563,17.579,54.592,36.907,74.667l-6.976,27.925l-54.507,18.176C61.269,405.973,21.333,335.616,21.333,256
			c0-129.387,105.28-234.667,234.667-234.667S490.667,126.613,490.667,256C490.667,335.616,450.731,405.995,389.909,448.427z"
              />
            </g>
          </g>
        </svg>
      </button>
    </div>
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
      postTypes.value = await getPostTypes();
      console.log(postTypes);
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
  background-color: #130e0e;
  z-index: 3;
}

.header__container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding: 0.5rem 0;
}

.profile_button svg {
  height: 45px;
  width: 45px;
  fill: white;
  transition: fill 0.1s ease-out;
}

.profile_button:hover svg {
  fill: var(--accent-color);
}

.menu__ul {
  padding: 1rem;
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
  height: 3px;
  width: 100%;
  border-radius: 10px;
  background-color: white;
  transition: background-color 0.1s ease-out, transform 0.2s ease-in-out;
}

.hamburger-lines .line1 {
  transform-origin: 0% 0%;
}

.hamburger-lines .line3 {
  transform-origin: 0% 100%;
}

.hamburger-lines:hover .line {
  background-color: var(--accent-color);
}

.line1__transform {
  transform: rotate(45deg);
}

.line2__transform {
  transform: scaleY(0);
}

.line3__transform {
  transform: rotate(-45deg);
}

.menu__button {
  position: relative;
  padding: 0.5rem 0;
}

.menu__dropdown {
  width: max-content;
  position: absolute;
  left: -1rem;
  margin-top: 0.5rem;
  background-color: #130e0e;
  z-index: 3;
}

.menu__li {
  position: relative;
  font-family: "Inter";
  text-align: left;
  font-size: 1.2rem;
  line-height: 1.5em;
  font-weight: 600;
  color: white;
  padding: 0.2em 0;
  background-image: linear-gradient(
    to right,
    var(--accent-color),
    var(--accent-color) 50%,
    white 50%
  );
  background-size: 200% 100%;
  background-position: -100%;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  transition: all 0.2s ease-out;
}
.menu__li::before {
  content: "";
  background: var(--accent-color);
  display: block;
  position: absolute;
  bottom: -3px;
  left: 0;
  width: 0;
  height: 2px;
  transition: width 0.2s ease-out;
}

.menu__li:hover {
  background-position: 0;
}
.menu__li:hover::before {
  width: 100%;
}
</style>
