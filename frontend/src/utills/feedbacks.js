import axios from "axios";
import { ref } from "vue";

export default function feedbackApi() {
  const feedbacks = ref([]);
  const writeFeedback = async (data) => {
    try {
      const response = await axios.post(
        "http://localhost:8000/api/v1/feedbacks",
        data
      );
      console.log(response);
    } catch (err) {
      console.log(err);
    }
  };

  const getFeedbacks = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8000/api/v1/feedbacks"
      );
      feedbacks.value = response.data;
    } catch (err) {
      console.log(err);
    }
  };

  return { writeFeedback, getFeedbacks, feedbacks };
}
