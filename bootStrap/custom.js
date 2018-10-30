/*let requestURL = 'https://jsonplaceholder.typicode.com/posts';
let request = new XMLHttpRequest();
request.open('GET', requestURL);
request.responseType = 'text';
request.send();
request.onload = function() {
    let res = request.response;
    
    let objet = res.split("{");
    objet.forEach(function(element, index) {
        element = element.split(",");
        element.forEach(function(element1, index1){
            element1 = element1.split(":");
            console.log(element1);
        });
    });
}*/

let tabBoutonReservation = document.querySelectorAll("tr .boutonReservation");

tabBoutonReservation.forEach(function(element){
    element.addEventListener("click", function(){
        let valeur = this.parentElement.parentElement.querySelector(".reservation").textContent;
        let stringutilisateur = "";
        
        
        if(valeur == "Non")
        {
            this.parentElement.parentElement.querySelector(".utilisateur").textContent = "Personne";
            this.parentElement.parentElement.querySelector(".reservation").textContent = "Oui";
            this.textContent = "Réserver";
        }
        else if(valeur == "Oui")
        {
            stringutilisateur = prompt("Quel est votre pseudo ?", "");
            this.parentElement.parentElement.querySelector(".utilisateur").textContent = stringutilisateur;
            this.parentElement.parentElement.querySelector(".reservation").textContent = "Non";
            this.textContent = "Annuler réservation";
        }
    });
});


let boutonAjouterOeuvre = document.querySelector(".ajouterMedia");

boutonAjouterOeuvre.addEventListener("click", function(){
    let tabTexteArea = this.parentElement.parentElement.querySelectorAll(".textearea");
    let map = new Map();
    let compteur = 0;
    tabTexteArea.forEach(function(element) {
        map.set(compteur, element.value)
        compteur++;
    });
    
    let dernierTrTable = document.querySelector("table tr:last-child");
    let trAAjouter = document.createElement("tr");
    let tdAAjouter1 = document.createElement("td");
    let value = document.createTextNode(map.get(0));
                                        
    tdAAjouter1.appendChild(value);
    trAAjouter.appendChild(tdAAjouter1);
    
    let tdAAjouter2 = document.createElement("td");
    value = document.createTextNode(map.get(1));
    tdAAjouter2.appendChild(value);
    trAAjouter.appendChild(tdAAjouter2);
    
    let tdAAjouter3 = document.createElement("td");
    value = document.createTextNode("Oui");
    tdAAjouter3.appendChild(value);
    trAAjouter.appendChild(tdAAjouter3);
    
    let tdAAjouter4 = document.createElement("td");
    value = document.createTextNode("Personne");
    tdAAjouter4.appendChild(value);
    trAAjouter.appendChild(tdAAjouter4);
    
    let tdAAjouter5 = document.createElement("td");
    //tdAAjouter5.createTextNode();
    
    trAAjouter.appendChild(tdAAjouter2);
    trAAjouter.appendChild(tdAAjouter3);
    trAAjouter.appendChild(tdAAjouter4);
    trAAjouter.appendChild(tdAAjouter5);
    dernierTrTable.appendChild(trAAjouter);
});