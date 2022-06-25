<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="stylesheet" href="./css/materialize.css">
    <title>Generos</title>
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
  <center><h1>Lista De Generos</h1></center><hr>

  <table class="striped">
    <tr>
      <th>Id</th>
      <th>Nombre</th>
      <th>Estado</th>            
      <th>Cambiar estado</th>
      <th></th>
      <th></th>
    </tr>
    
  <c:forEach var="Genero" items="${generos}">
        
  <tr>
    <td>${Genero.getIdGenero()}</td>
    <td>${Genero.getNombreGenero()}</td>

    <c:if test="${Genero.getEstadoGenero() == true}">
      <td><span class="green-text">Genero Activo</span></td> 
    </c:if>
      
    <c:if test="${Genero.getEstadoGenero() == false}">
      <td><span class="red-text">Genero Inactivo</span></td> 
    </c:if>
    
    <td>
      <c:if test="${Genero.getEstadoGenero() == true}">
        <a href="genero?accion=estado&id=${Genero.getIdGenero()}&Estado=false" class="red-text">Inactivar</a>
      </c:if>
      <c:if test="${Genero.getEstadoGenero() == false}">
        <a href="genero?accion=estado&id=${Genero.getIdGenero()}&Estado=true" class="green-text">Activar</a>
      </c:if> 
    </td>
            
    <td>
      <a href="" type="submit" onclick="FormEd(event,'${Genero.getIdGenero()}','genero')">Editar</a>
    </td>
    <td>
      <a href="" onclick="eliminar(event,'${Genero.getIdGenero()}','genero')">Eliminar</a>
    </td>
  </c:forEach>
  </table>
  <script>
    function eliminar(e,id,cont){
      e.preventDefault();
      console.log(cont);
      Swal.fire({
        title: 'Esta seguro de eliminar el Genero?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, eliminar',
        cancelButtonText: "No, cancelar",
      }).then((result) => {
        if (result.isConfirmed){
          ruta=cont+"?accion=eliminarGenero&idGenero="+id;
          console.log(ruta);
          window.setTimeout(function(){window.location.href = ruta},1500);
          Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'El genero ha sido eliminado',
            showConfirmButton: false,
            timer: 1500
          })
              } 
            else {Swal.fire(
              'Cancelado', 
              'Cancelaste la eliminacion',
              'error');}
      });
    };
    function FormEd(e,id,cont){
    ruta=cont+"?accion=formEd&idGenero="+id;
        console.log(ruta);
        window.setTimeout(function(){window.location.href = ruta},1);
    }
    </script>
</body>
</html>