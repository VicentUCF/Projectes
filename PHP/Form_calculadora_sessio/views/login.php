<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>
  <body style="text-align:center">

    <?php session_start();
    include("../errors/mostra_error.php");

    if (isset($_SESSION['uname'])) {
       header("Location:app.php");
    }

     ?>

    <h1>Please, fill your name</h1>

      <form action="../validates/validate_login.php" method="post">
        <div class="mb-3">
          <label for="uname" class="form-label">Enter your name:
              <input type="text" name="uname" value="" class="form-control">
          </label>
        </div>

        <button type="submit" name="button" class="btn btn-primary">Submit</button>
      </form>


  </body>
</html>
