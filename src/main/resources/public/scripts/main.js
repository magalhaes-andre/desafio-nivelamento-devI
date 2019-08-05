var lista = [];
const api = "http://localhost:8080";
   
function preencheLista () {
    lista.push({nome: document.getElementById('convidado').value});
    console.log(lista);
    var linha = document.createElement("LI");
    var conteudo = document.createTextNode(document.getElementById('convidado').value);
    linha.appendChild(conteudo);
    document.getElementById("lista-convidados").appendChild(linha);
}

function gravaEvento() {
    var evento = { nome:document.getElementById("evento").value,
        convidados: lista,
        local: document.getElementById("local").value
    };
    var request = new XMLHttpRequest();
    var eventoMontado = JSON.stringify(evento);
    request.open("POST", api+"/adicionaEvento", false);
    request.setRequestHeader("Content-Type", "application/json");
    request.onload = function() {
          listaEventos();
    };
    request.send(eventoMontado)
}

function listaEventos() {
        var request = new XMLHttpRequest();
        request.open("GET", api+'/listaEventos', true);
        request.send();
        console.log(this.response)
}
      
listaEventos();

      