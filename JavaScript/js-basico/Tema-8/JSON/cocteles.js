let cocteles_json = '[{"name":"Margarita", "ingredients": ["tequila","triple seco", "jugo de lima"], "precio": 8, "descripcion": "tequila con cosas", "img": "/imgs/margarita.jpg"},{"name":"Mojito", "ingredients": ["Ron","Azucar", "hierbabuena","lima", "gaseosa", "hielo picado"], "precio": 5, "descripcion": "disfruta del verano con el sabor de la hierbabuena", "img": "/imgs/mojito.jpg"},{"name":"Gintonic", "ingredients": ["Ginebra","Tonica"], "precio": 4, "descripcion": "Un licor o una ensalada no se sabe", "img": "/imgs/gintonic.jpg"},{"name":"Manhattan", "ingredients": ["Whisky","vermut rojo"], "precio": 7, "descripcion": "bebida de caballeros", "img": "/imgs/manhattan.jpg"},{"name":"Sex on the beach", "ingredients": ["Vodka","licor de melocotón", "zumo de naranza","zumo de arándanos"], "precio": 8, "descripcion": "el coctel que deseas", "img": "/imgs/sex_on_beach.jpg"}]';

let cocteles = JSON.parse(cocteles_json);

function createCoctel(name,descripcion,ingredientes,precio,img){

  const main = document.getElementById('cocteles');

  let d_coctel = document.createElement('div');
  let d_name_coctel = document.createElement('h1');
  let d_descripcion =document.createElement('h3');
  let d_ingredientes = document.createElement('ul');
  let d_precio = document.createElement('p');
  let d_imagen = document.createElement('img');

  d_name_coctel.innerHTML = name;
  d_descripcion.innerHTML = descripcion;
  for (var ingredient in ingredientes) {
    d_ingredientes.innerHTML += '<li>'+ ingredientes[ingredient] +'</li>'
  }

  d_precio.innerHTML = "Precio: " + precio + "$";
  d_imagen.src= '.'+ img;


  d_coctel.appendChild(d_name_coctel);
  d_coctel.appendChild(d_descripcion);
  d_coctel.appendChild(d_ingredientes);
  d_coctel.appendChild(d_precio);
  d_coctel.appendChild(d_imagen);
  main.appendChild(d_coctel);


}


function loadCocteles(){

  for (var coctel in cocteles) {

    let nombre = cocteles[coctel].name;
    let descripcion = cocteles[coctel].descripcion;
    let ingredients = cocteles[coctel].ingredients;
    let precio = cocteles[coctel].precio;
    let imagen = cocteles[coctel].img;
    createCoctel(nombre,descripcion,ingredients,precio,imagen);
  }
}

window.onload = function(){
loadCocteles();
}
