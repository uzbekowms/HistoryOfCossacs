const API_URL = "http://localhost:8000/api/v1";

const getPostTypes = async () => {
  let data = await fetch(`${API_URL}/post_types`).then((response) =>
    response.json()
  );
  console.log(data);
  return data;
};

export { getPostTypes };
