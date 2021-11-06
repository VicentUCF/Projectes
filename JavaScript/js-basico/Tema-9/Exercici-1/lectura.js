
function leerFormulario(){

  var inputs = document.getElementsByTagName("input");
  var lista = document.getElementById("frecuencia");
  var textarea = document.getElementsByTagName("textarea");

  for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].type == "radio" || inputs[i].type == "checkbox") {
      readRadio(inputs[i]);
    }else if(inputs[i].type == "submit" || inputs[i].type == "reset" ){

    }else{
      readText(inputs[i]);
    }
  }

  readTextArea(textarea,0);
  readSelect(lista);
}

function readText(input){  
  alert(input.name + ":" +input.value);
}

function readRadio(input){
  if (input.checked) {
    alert(input.name + ":" + input.value);
  }
}

function readSelect(select){
  alert(select.name + ":" + select.options[select.selectedIndex].text);
}


function readTextArea(textarea,n){
  alert("Comentario: " + textarea[n].value);
}
