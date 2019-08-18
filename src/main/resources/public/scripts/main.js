const api = "http://localhost:8080/guestbook";

function postEvent(){
    var formData = {};
    formData["event"] = document.getElementById("event").value;
    formData["guests"] = document.getElementById("guest").value;
    formData["place"] = document.getElementById("place").value;

    alert(JSON.stringify(formData))
    return fetch( api,{
        method: "POST",
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.JSON());
}