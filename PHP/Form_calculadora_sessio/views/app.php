<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>

  <header style="text-align:center">
    <?php
      include("../errors/comproba_sessio.php");
      include("../errors/mostra_error.php");
      echo "<h1>Welcome, user " . $_SESSION['uname'] . "</h1>";
     ?>


  </header>
  <body style="text-align:center">
    <h3>Select an operation</h3>
    <form action="../validates/validate_app.php" method="post">
      <div class="mb-3">
        <label for="operacion" class="form-label">Addition
          <input class="form-radio" type="radio" name="operacion" value="A">
        </label>

        <label for="operacion" class="form-label">Multiplication
          <input class="form-radio" type="radio" name="operacion" value="M">
        </label>

        <label for="numeros" class="form-label">How many numbers do you want to enter?
          <input class="form-control" type="number" name="numeros">
        </label>

        <button type="submit" name="button" class="btn btn-primary">Submit</button>
      </div>
    </form>
<?php include("../cerrar_session.php"); ?>
  </body>
</html>
