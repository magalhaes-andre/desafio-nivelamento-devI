const api = "http://localhost:8080/guestbook";
let guests = [];

function readFormData(){
    var data = {};
    data["event"] = document.getElementById("event").value;
    data["guests"] = guests;
    data["place"] = document.getElementById("place").value;
    console.log(data);
    return data;
}

function showGuests(){
    let tableBuilder = "";
    guests.forEach(guest => {
        tableBuilder += '<li>'+guest.name+'</li>'
    })
    document.getElementById("guestList").innerHTML = tableBuilder;
}

function postEvent(){
    var formData = readFormData();
    return fetch( api,{
        method: "POST",
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json());
}

function addGuest(){
    if(guestIsPresent()){
        alert("Already have this guest on the list ;)")
    }else{
        guests.push({name:getGuest()})
    }
    showGuests()
}

function guestIsPresent(){
    isPresent = false;
    guests.forEach(guest => {
        if (guest.name == getGuest()){
            isPresent = true;
        }
    })
    return isPresent;
}

function getGuest(){
    return document.getElementById("guest").value
}