//COMPROBAR LETRA DNI
function ComprobarDNI(){

  dni = prompt('Introduce tu DNI', "87152716V");

  let letras =  ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F',
'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C',
'K', 'E', 'T'];

  if (typeof dni === 'string' && dni.length == 9) {
      let dni_in = dni.charAt(dni.length - 1);
      let numeros_dni = dni.substr(0, dni.length - 1);
      let posicion = parseInt(numeros_dni) % 23;

      if(letras[posicion] == dni_in){
        window.alert("la letra es correcta");
      }else{
        window.alert("la letra no es correcta");
      }
  }else{
    window.alert("El parametro introducido no es correcto");
  }
}

//EJERCICIO 2 CALCULAR FACTORIAL
function Factorial(){
  let n = prompt("Introduce un numero",10);
  n = parseInt(n,10);
  if (typeof n == "number") {
    window.alert(CalcularFactorial(n));
  }else{
    window.alert("El parametro introducido no es correcto");
  }
}

function CalcularFactorial(n){
  return (n != 1) ? n * CalcularFactorial(n - 1) : 1;
}

//JOC DE LES CAPITALS
function Capital(pais){

  const paisos = {
    'espanya': 'Madrid',
    'frança': 'Paris',
    'italia': 'Roma',
    'alemanya': 'Berlin',
    'dinamarca': 'Copenhagen',
    'irlanda': 'Dublin',
    'belgica': 'Bruselas',
    'grecia': 'Athenas',
    'portugal':'Lisboa',
    'suecia': 'Stockholmo',
    'austria': 'Vienna',
    'eslovaquia':'Bratislava',
    'romania': 'Bucharest',
    'polonia':'Warsaw'
  }

  const def_pais = "El Pais no s'ha trobat ";
  const capital = paisos[pais] || def_pais;
  return capital;
}
//BUCLE FINS QUE EL USUARI POSE EIXIR
function JugarCapitals(){
  let pais;
  do{
    pais = prompt("introduix un pais,per parar de jugar 'eixir'",'espanya');
    if (pais != 'eixir') {
      window.alert(Capital(pais));
    }
  }while(pais != 'eixir');
}




// function Capitals(pais){
//   pais.toLowerCase();
//   switch (pais) {
//     case 'espanya':{
//         window.alert("Madrid");
//         break;
//     }
//
//     case 'frança':{
//         window.alert("Paris");
//         break;
//     }
//
//     case 'italia':{
//         window.alert("Roma");
//         break;
//     }
//
//     case 'alemanya':{
//         window.alert("Berlin");
//         break;
//     }
//
//     case 'dinamarca':{
//         window.alert("Copenhagen");
//         break;
//     }
//
//     case 'irlanda':{
//         window.alert("Dublin");
//         break;
//     }
//
//     case 'belgica':{
//         window.alert("Bruselas");
//         break;
//     }
//
//     case 'grecia':{
//         window.alert("Athenas");
//         break;
//     }
//
//     case 'portugal':{
//         window.alert("Lisboa");
//         break;
//     }
//
//     case 'suecia':{
//         window.alert("Stockholmo");
//         break;
//     }
//
//     case 'austria':{
//         window.alert("Vienna");
//         break;
//     }
//
//     case 'eslovaquia':{
//         window.alert("Bratislava");
//         break;
//     }
//
//     case 'romania':{
//         window.alert("Bucharest");
//         break;
//     }
//
//     case 'polonia':{
//         window.alert("Warsaw");
//         break;
//     }
//
//     default:{
//       window.alert("No s'ha trobat aquest pais");
//       break;
//     }
//
//   }
// }
