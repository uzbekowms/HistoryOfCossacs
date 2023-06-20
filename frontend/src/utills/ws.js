import Stomp from "stompjs";
import SockJS from "sockjs-client";
import { ref } from "vue";

let stompClient;
let messages = ref([]);

const connect = () => {
  const sockJS = new SockJS("http://localhost:8000/api/v1/ws");
  stompClient = Stomp.over(sockJS);
  stompClient.connect({}, onConnected, onError);
};

const onConnected = () => {
  stompClient.subscribe("/message/chat", onMessageReceived);
};

const onMessageReceived = (msg) => {
  const response = JSON.parse(msg.body);
  messages.value = [response].concat(messages.value);
};

const onError = (err) => {
  console.log(err);
};

const sendMessage = (msg) => {
  stompClient.send("/app/chat", {}, JSON.stringify(msg));
};
connect();

export { sendMessage, messages };
