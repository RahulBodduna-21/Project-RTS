// ===== TRAIN DATABASE (acts like backend) =====

const trains = [

{ name:"Godavari Express", source:"Hyderabad", dest:"Vizag", depart:"06:00", arrive:"14:00",
  classes:{Sleeper:350,"2S":180,AC:900}},

{ name:"Charminar Express", source:"Hyderabad", dest:"Chennai", depart:"08:00", arrive:"17:00",
  classes:{Sleeper:400,"2S":200,AC:950}},

{ name:"Simhapuri Express", source:"Nellore", dest:"Hyderabad", depart:"09:00", arrive:"19:00",
  classes:{Sleeper:370,"2S":190,AC:880}},

{ name:"East Coast", source:"Vizag", dest:"Chennai", depart:"05:30", arrive:"12:30",
  classes:{Sleeper:330,"2S":170,AC:850}},

{ name:"Janmabhoomi", source:"Vizag", dest:"Vijayawada", depart:"07:00", arrive:"11:00",
  classes:{Sleeper:220,"2S":120,AC:500}},

{ name:"Krishna Express", source:"Hyderabad", dest:"Vijayawada", depart:"06:30", arrive:"12:00",
  classes:{Sleeper:300,"2S":150,AC:700}},

{ name:"Rayalaseema", source:"Tirupati", dest:"Hyderabad", depart:"10:00", arrive:"20:00",
  classes:{Sleeper:420,"2S":210,AC:950}},

{ name:"Venkatadri", source:"Kurnool", dest:"Hyderabad", depart:"11:00", arrive:"15:00",
  classes:{Sleeper:240,"2S":130,AC:600}},

{ name:"Intercity 1", source:"Hyderabad", dest:"Vizag", depart:"13:00", arrive:"21:00",
  classes:{Sleeper:360,"2S":180,AC:920}},

{ name:"Intercity 2", source:"Vizag", dest:"Hyderabad", depart:"14:00", arrive:"22:00",
  classes:{Sleeper:360,"2S":180,AC:920}},

// add more to reach 20
{ name:"Express A", source:"Hyderabad", dest:"Chennai", depart:"15:00", arrive:"23:00",
  classes:{Sleeper:390,"2S":200,AC:910}},
{ name:"Express B", source:"Chennai", dest:"Hyderabad", depart:"16:00", arrive:"02:00",
  classes:{Sleeper:390,"2S":200,AC:910}},
{ name:"Express C", source:"Vizag", dest:"Hyderabad", depart:"17:00", arrive:"01:00",
  classes:{Sleeper:360,"2S":180,AC:920}},
{ name:"Express D", source:"Hyderabad", dest:"Vizag", depart:"18:00", arrive:"02:00",
  classes:{Sleeper:360,"2S":180,AC:920}},
{ name:"Express E", source:"Tirupati", dest:"Chennai", depart:"05:00", arrive:"09:00",
  classes:{Sleeper:210,"2S":110,AC:500}},
{ name:"Express F", source:"Chennai", dest:"Tirupati", depart:"19:00", arrive:"23:00",
  classes:{Sleeper:210,"2S":110,AC:500}},
{ name:"Express G", source:"Kurnool", dest:"Vizag", depart:"07:00", arrive:"19:00",
  classes:{Sleeper:430,"2S":220,AC:990}},
{ name:"Express H", source:"Vizag", dest:"Kurnool", depart:"12:00", arrive:"23:00",
  classes:{Sleeper:430,"2S":220,AC:990}},
{ name:"Express I", source:"Vijayawada", dest:"Hyderabad", depart:"09:00", arrive:"14:00",
  classes:{Sleeper:250,"2S":130,AC:600}},
{ name:"Express J", source:"Hyderabad", dest:"Vijayawada", depart:"20:00", arrive:"01:00",
  classes:{Sleeper:250,"2S":130,AC:600}}

];


// ===== VALIDATION =====

function validate(){
    let phone=document.getElementById("phone").value;
    let aadhaar=document.getElementById("aadhaar").value;

    if(!/^\d{10}$/.test(phone)){
        error("Phone must be 10 digits");
        return false;
    }

    if(!/^\d{12}$/.test(aadhaar)){
        error("Aadhaar must be 12 digits");
        return false;
    }

    error("");
    return true;
}

function error(msg){
    document.getElementById("error").innerText=msg;
}


// ===== SEARCH =====

function searchTrains(){

    if(!validate()) return;

    let s=document.getElementById("source").value.toLowerCase();
    let d=document.getElementById("dest").value.toLowerCase();

    let results=trains.filter(t =>
        t.source.toLowerCase()===s &&
        t.dest.toLowerCase()===d
    );

    display(results);
}


// ===== DISPLAY =====

function display(list){

    let div=document.getElementById("trainList");
    div.innerHTML="";

    if(list.length===0){
        div.innerHTML="No trains found";
        return;
    }

    list.forEach(t=>{
        div.innerHTML+=`
        <div class="train">
        <b>${t.name}</b><br>
        ${t.source} ➜ ${t.dest}<br>
        Time: ${t.depart} - ${t.arrive}<br>
        <button onclick='showDetails(${JSON.stringify(t)})'>
        Select
        </button>
        </div>`;
    });
}
function showDetails(train){

    let d = document.getElementById("details");

    d.innerHTML = `
    <h2>Train Selected</h2>

    Train: ${train.name}<br>
    Route: ${train.source} ➜ ${train.destination}<br>
    Time: ${train.departure} - ${train.arrival}<br><br>

    <label>Select Class:</label>
    <select id="classSelect" onchange='updatePrice(${JSON.stringify(train)})'>
        <option value="">--Choose--</option>
        <option value="Sleeper">Sleeper (₹${train.classes.Sleeper})</option>
        <option value="2S">2S (₹${train.classes["2S"]})</option>
        <option value="AC">AC (₹${train.classes.AC})</option>
    </select>

    <br><br>

    <label>No. of Seats:</label>
    <input type="number" id="seatCount" min="1" value="1"
           onchange='updatePrice(${JSON.stringify(train)})'>

    <br><br>

    <div id="totalPrice"></div>
    `;
}
function updatePrice(train){

    let cls = document.getElementById("classSelect").value;
    let seats = document.getElementById("seatCount").value;

    if(cls === "") return;

    let price = train.classes[cls];
    let total = price * seats;

    document.getElementById("totalPrice").innerHTML =
        `<b>Total Cost: ₹${total}</b>`;
}



function showDetails(train){

    let d = document.getElementById("details");

    d.innerHTML = `
    <h2>Train Selected</h2>

    Train: ${train.name}<br>
    Route: ${train.source} ➜ ${train.destination}<br>
    Time: ${train.departure} - ${train.arrival}<br><br>

    <label>Select Class:</label>
    <select id="classSelect">
        <option value="">--Choose--</option>
        <option value="Sleeper">Sleeper (₹${train.classes.Sleeper})</option>
        <option value="2S">2S (₹${train.classes["2S"]})</option>
        <option value="AC">AC (₹${train.classes.AC})</option>
    </select>

    <br><br>

    <label>No. of Seats:</label>
    <input type="number" id="seatCount" min="1" value="1">

    <br><br>

    <button onclick='bookTicket(${JSON.stringify(train)})'>
        Book Ticket
    </button>

    <div id="ticketResult"></div>
    `;
}
function bookTicket(train){

    let cls = document.getElementById("classSelect").value;
    let seats = document.getElementById("seatCount").value;

    if(cls === ""){
        alert("Please select class");
        return;
    }

    let price = train.classes[cls];
    let total = price * seats;

    // User info
    let name = document.getElementById("name").value;
    let phone = document.getElementById("phone").value;
    let aadhaar = document.getElementById("aadhaar").value;

    document.getElementById("ticketResult").innerHTML = `
    <h2>🎟 Booking Confirmed</h2>

    <div class="train">

    Passenger: ${name}<br>
    Phone: ${phone}<br>
    Aadhaar: ${aadhaar}<br><br>

    Train: ${train.name}<br>
    Route: ${train.source} ➜ ${train.destination}<br>
    Time: ${train.departure} - ${train.arrival}<br>

    Class: ${cls}<br>
    Seats: ${seats}<br>

    <h3>Total Paid: ₹${total}</h3>

    </div>
    `;
}


