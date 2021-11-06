<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>LOGIN</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  </head>
  <body>
    <?php session_start();
    if (isset($_SESSION['uname'])) {
        header("Location:web.php");
    }

     ?>



  <form action="validation.php" method="POST">
    <div class="form-group">
      <label for="uname">Username:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" value="<?php if(isset($_SESSION['uname_form'])) echo $_SESSION['uname_form'];?>">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" >
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</form>
</h1>

<?php

 if (isset($_SESSION['uname_form'])) {
   echo "<h1 style='color: red'>Usuario o contraseña erroneos </h1>";
 }

 ?>
  </body>
