//EXERCICI 1
function Par_Impar(n){
  if (n%2 == 0) {
    return "Es Par";
  }else{
    return "Es Impar";
  }
}
//FINAL EXERCICI 1

//EXERCICI 2
function esMajuscula(a){
  return a == a.toUpperCase();
}

function esMinusula(a){
  return a == a.toLowerCase();
}

function Comprobar_txt(txt){
  const texto = txt.split(" ");
  for (let i = 0; i < texto.length; i++) {
    let majuscules = 0;
    let minuscules = 0;
    if (esMajuscula(texto[i])) {
      majuscules++;
    }else if (esMinusula(texto[i])) {
      minuscules++;
    }

    if (majuscules == texto.length) {
      return "El text esta tot en majuscules";
    }else if (minuscules == texto.length) {
      return "El text esta tot en minuscules";
    }else{
      return "El text esta en minuscules i majuscules";
    }
  }
}
//FINAL EXERCICI 2

//EXERCICI 3

function comprobar(txt){
  txt = txt.replace(/\s/g,"");
  console.log(txt);
  const palabra = txt.split('');
  for (let i = 0; i < palabra.length; i++) {
    if (palabra[palabra.length-1-i] != palabra[i]) {
      return "No es palindrom";
    }
  }
  return "Es palindrom";
}

console.log(comprobar("la ruta nos aporto otro paso natural"));
