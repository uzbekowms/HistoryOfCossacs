import axios from "axios";

export default function commentsApi() {
  const writeComment = async (data) => {
    try {
      const response = await axios.post(
        "http://localhost:8000/api/v1/comments",
        data
      );
      console.log(response);
    } catch (err) {
      console.log(err);
    }
  };

  return { writeComment };
}
