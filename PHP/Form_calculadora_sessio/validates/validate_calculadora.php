<?php

include("../errors/comproba_sessio.php");


if (!isset($_SESSION['numeros']) || empty($_SESSION['numeros'])) {
  $_SESSION['error'] = 'Has de introducir los parametors correspondientes';
  header("Location:../views/app.php");
}

$numeros = array();


for ($i=0; $i < $_SESSION['numeros']; $i++) {
  if (isset($_POST["numero$i"]) && !empty($_POST["numero$i"])){
      array_push($numeros,$_POST["numero$i"]);
  }
}

$_SESSION['numeros'] = $numeros;
$_SESSION['error'] = '';
header("Location:../views/resultado.php");
 ?>
