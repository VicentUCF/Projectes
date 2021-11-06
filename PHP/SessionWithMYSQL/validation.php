<?php session_start();

$iniciar_sessio = false;

if (!empty($_POST['uname']) && !empty($_POST['pswd'])){
  if (isset($_POST['uname']) && isset($_POST['pswd'])){

    $_SESSION['uname_form'] = $_POST['uname'];

    $datos = mysqli_connect('localhost','root','toor','probaphp');
    $query = "SELECT usuarios.pswd FROM usuarios WHERE usuarios.user LIKE '{$_POST['uname']}' AND usuarios.pswd LIKE '{$_POST['pswd']}'";
    $result = mysqli_query($datos,$query);
    
    if ($result) {
      foreach ($result as $key => $value) {
        $result = $value['pswd'];
      }

      if ($_POST['pswd'] == $result ) {
        $_SESSION['uname']=$_POST['uname'];
        $_SESSION['pswd']=$_POST['pswd'];
        $iniciar_sessio = true;
      }
    }
  }
}

if ($iniciar_sessio == true) {

  header("Location:web.php");
}else{
  header("Location:login.php");
  $_SESSION['logejat'] = false;
}


 ?>
