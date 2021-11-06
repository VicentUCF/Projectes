<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
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


        <h1>The cities of the Comunitat Valenciana</h1>
        <fieldset>

          <form action="provincies.php" method="post">

            <div>
              <input type="radio" name="province" id="province1" value="1">
                <label for="province1">
                  Alacant
              </label>
            </div>

            <div>
              <input type="radio" name="province" id="province2" value="2">
                <label for="province1">
                  Valencia
                </label>
            </div>

            <div>
              <input type="radio" name="province" id="province3" value="3">
                <label for="province1">
                  Castello
                </label>
            </div>

            <input type="submit" class="submint" value="Submint">

          </form>
        </fieldset>


  </body>
</html>
