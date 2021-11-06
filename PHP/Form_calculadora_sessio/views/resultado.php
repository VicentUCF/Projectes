<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>
  <body style="text-align:center">
    <?php

    include("../errors/comproba_sessio.php");
    include("../errors/mostra_error.php");
    include("../exercici_1.php");

    $_SESSION['error']='';

    if (!isset($_SESSION['numeros'])&&!isset($_SESSION['operacion'])) {
      $_SESSION['error'] = "No puedes acceder a resultado todavia";
      header("Location:app.php");
    }

    if (empty($_SESSION['numeros'])) {
      $_SESSION['error'] = "Por favor introduce los parametros para realizar el calculo";
      header("Location:app.php");
    }


    $numeros = $_SESSION['numeros'];

    echo "<h1>Resultado: " . exercici1($numeros,$_SESSION['operacion']) . "</h1>";


    ?>

    <a href="app.php" class="btn btn-primary">Volver a realizar otra operacion</a>
    <?php include("../cerrar_session.php"); ?>
  </body>
</html>
