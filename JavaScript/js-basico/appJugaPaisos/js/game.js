/*
Capitals referides segons el prefix del pais
*/
const capitales= {
  'es':'Madrid',
  'fr':'Paris',
  'it':'Roma',
  'de':'Berlin',
  'dk':'Copenhagen',
  'ie':'Dublin',
  'be':'Bruselas',
  'gr':'Athenas',
  'pt':'Lisboa',
  'se':'Stockholmo',
  'at':'Vienna',
  'sk':'Bratislava',
  'ro':'Bucharest',
  'pl':'Warsaw'
};

/*
Array de prefixos de paisos per a conseguir les imatges
*/
const images = ['es','fr','it','de','dk','ie','be','gr','pt','se','at','sk','ro','pl'];

/*
Retorna un pais aleatori
*/
function randomCountry(){
  return images[Math.floor(Math.random()*images.length)];
}

/*
Alerta al usuari de la capital del pais que ha
pulsat retallant la url de la image per aconseguir el pais
*/
function capital(square){
  let url = square.getElementsByTagName("img")[0].src
  let capital = url.split("/");
  capital = capital[6].toString().split(".");
  capital = capital[0].toString();
  alert(capitales[capital]);
}


/*
Crea el cuadrat i la image en la que despres
al polsar ixira un alert amb la capital
*/
function createSquare(){
  let tablero = document.getElementById("tablero");
  let square = document.createElement("div");
  let image = document.createElement("img");
  let country = randomCountry();

  image.src = "Images/paises/" + country + '.png';
  square.appendChild(image);
  square.className = "square";
  tablero.appendChild(square);

}


function generateGame(rows){

  document.getElementById("tablero").innerHTML = "";

  for (var i = 0; i < rows; i++) {
    for (var j = 0; j < rows; j++){
        createSquare();
    }
      let tablero = document.getElementById("tablero");
      tablero.innerHTML += "<br>";
  }

  let squares = document.querySelectorAll(".square");

  Array.from(squares).forEach((square)=>{
    square.onclick = function(){
      capital(square);
    }

    square.onmouseover = function(){
      square.style.backgroundColor = 'orange';
    }

    square.onmouseout = function(){
      square.style.backgroundColor = 'grey';
    }

  });

}


window.onload = function(){

  let nivel1 = document.getElementById("boton1");
  nivel1.onclick = function(){
    generateGame(1);
  }

  let nivel2 = document.getElementById("boton2");
  nivel2.onclick = function(){
    generateGame(2);
  }

  let nivel3 = document.getElementById("boton3");
  nivel3.onclick = function(){
    generateGame(3);
  }

  let nivel4 = document.getElementById("boton4");
  nivel4.onclick = function(){
    generateGame(4);
  }

}
