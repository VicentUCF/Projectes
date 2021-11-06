<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Cities</title>
    <link rel="stylesheet" href="exercici7.css">
  </head>
  <body>
    <?php session_start();
    if (isset($_SESSION['uname'])) {
        echo $_SESSION['uname'];
    }else{
      header("Location:login.php");
    }

     ?>
     <a href="unlog.php">Desconectarse</a>

    <?php
    if (isset($_POST["cities"])) {
      echo "<h1>The cities of the Comunitat Valenciana</h1>";
      echo '<h3>You Selected: '.$_POST["cities"].'</h3>';

      $url = array(
        'Alacant' => 'https://www.alicante.es//es',
        'Benidorm' => 'https://benidorm.org/es',
        'Elda' => 'http://www.elda.es/',
        'Valencia' => 'https://www.valencia.es/',
        'Gandia' => 'https://www.gandia.es/aytg/web_php/index.php?lang=10',
        'Favara' => 'https://www.ajuntamentfavara.es/',
        'Castello' => 'http://www.castello.es/web30/pages/inicio_web10.php?id=val',
        'Montanejos' => 'http://www.montanejos.es/',
        'Benicassim' => 'http://www.benicassim.es/'
      );

        echo '<div><a class="link_center" href="'.$url[$_POST["cities"]].'">Press for visiting the city page</a></div>';

    }else{
      echo "<h1>ERROR NO HA INTRODUCIDO NINGUN PARAMETRO</h1>";
      echo '<a href="index.html">Iniciar de nuevo el formulario</a>';

    }

    ?>



  </body>
</html>
