const formatDate = (date) => {
  if (!date) return "";

  date = new Date(date);
  const options = { year: "numeric", month: "numeric", day: "numeric" };
  const customFormattedDate = date.toLocaleString("uk-UA", options);
  return customFormattedDate;
};

const formatTime = (date) => {
  if (!date) return "";

  date = new Date(date);
  const options = { hour: "numeric", minute: "numeric" };
  const formattedTime = date.toLocaleString("uk-UA", options);
  return formattedTime;
};

export { formatDate, formatTime };
