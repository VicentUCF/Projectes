function DemanarInfo(text,fondo){
  return prompt(text,fondo)
}

function CalcularNota(){
  let nota = DemanarInfo("Introduix una nota(0-10)","5");
  nota = parseFloat(nota,10);

if (nota >= 0 && nota <= 10) {
  if (nota < 5) {
    alert("INSUFICIENT");
  }else if (nota >= 5 && nota < 6) {
    alert("SUFICIENT");
  }else if (nota >= 6 && nota < 7) {
    alert("BE");
  }else if (nota >= 7 && nota < 9) {
    alert("NOTABLE");
  }else if (nota >= 9 && nota <= 10) {
    alert("EXCELENT");
  }
}else{
  alert("El parametro introducido no es correcto");
}

}

function MinimMaxim(){
  let numeros = [6,4,12,52,1,65,2,78,9,23,11,10,23,22,53];
  numeros.sort((a, b) => a - b );
  alert("Minim = " + numeros[0] + " Maxim = " + numeros[numeros.length - 1]);
}

function IMC(){
  let altura = DemanarInfo("Altura","m");
  let pes = DemanarInfo("Pes","Kg");

  let imc = parseFloat(pes) / (parseFloat(altura) * parseFloat(altura));
  alert(imc.toFixed(2));
  if (imc < 18.5) {
      alert("Baix de pes");
  }else if ( imc >= 18.5 && imc < 25) {
    alert("Pes normal");
  }else if (imc >= 25 && imc < 30) {
    alert("Sobrepes");
  }else if (imc > 30) {
    alert("Obesitat");
  }
}


function OrdenarNumeros(){
  let numeros = [6,4,12,52,1,65,2,78,9,23,11,10,23,22,53];
  numeros.sort((a, b) => a - b );
  for (var i = 0; i < numeros.length; i++) {
    alert(numeros[i]);
  }
}

function Menu(){

  let opcio;

  do{
      opcio = DemanarInfo("1.Sumar, 2.Restar, 3.Multiplicar, 4.Dividir, 5.Ixir");
      opcio = parseInt(opcio, 10);
      if (opcio >= 1 && opcio <=4) {
        var n1 = DemanarInfo("Numero1","2");
        n1 = parseInt(n1,10);
        var n2 = DemanarInfo("Numero2","10");
        n2 = parseInt(n2,10);
      }
    switch (opcio) {
      case 1: alert(n1+n2); break;
      case 2: alert(n1-n2); break;
      case 3: alert(n1*n2); break;
      case 4: alert(n1/n2); break;;
      case 5: alert("Has ixit de la calculadora"); break;
      default: alert("Debe elegir una opcion del 1 al 5"); break;
    }

  }while (opcio != 5);
}


function Sumar1000(){
  let n = 0;
  do{
  n += parseInt(DemanarInfo("Introduix un numero","2"),10);
  alert(n);
  }while (n < 1000);
}

function getRandomInt(min, max) {
return Math.floor(Math.random() * (max - min)) + min;
}

var tablero = [];

function Buscaminas(){

  let n_bombes = 0;
  let posx;
  let posy;

  for (var i = 0; i < 5; i++) {
    tablero[i] = [];
    for (var j = 0; j < 5; j++) {
      tablero[i][j] = "[x]";
    }
  }

  do{
    if (plenarBombes()) {
      n_bombes++;
    }else{
      plenarBombes();
    }
  }while(n_bombes < 10);

  let finalitzar_joc = false;

  do{
    posx = DemanarInfo("Posicio x: ", " ");
    posy = DemanarInfo("Posicio y: ", " ");
    seeTablero();
      if (tablero[posy][posx] == "[*]") {
          finalitzar_joc = true;
          document.getElementById('tab').innerHTML = "Has perdut"
      }else{
          tablero[posy][posx] = "[ ]"
      }
  }while(finalitzar_joc == false);



}//fin funcion

function seeTablero(){
    let pantalla = " ";
      for (var i = 0; i < 5; i++) {
        for (var j = 0; j < 5; j++) {
          pantalla += tablero[i][j];
        }
          pantalla += "</br>";
      }
    document.getElementById('tab').innerHTML = pantalla;
  }

function plenarBombes(){

  let pos_x = getRandomInt(0,4);
  let pos_y = getRandomInt(0,4);

  if(tablero[pos_y][pos_x] != "[*]"){
    tablero[pos_y][pos_x] = "[*]";
    return true;
  }else{
    return false;
  }

}



function Loteria(){
  let n_premiat = "";
  for (var i = 0; i < 6; i++) {
    n_premiat += getRandomInt(0,9);
  }
  let boleto = DemanarInfo("Introduix el teu numero loteria 6 digits","162542");
  n_premiat = n_premiat.split('');
  boleto = boleto.split('');
  let encertats = 0;

  for (var i = 0; i < n_premiat.length; i++) {
    if (boleto[i] == n_premiat[i]) {
      encertats++;
    }
  }

  document.getElementById('tab').innerHTML = "<table><tr><th>Boleto Usuari</th><th>Boleto Guanyador</th><th>Numero Acerts</th></tr></table>"

}


























//
