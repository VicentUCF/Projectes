<?php session_start();



 $form_variables = [
   'name','mail','msg'
 ];

 $enviar = true;

 for ($i=0; $i < count($form_variables); $i++) {
   $campo = comprobar_formulario($form_variables[$i]);

   if (!$campo){
     $enviar = false;
   }

 }

 if ($enviar) {
    $_SESSION['error'] = '';
  header('Location:../Castellano/enviado.php');
 }else{
   $_SESSION['error'] = 'Porfavor rellene todos los campos antes de enviar el formulario';
  header('Location:../Castellano/contacto.php');
 }




 function comprobar_formulario($campo){

    if (!empty($_POST[$campo])){
      if (isset($_POST[$campo])) {

        return true;
      }
    }
    return false;
 }

 ?>
