function contarLinks(){
  let array_enlaces = document.getElementsByTagName("a");
  let n_enlaces = array_enlaces.length;
  alert("EL numero de enlaces es : " + n_enlaces);
}


contarLinks();


function modificarLogo(){

  let head = document.getElementById("header");
  let imagen = head.getElementsByTagName("img");
  imagen[0].src = "images/thumbs/fullahead.jpg";

}

modificarLogo();


function modificarMenu(){
  let menu = document.getElementById("menu");
  var title = menu.querySelectorAll(".title");

  for (let i = 0; i < title.length; i++) {
    title[i].innerHTML = "columna " + (i+1);
  }

}


modificarMenu();


function rmFavLinks(){
  let right_column = document.querySelector(".horzPad");
  let title3 = right_column.getElementsByTagName("h3");

  title3[1].innerHTML = "";

  let links = right_column.querySelectorAll(".submenu2");

  links[1].innerHTML = "";

}

rmFavLinks();
