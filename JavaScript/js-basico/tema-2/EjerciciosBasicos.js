
function Semanal(){

  var semana = ["lunes","martes","miercoles","jueves","viernes","sabado","domingo"];

  for (var i = 0; i < semana.length; i++) {
    window.alert(semana[i]);
  }

}

function Cometes(){
  var simples = "'Hola Mundo'";
  var complexes = '"Hola Mundo"';

  window.alert(simples);
  window.alert(complexes);
}


function Saludar(){
  let nombre = prompt("Introduce tu nombre:",'Juan');
  window.alert("Hola " + nombre);
}
