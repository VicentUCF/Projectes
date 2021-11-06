

window.onload = function(){

  var game = document.getElementById('game');
  var menu = document.getElementById('menu');

  let jugar = document.getElementById("play");
  jugar.onclick = function(){
    genGame();
  }

}

/*
Funcio principal que se encarrega de crear tot el joc
*/
function genGame(){
  hideMenu();
  genButtons();
}

/*
  Se encarga de esconder el menu de inicio
*/
function hideMenu(){
  menu.style.display = 'none';
}

/*
  Borra todo lo qe se encuentra dentro
  del menu Game y Muestra el menu principal de nuevo
*/
function showMenu(){
  game.innerHTML = '';
  menu.style.display = 'block';
}


/*
  Genera un boton segun estos parametros
  @button_name = nombre del boton
  @function_name = a la funcion que tenga que llamar
  @button_class = le da estilo a un boton con boostrap 5
*/
function genButton(button_name, function_name, button_class){
  let button = document.createElement('button');
  let txt = document.createTextNode(button_name);

  button.onclick=function_name;

  button.appendChild(txt);
  button.classList.add('btn');
  button.classList.add('btn-' + button_class);
  game.appendChild(button);
}

/*
  Crea todos los botones necesarios usando genButtons();
*/
function genButtons(){
  genButton('verdolaga', crVerdolaga , 'primary');
  genButton('proteina', crProteina, 'primary');
  genButton('alinyament', crAlinyament, 'primary');
  genButton('reset', reset, 'danger');
}

/*
  Crea el contenedor donde se encontraran los ingredientes
  ademas les aplica un listener ondblclick
  para que ejecute removeIngredient(); para borrar el contenedor
*/
function crIngredient(tipo){

  let tablero = document.getElementById("table");
  let square = document.createElement("div");
  let image = document.createElement("img");


  square.className = "square";
  tablero.appendChild(square);

  square.ondblclick = function(){
    removeIngredient(square);
  }

  let ingredient =  getRandomIMG(tipo);

  image.src = "images/" + tipo + '/' + ingredient + '.png';
  square.appendChild(image);

}

/*
Borra el contenedor que se le pase por parametro
@square = contenedor HTML
*/
function removeIngredient(square){
  square.parentNode.removeChild(square);

}

/*
Crea una verdura quant se apreta el boto verdura
*/
function crVerdolaga(){
 crIngredient('verdolaga');
}

/*
Crea una proteina quant se apreta el boto proteina
*/
function crProteina(){
 crIngredient('proteina');
}

/*
Crea un alinyament quant se apreta el boto alinyament
*/
function crAlinyament(){
  crIngredient('alinyament');
}


/*
Retorna una image aleatoria segons el tipo de ingredient siga
@tipo = ingredient
*/
function getRandomIMG(tipo){
  const verduras = ['brocoli' , 'coliflor' , 'tomate' , 'zanahoria'];
  const proteinas = ['almendras', 'huevo', 'pollo', 'salmon'];
  const alinyo = ['aceite', 'cebolla_molida', 'oregano', 'pimienta', 'romero'];


  switch (tipo) {
    case 'verdolaga': return verduras[Math.floor(Math.random()*verduras.length)]; break;

    case 'proteina': return proteinas[Math.floor(Math.random()*verduras.length)]; break;

    case 'alinyament': return alinyo[Math.floor(Math.random()*verduras.length)]; break;

  }

}

/*
Netetja tota la pantalla de ingredients
*/
function reset(){
  let tablero = document.getElementById("table");
  tablero.innerHTML = '';
}
