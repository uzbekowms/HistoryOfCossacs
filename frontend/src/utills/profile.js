import axios from "axios";
import { ref } from "vue";
import { useRouter } from "vue-router";

export default function profileApi() {
  const posts = ref([]);
  const user = ref([]);
  const router = useRouter();
  const updateUser = async (user) => {
    try {
      const response = await axios.put(
        "http://localhost:8000/api/v1/users/" + user.id,
        user
      );
      console.log(response);
    } catch (err) {
      console.log(err);
    }
    router.go();
  };

  const addPostToFav = async (userId, postId) => {
    try {
      const response = await axios.post(
        "http://localhost:8000/api/v1/favorites/" + userId + "/" + postId
      );
      console.log(response);
    } catch (err) {
      console.log(err);
    }
  };

  const getUsersPosts = async (userId) => {
    try {
      const response = await axios.get(
        "http://localhost:8000/api/v1/favorites/" + userId
      );
      posts.value = response.data;
      console.log(response);
    } catch (err) {
      console.log(err);
    }
  };

  const getUserByID = async () => {
    try {
      const id = localStorage.getItem("userId");
      const response = await axios.get(
        "http://localhost:8000/api/v1/users/" + id
      );
      user.value = response.data;
      console.log(response);
    } catch (err) {
      console.log(err);
    }
  };

  const removePostFromFav = async (userId, postId) => {
    try {
      const response = await axios.delete(
        "http://localhost:8000/api/v1/favorites/" + userId + "/" + postId
      );
      console.log(response);
    } catch (err) {
      console.log(err);
    }
    router.go();
  };

  const getUserByIDAndPosts = async () => {
    try {
      const id = localStorage.getItem("userId");
      const response = await axios.get(
        "http://localhost:8000/api/v1/users/" + id
      );
      user.value = response.data;

      const fav_response = await axios.get(
        "http://localhost:8000/api/v1/favorites/" + id
      );
      posts.value = fav_response.data;
    } catch (err) {
      console.log(err);
    }
  };

  return {
    posts,
    updateUser,
    getUsersPosts,
    user,
    getUserByID,
    getUserByIDAndPosts,
    addPostToFav,
    removePostFromFav,
  };
}
