import { createApp } from "vue";
import router from "@/router.js";
import App from "./App.vue";
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";

const app = createApp(App);

app.use(router);
app.component(VueDatePicker);
app.mount("#app");
