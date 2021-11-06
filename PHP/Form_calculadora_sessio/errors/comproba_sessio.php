<?php session_start();

  if (!isset($_SESSION['uname'])) {
    $_SESSION['error'] = 'Has de iniciar sesion';
    header("Location:../views/login.php");
  }

 ?>
