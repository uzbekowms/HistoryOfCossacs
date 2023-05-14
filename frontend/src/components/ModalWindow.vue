<template>
  <div class="modal">
    <slot></slot>
  </div>
</template>

<script></script>

<style scoped>
.modal {
  display: grid;
  place-items: center;
  position: absolute;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  background-color: rgba(0, 0, 0, 0.5);
}
</style>
