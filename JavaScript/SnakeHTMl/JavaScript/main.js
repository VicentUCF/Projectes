
/*
@lienzo =
@canvas =
*/
var lienzo = null,
  canvas = null;

/*
@medios es un array donde pondremos nuestros sprites para que se queden cargados en memoria para
que cuando vayamos a usarlos tenerlos de una manera rapida.
->Elementos de imagen:
  @medios["iBody"] = cuerpo de la serpiente
  @medios["iFood"] = comida de la serpiente
  @medios["iWall"] = muro donde puede chocar la serpiente
->Elementos de audio:
  @medios["aComer"] = sonido que se produce con la interseccion de iBody and iFood
  @medios["aMorir"] = sonido cuando GameOver = TRUE
*/
var medios = [];

medios["iBody"] = new Image();
medios["iBody"].src = "imgs/body.png";
medios["iBody"].addEventListener("load", cargaMedio, false);

medios["iFood"] = new Image();
medios["iFood"].src = "imgs/fruit.png";
medios["iFood"].addEventListener("load", cargaMedio, false);

medios["iWall"] = new Image();
medios["iWall"].src = "imgs/wall.png";
medios["iWall"].addEventListener("load", cargaMedio, false);

medios["aComer"] = new Audio();
if (canPlayOgg()) medios["aComer"].src = "sounds/chomp.ogg";
else medios["aComer"].src = "sounds/chomp.m4a";
medios["aComer"].addEventListener("canplaythrough", cargaMedio, false);

medios["aMorir"] = new Audio();
if (canPlayOgg()) medios["aMorir"].src = "sounds/dies.ogg";
else medios["aMorir"].src = "sounds/dies.m4a";
medios["aMorir"].addEventListener("canplaythrough", cargaMedio, false);

//Final Medios

/*
@numMediosCargados = Numero de medios total cargados.
*/
var numMediosCargados = 0;

/*
@lastPress = ultima tecla pulsada por el usuario
Las constantes son las teclas que el usuario
puede pulsar para intercatuar con el juego
*/
var lastPress = null;

const KEY_LEFT = 37;
const KEY_UP = 38;
const KEY_RIGHT = 39;
const KEY_DOWN = 40;
const KEY_P = 80;
const KEY_ENTER = 13;

const ARRIBA = 0;
const DERECHA = 1;
const ABAJO = 2;
const IZQUIERDA = 3;

//Final teclas

//Direccion a la que se mueve la serpiente por defecto DERECHA
var dir = DERECHA;

//Variables que se encargan de gestionar el estado del Juego
var pause = true;
var gameover = false;


//@wall = array de muros que estan distribuidos por el mapa
var wall = [];

wall.push(new Rectangle(100, 50, 10, 10, "#999"));
wall.push(new Rectangle(100, 100, 10, 10, "#999"));
wall.push(new Rectangle(200, 50, 10, 10, "#999"));
wall.push(new Rectangle(200, 100, 10, 10, "#999"));

//Final muros

//Cuerpo de la serpiente
var body = [];
var food=new Rectangle(80,80,10,10,'#f00');
//Puntuacion que lleva el usuario suma +1 cuando la serpiente come
var score = 0;

/*
Objeto rectangulo
@method intersects = comprueba si el rectangulo se ha topado con algun elemento
@method fill = se encarga de pintar el rectangulo
*/
function Rectangle(x, y, width, height, color) {
  this.x = x == null ? 0 : x;
  this.y = y == null ? 0 : y;
  this.width = width == null ? 0 : width;
  this.height = height == null ? this.width : height;
  this.color = color == null ? "#000" : color;
}

Rectangle.prototype.intersects = function (rect) {
  if (rect != null) {
    return (
      this.x < rect.x + rect.width &&
      this.x + this.width > rect.x &&
      this.y < rect.y + rect.height &&
      this.y + this.height > rect.y
    );
  }
};

Rectangle.prototype.fill = function (lienzo) {
  if (lienzo != null) {
    lienzo.fillStyle = this.color;

    lienzo.fillRect(this.x, this.y, this.width, this.height);
  }
};

//Final objeto rectangulo

//Se encarga de pintar todo los elementos en pantalla
function paint(lienzo) {
  var gradiente = lienzo.createLinearGradient(0, 0, 0, canvas.height);
  gradiente.addColorStop(0.5, "#0000FF");
  gradiente.addColorStop(1, "#000000");
  lienzo.fillStyle = gradiente;

  lienzo.fillRect(0, 0, canvas.width, canvas.height);

  //Muestra en pantalla el score y la ultima tecla pulsada
  lienzo.fillStyle = "red";
  lienzo.fillText("Last Press: " + lastPress, 10, 30);
  lienzo.fillText("Score: " + score, 10, 40);

  //Se encarga de pintar las imagenes que definen a la serpiente
  for (var i = 0; i < body.length; i++) {
    lienzo.drawImage(medios["iBody"], body[i].x, body[i].y);
  }

  //Se encarga de pintar el cuerpo de la serpiente detras de la cabeza
  for (var i = body.length - 1; i > 0; i--) {
    body[i].x = body[i - 1].x;
    body[i].y = body[i - 1].y;
  }

  //Se encarga de pintar los muros
  for (var i = 0, l = wall.length; i < l; i++) {
    lienzo.drawImage(medios["iWall"], wall[i].x, wall[i].y);
  }

  //Pinta la comida
  lienzo.drawImage(medios["iFood"], food.x, food.y);

  //Muestra un mensaje dependiendo si el juego esta o no pausado o si se ha terminado el juego
  if (pause || gameover) {
    lienzo.textAlign = "center";
    if (gameover) lienzo.fillText("GAME OVER", 150, 75);
    else lienzo.fillText("PAUSE", 150, 75);
    lienzo.textAlign = "left";
  }
}

//Es el metodo mas importante porque es el que se encarga de mover todo durante el Juego
function act() {
  if (!pause && !gameover) {
    if (lastPress == KEY_UP && dir != ABAJO) dir = ARRIBA;
    if (lastPress == KEY_RIGHT && dir != IZQUIERDA) dir = DERECHA;
    if (lastPress == KEY_DOWN && dir != ARRIBA) dir = ABAJO;
    if (lastPress == KEY_LEFT && dir != DERECHA) dir = IZQUIERDA;

    if (dir == DERECHA) body[0].x += 10;
    if (dir == IZQUIERDA) body[0].x -= 10;
    if (dir == ARRIBA) body[0].y -= 10;
    if (dir == ABAJO) body[0].y += 10;

    if (body[0].x >= canvas.width) body[0].x = 0;
    if (body[0].y >= canvas.height) body[0].y = 0;
    if (body[0].x < 0) body[0].x = canvas.width - 10;
    if (body[0].y < 0) body[0].y = canvas.height - 10;

    if (body[0].intersects(food)) {
      medios["aComer"].play();
      score++;
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
      body.push(new Rectangle(0, 0, 10, 10, "#0f0"));

      food.x = random(canvas.width / 10 - 1) * 10;
      food.y = random(canvas.height / 10 - 1) * 10;
    }

    for (var i = 0; i < wall.length; i++) {
      if (food.intersects(wall[i])) {
        food.x = random(canvas.width / 10 - 1) * 10;
        food.y = random(canvas.height / 10 - 1) * 10;
      }

      if (body[0].intersects(wall[i])) {
        medios["aMorir"].play();
        gameover = true;
      }
    }

    for (var i = 2; i < body.length; i++) {
      if (body[0].intersects(body[i])) {
        medios["aMorir"].play();
        gameover = true;
      }
    }
  }

  if (lastPress == KEY_P) {
    pause = !pause;
    lastPress = null;
  }

  if (gameover && lastPress == KEY_ENTER) {
    reset();
  }
}

function run() {
  setTimeout(run, 60);
  act();
}

function iniciar() {
  canvas = document.getElementById("lienzo");
  lienzo = canvas.getContext("2d");

  if (numMediosCargados == Array.longitud(medios)) {
    reset();
    run();
    repaint();
  } else {
    cargando();
  }
}

function reset() {
  score = 0;
  dir = DERECHA;
  body.length = 0;
  body.push(new Rectangle(40, 40, 10, 10, "#0f0"));
  body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
  body.push(new Rectangle(0, 0, 10, 10, "#0f0"));
  body[0].x = 40;
  body[0].y = 40;
  food.x = random(canvas.width / 10 - 1) * 10;
  food.y = random(canvas.height / 10 - 1) * 10;
  lastPress = null;
  gameover = false;
}

function repaint() {
  requestAnimationFrame(repaint);
  paint(lienzo);
}

function random(max) {
  return Math.floor(Math.random() * max);
}

function canPlayOgg() {
  var aud = new Audio();
  if (aud.canPlayType("audio/ogg").replace(/no/, "")) return true;
  else return false;
}

function cargaMedio() {
  numMediosCargados++;
}

function cargando() {
  if (numMediosCargados < Array.longitud(medios)) {
    lienzo.fillStyle = "#fff";
    lienzo.fillRect(0, 0, canvas.width, canvas.height);
    lienzo.fillStyle = "#0f0";
    lienzo.fillText(
      "Cargando " + numMediosCargados + " de " + Array.longitud(medios),
      10,
      10
    );
    setTimeout(cargando, 100);
  } else {
    iniciar();
  }
}

Array.longitud = function (obj) {
  return Object.getOwnPropertyNames(obj).length - 1;
};

longitud = Array.longitud(medios);

window.onload = function () {
  iniciar();
  document.addEventListener("keydown", function (evt) {
    lastPress = evt.keyCode;
  });
};
