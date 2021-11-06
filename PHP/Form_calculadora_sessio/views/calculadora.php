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

    if (!isset($_SESSION['numeros'])&& !isset($_SESSION['operacion'])) {
      header("Location:app.php");
    }

    $n_parametros = intval($_SESSION['numeros']);
    ?>

    <form class="" action="../validates/validate_calculadora.php" method="post">

    <?php
    for ($i=0; $i < $n_parametros; $i++) {
      echo 'Numero '. $i+1 . ':<input type="number" class="form-label" name='. "numero$i" . '></br>';
    }

    ?>



    <button type="submit" class=" btn btn-primary" style="margin-left: 50px" name="button">Enviar</button>

      <?php include("../cerrar_session.php"); ?>
    </form>
  </body>
</html>
