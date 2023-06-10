<template>
  <button
    class="chat__button"
    @click="isChatVisible = !isChatVisible"
    :disabled="isChatVisible"
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
        <path
          d="M8 8H16M8 12H13M3 10C3 4.64706 5.11765 3 12 3C18.8824 3 21 4.64706 21 10C21 15.3529 18.8824 17 12 17C11.6592 17 11.3301 16.996 11.0124 16.9876L7 21V16.4939C4.0328 15.6692 3 13.7383 3 10Z"
          stroke="black"
          stroke-width="1.5"
          stroke-linecap="round"
          stroke-linejoin="round"
        ></path>
      </g>
    </svg>
  </button>
  <div class="chat__container" :class="{ visible: isChatVisible }">
    <header class="chat__header">
      <h2>Чат</h2>
      <button @click="isChatVisible = !isChatVisible" class="chat__close-btn">
        <span class="line line1"></span>
        <span class="line line2"></span>
      </button>
    </header>

    <div class="chat__messages-container">
      <div class="chat__wrapper">
        <TheMessage
          v-for="message in messages"
          :key="message"
          :message="message"
        />
      </div>
    </div>
    <div class="chat__input">
      <input
        @keyup.enter="sendMessage"
        type="text"
        class="chat__input-field"
        placeholder="Пишіть..."
        v-model="chatText"
      />
      <svg
        @click="sendMessage"
        viewBox="0 0 24 24"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
        class="chat__send-message-ico"
      >
        <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
        <g
          id="SVGRepo_tracerCarrier"
          stroke-linecap="round"
          stroke-linejoin="round"
        ></g>
        <g id="SVGRepo_iconCarrier">
          <path
            d="M20 12L4 4L6 12M20 12L4 20L6 12M20 12H6"
            stroke="#000000"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
          ></path>
        </g>
      </svg>
    </div>
  </div>
</template>

<script setup>
import { ref, defineComponent } from "vue";
import TheMessage from "./TheMessage.vue";

defineComponent(TheMessage);
let isChatVisible = ref(false);
let chatText = ref("");
let messages = ref([]);

function sendMessage() {
  if (chatText.value.trim() === "") return;
  messages.value = [
    {
      user: "Test",
      message: chatText.value.trim(),
    },
  ].concat(messages.value);
  chatText.value = "";
}
</script>

<style scoped>
.chat__header {
  position: fixed;
  top: 0;
  width: 100%;
  height: 10%;
  display: grid;
  place-items: center;
  background-color: #130e0e;
  position: absolute;
  z-index: 4;
}

.chat__wrapper {
  display: flex;
  height: fit-content;
  overflow-y: auto;
  padding-top: 3em;
  flex-direction: column-reverse;
  scroll-behavior: smooth;
  transition: all ease 0.2s;
}

.chat__wrapper::-webkit-scrollbar {
  display: none;
}

.chat__header h2 {
  font-size: 1.8rem;
}

.chat__button {
  height: 4rem;
  width: 4rem;
  position: absolute;
  right: 3rem;
  bottom: 3rem;
  border-radius: 50%;
  cursor: pointer;
  background-color: rgb(255, 255, 255);
  border: none;
  opacity: 0.5;
  transition: all 0.2s ease;
  z-index: 15;
}

.chat__button svg {
  height: 3em;
  width: 3em;
  transform: matrix(-1, 0, 0, 1, 0, 0) translateY(0.2em);
}

.chat__button path {
  transition: stroke 0.2s ease;
}

.chat__button:hover {
  background-color: var(--accent-color);
  opacity: 1;
}

.chat__button:hover path {
  stroke: white;
}

.chat__container {
  height: 0;
  width: 0;
  background-color: #fff;
  position: absolute;
  right: 4em;
  bottom: 4em;
  z-index: 16;
  opacity: 0;
  transition: all 0.2s ease;
  overflow-y: auto;
  border-radius: 5px;
}
.chat__container::-webkit-scrollbar {
  display: none;
}

.chat__button:disabled {
  opacity: 0;
  cursor: default;
}

.visible {
  height: 25em;
  width: 20em;
  opacity: 1;
}

.chat__messages-container {
  display: flex;
  flex-direction: column;
  height: 85%;
  padding: 0 0.8em;
  justify-content: end;
}

.chat__input {
  position: absolute;
  bottom: 0;
  display: flex;
  width: 100%;
  height: 13%;
  padding: 0 0.8em 0.8em 0.8em;
}

.chat__input-field {
  width: 90%;
  border: none;
  outline: none;
  font-size: 1rem;
  border-bottom: rgba(0, 0, 0, 1) solid 1px;
}

.chat__send-message-ico {
  height: 80%;
  cursor: pointer;
}

.chat__close-btn {
  position: absolute;
  right: 5px;
  top: 5px;
  height: 75%;
  width: 30px;
  background-color: transparent;
  border: none;
  cursor: pointer;
}

.line {
  display: block;
  width: 20px;
  height: 2px;
  background-color: #fff;
}

.line1 {
  transform: rotate(45deg);
}

.line2 {
  transform: rotate(-45deg);
}

@media (max-width: 500px) {
  .chat__button {
    right: 1rem;
    bottom: 1rem;
  }

  .chat__container {
    right: 2rem;
    bottom: 2rem;
  }

  .visible {
    width: 17em;
  }
}
</style>
