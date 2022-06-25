<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/materialize.css">
    <title>Registrar</title>
</head>
<body>
    <nav class="grey darken-2">
        <div class="nav-wrapper">
        <a href="#" class="brand-logo right">Disquera</a>
         <ul id="nav-mobile" class="left hide-on-med-and-down">
            <li><a href="genero?accion=index">Inicio</a></li>
            <li><a href="genero?accion=listar">Generos</a></li>
            <li><a href="genero?accion=abrirForm">Nuevo genero</a></li>
            <li><a href="">Canciones</a></li>
            <li><a href="">Nueva cancion</a></li>
          </ul>
        </div>
    </nav>    
      <div class="container-fluid">
        <center><h1>Registrar Genero</h1></center><hr>
          <center>
            <form method="get" style="width: 35rem;" class="mx-auto">
              <div class="form-group">
                  <label class="black-text"> Nombre</label><br>
                  <input type="hidden" name="id" value="${id}">
                  <input type="text" name="nombreGenero" placeholder="Nombre del genero:">
              </div>
              <div class="form-group">
                <button class="btn waves-effect waves-light green" type="submit" name="accion" value="editar">Guardar</button>
              </div>
          </form>
        </center>
      </div>
</body>
</html>