<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="../CSS/master.css">
  </head>
  <style media="screen">
    #error{
      color:red;
      margin: 30px 0px 30px 0px;
    }
  </style>
  <body>
    <?php include('../resources/header.php'); ?>

    <div id="contacto">
      <h1 class="title">CONTACTA CON NOSOSTROS!</h1>

      <form class="" action="../forms/contacto-validation.php" method="post">
        <?php session_start();

        if (isset($_SESSION['error'])) {
          echo '<p id="error">' . $_SESSION['error'] . '</p>';
        }

         ?>
          Nombre</br>
          <input type="text" name='name' class="correo" placeholder="Nombre"></br>
          Correo Electronico</br>
          <input type="text" name='mail' class="correo" placeholder="Correo"></br>

          Mensaje</br>
          <input type="text" name='msg' class="contact" placeholder="Mensaje"></br>

          <div id="label-button">
              <button type="submit" style="background-color:brown" id="button" name="button">Enviar</button>
          </div>
      </form>


    </div>




  </body>
</html>
