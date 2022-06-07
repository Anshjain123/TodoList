const getDate=() => {
    var today = new Date();
    const options = {
        weekday: "long",
        day: "numeric",
        month: "long"
    };
    var day = today.toLocaleDateString("en-US", options);
    return day;
}
const getDay=() => {
    var today = new Date();
    const options = {
        weekday: "long"
    };
    var day = today.toLocaleDateString("en-US", options);
    return day;
}

module.exports = {getDate, getDay}; 