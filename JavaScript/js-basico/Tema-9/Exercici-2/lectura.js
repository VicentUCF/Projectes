function validarFormulario(){
  var inputs = document.getElementsByTagName("input");
  var proba = document.getElementById('proba');

  proba.setCustomValidity('ERROR');

  for (var i = 0; i < inputs.length; i++) {

    if (inputs[i].type == "text") {
      if (inputs[i].value.length < 4) {
          inputs[i].style ==
      }
    }
  }
}
