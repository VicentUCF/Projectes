//Exercici 1
function reverse(txt){
  const rev = txt.split('').reverse().join('');
  alert("Original: " + txt + " Revertit: " + rev;
}

function sumaParameters(){

  let numParameters = 0;
  let sumaParameters = 0;
  let mitjanaParameters = 0;

  let parameter;

  do{
    parameter = prompt("Introduce un parametro","");
    parameter = parseInt(parameter, 10);
    if (parameter >= 0 && parameter < 10) {
      sumaParameters += parameter;
      numParameters ++;
    }

  }while(parameter >= 0 && parameter < 10);

  console.log(numParameters);
  console.log(sumaParameters);
  console.log(sumaParameters/numParameters);
}


function numberPI(){
  const pi = 3.141592653589793;
  return pi.toFixed(2);
}

function areaCircles(radi){
  console.log( numberPI() * radi*radi);
}


function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}


function playBingo(){
  let nNumeros = 0;
  let nBingo = new Array();

  do{
      let nRandom = getRandomInt(0,100);
      if (!nBingo.includes(nRandom)) {
        nBingo.push(nRandom);
        nNumeros++;
      }
  }while(nNumeros < 20);

  for (var i = 0; i < nBingo.length; i++) {
    console.log(nBingo[i]);
  }
}

var persones = [{nom:"Xuso", cognom:"Ortí Monton", dni: "123421242Z",fecha: [12,1,1998]},
                {nom:"Vicent", cognom:"Ciscar", dni: "8726152511R",fecha: [23,3,1980]},
                {nom:"Belinda", cognom:"Jover", dni: "876251621V",fecha: [6,4,1999]},
                {nom:"Teresa", cognom:"Sala", dni: "19271572D",fecha: [15,2,1999]},
                {nom:"Maria", cognom:"Monsalvez", dni: "172616627L",fecha: [31,12,1998]}];

function generateTable(){

  let table = "<table><tr><th>nom</th><th>cognom</th><th>dni</th></tr>";

  for (var i = 0; i < persones.length; i++) {
    table += "<tr><td>" + persones[i].nom + "</td><td>" + persones[i].cognom + "</td><td>" + persones[i].dni + "</td></tr>";
  }

  document.write(table);
}

generateTable();


function formataData(d,m,y){
  const months = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio',
  'Agosto','Septiembre', 'Octubre','Noviembre','Septiembre'];

  return d + " de " + months[m-1] + " de " + y;
}

var fecha = formataData(21, 4, 2020);
console.log(fecha);


function generateTableDate() {
  let table = "<table><tr><th>nom</th><th>cognom</th><th>dni</th><th>data</th></tr>";

  for (var i = 0; i < persones.length; i++) {

    let data = formataData(persones[i].fecha[0],persones[i].fecha[1],persones[i].fecha[2])

    table += "<tr><td>" + persones[i].nom + "</td><td>" +
    persones[i].cognom + "</td><td>" + persones[i].dni +
    "</td><td>" + data + "</td></tr>";
  }

  document.write(table);
}

generateTableDate();
