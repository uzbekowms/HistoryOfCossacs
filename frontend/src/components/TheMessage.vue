<template>
  <div
    class="message__container"
    :class="{ message__owner: user?.id === props.message.sender.id }"
  >
    <svg
      class="message__avatar"
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
    <div class="message__text">
      <h3 class="message__user-nickname">
        {{ props.message?.sender.nickname }}
      </h3>
      <p class="message__user-message">
        {{ props.message?.message }}
      </p>
      <span class="message__time">{{
        formatTime(props.message?.timestamp)
      }}</span>
    </div>
  </div>
</template>

<script setup>
import { defineProps, onMounted } from "vue";
import { formatTime } from "@/utills/formatter.js";
import profileApi from "@/utills/profile";
const { user, getUserByID } = profileApi();

const props = defineProps({
  message: {
    type: Object,
    required: true,
  },
});

onMounted(async () => {
  try {
    document.querySelector(".chat__wrapper").scrollTop = 0;
  } catch (err) {
    console.log(err);
  }
  await getUserByID();
});
</script>

<style scoped>
.message__time {
  width: 100%;
  text-align: right;
  font-size: 0.8rem;
}
.message__container {
  display: flex;
  align-items: end;
  padding: 0.2em 0.2em 0.2em 0.4em;
  gap: 0.8em;
}

.message__container .message__avatar {
  height: 28px;
  width: 28px;
}

.message__text {
  font-family: "Inter";
  --message-color: #e5e5e5;
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: start;
  color: black;
  text-align: left;
  width: 75%;
  gap: 0.2rem;
  background-color: var(--message-color);
  border-radius: 10px;
  padding: 0.6em;
}

.message__text::before {
  content: "";
  position: absolute;
  width: 0px;
  height: 0px;
  border-style: solid;
  border-width: 0 0px 15px 15px;
  border-color: transparent transparent var(--message-color) transparent;
  bottom: 0;
  left: -8px;
  z-index: -1;
}

.message__user-nickname {
  font-weight: 600;
}

.message__user-message {
  word-break: break-all;
}

.message__owner {
  flex-direction: row-reverse;
  padding: 0.2em 0.4em 0.2em 0.2em;
}

.message__owner .message__text {
  --message-color: var(--accent-color);
  color: white;
}

.message__owner .message__avatar {
  display: none;
}

.message__owner .message__text::before {
  left: auto;
  right: -7px;
  border-width: 0 15px 15px 0px;
}

.message__owner .message__text .message__user-nickname {
  display: none;
}
</style>
