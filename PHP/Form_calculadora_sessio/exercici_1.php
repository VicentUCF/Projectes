<?php

function exercici1($numeros, $opcion){
  switch ($opcion) {
    case 'A':
      return sumar($numeros);
      break;
    case 'M':
      return multiplicar($numeros);
      break;
    default:
      return null;
      break;
  }
}


function sumar($numeros){
  $resultado = null;

  foreach ($numeros as $key => $value) {
    $resultado += $value;
  }

  return  $resultado;
}

function multiplicar($numeros){

  if (!empty($numeros)) {
    $resultado=1;

    foreach ($numeros as $key => $value) {
      $resultado = $value * $resultado;
    }

    return $resultado;
  }else {
    return null;
  }
}

// echo "La Multiplicacio de (4*5*2*8) es: " . exercici1(array(4,5,2,8),'M');
// echo "</br>La suma de (3+10+4) es: " . exercici1(array(3,10,4),'A');
// echo exercici1(array(1,2,3),'');

 ?>
