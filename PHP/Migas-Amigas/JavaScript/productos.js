let products_json = '[{"name": "Pa de Poble","img": "../resources/imgs/panes/pan-de-pueblo.jpg","description": "El pan rústico elaborado como antaño. Pan de tipo rústico. Preparado al estilo tradicional. Su corteza fina y crujiente cubre un muelle elástico con alveolos variados. Desprende un olor y sabor característico del trigo. Combinación exquisita entre corteza, muelle y sabor.","price": 2},{"name": "Pages","img": "../resources/imgs/panes/pages.jpg","description": "El pan clásico tradicional catalán. Pan de tipo rústico de forma redonda e irregular de gran sabor y larga conservación. Elaborado con harina de trigo 100%. Su miga es tierna y cremosa con una corteza tostada y crujiente. Se caracteriza por los alveolos en su interior.","price": 3},{"name": "Pan de Rosca", "img": "../resources/imgs/panes/rosca.jpg","description": "Pan suave de miga refinada. Pan de variedades andaluzas. Elaborado a base de harina de trigo 100%. Se trata de un pan de corteza sutil y sabor suave. Su miga es densa, pero a la vez suave en boca.","price": 4}]'
let products = JSON.parse(products_json);

function createProduct(name,img,description){

  const main = document.getElementById('content');

  let article = document.createElement('div');
  let p_name = document.createElement('h2');
  let description_title =document.createElement('h3');
  let p_description = document.createElement('p');
  let p_imagen = document.createElement('img');
  let b_comprar = document.createElement('button');

  

  p_imagen.className = "fotos-pa";
  b_comprar.className = "comprar";
  p_description.className = "description";
  article.className = "product";

  p_name.innerHTML = name;
  description_title.innerHTML = "Descripcion del producto:";
  p_description.innerHTML = description;

  p_imagen.src= img;
  b_comprar.innerHTML = "Comprar";


  article.appendChild(p_imagen);
  article.appendChild(p_name);
  article.appendChild(description_title);
  article.appendChild(p_description);
  article.appendChild(b_comprar);

  main.appendChild(article);

}


function loadProducts(){

  for (var product in products) {

    let name = products[product].name;
    let img = products[product].img;
    let description = products[product].description;
    let price = products[product].price;

    createProduct(name,img,description,price);
  }
}

window.onload = function(){
loadProducts();
}
