<?php

include("../errors/comproba_sessio.php");

if (!empty($_POST['operacion']) && isset($_POST['operacion'])){
  if (!empty($_POST['numeros']) && isset($_POST['numeros'])) {

      $_SESSION['error'] = '';

    $_SESSION['operacion'] = $_POST['operacion'];
    $_SESSION['numeros'] = $_POST['numeros'];

    header("Location:../views/calculadora.php");
  }else{
    $_SESSION['error'] = 'Porfavor introduce cuantos numeros vas a querer calcular';
    header("Location:../views/app.php");
  }
}else{
  $_SESSION['error'] = 'Porfavor introduce el tipo de operacion';
  header("Location:../views/app.php");
}








 ?>
