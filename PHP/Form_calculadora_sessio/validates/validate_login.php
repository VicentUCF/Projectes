<?php

include("../errors/comproba_sessio.php");



if (!empty($_POST['uname']) && isset($_POST['uname'])){

    $_SESSION['uname'] = $_POST['uname'];
    $_SESSION['error'] = '';
    header("Location:../views/app.php");

}else{
  $_SESSION['error'] = "Please fill the username";
  header("Location:../views/login.php");
}





 ?>
