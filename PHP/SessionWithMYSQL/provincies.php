<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="exercici7.css">
    <title>Provinces</title>
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



  if (isset($_POST['province'])) {
    $ciutats;
    switch ($_POST['province']) {
      case '1':
        $ciutats = array('Alacant','Benidorm','Elda');
        break;
      case '2':
        $ciutats = array('Valencia','Gandia','Favara');
        break;
      case '3':
        $ciutats = array('Castello','Montanejos','Benicassim');
        break;
    }


      echo '

          <h1>The cities of the Comunitat Valenciana</h1>
          <fieldset>

          <form action="ciutats.php" method="post">
          <div>
            <input type="radio" name="cities" id="city1" value="'.$ciutats[0].'">
            <label for="city1">
                  '.$ciutats[0].'
            </label>
          </div>

          <div >
            <input type="radio" name="cities" id="city2" value="'.$ciutats[1].'">
            <label for="city2">
                  '.$ciutats[1].'
            </label>
          </div>

          <div>
            <input type="radio" name="cities" id="city3" value="'.$ciutats[2].'">
            <label for="city3">
                  '.$ciutats[2].'
            </label>
          </div>

          <input type="submit" class="submint" value="Submint">
        </form>
        </fieldset>

      ';
  }else{
    echo "<h1>ERROR NO HA INTRODUCIDO NINGUN PARAMETRO</h1>";
    echo '<a href="index.html">Iniciar de nuevo el formulario</a>';
  }



 ?>



</body>
</html>
