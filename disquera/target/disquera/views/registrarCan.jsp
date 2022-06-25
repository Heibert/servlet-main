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
    <nav class="green accent-2">
        <div class="nav-wrapper">
          <a href="#" class="brand-logo right">Disquera</a>
          <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="genero?accion=index">Inicio</a></li>
            <li><a href="genero?accion=listar">Generos</a></li>
            <li><a href="genero?accion=abrirForm">Nuevo genero</a></li>
            <li><a href="">Canciones</a></li>
            <li><a href="">Nueva cancion</a></li>
          </ul>
        </div>
    </nav>
    <h2 class="teal-text text-lighten-2">Registrar Genero</h2>
    <form method="get">
        <div class="row">
            <div class="input-field inline col s12">
                <input type="text" name="nombre" placeholder="Nombre del genero:">
            </div>
        </div>
        <div class="row">
            <input type="submit" name="accion" value="registrar" class="waves-effect waves-light btn-large">
        </div>
    </form>
</body>
</html>