function eliminar(e,id,cont){
    e.preventDefault();
    console.log(cont);
    Swal.fire({
      title: 'Estas seguro de eliminar este genero?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Aceptar',
      cancelButtonText: "Cancelar",
    }).then((result) => {
      if (result.isConfirmed){
        ruta=cont+"?accion=eliminarGenero&id="+id;
        console.log(ruta);
        window.setTimeout(function(){window.location.href = ruta},1500);
        Swal.fire({
        icon: 'success',
        title: 'Se elimino con exito',
        showConfirmButton: false,
        timer: 1500
        })
      }
      });
};

function editar(e,id,controlador){
  e.preventDefault();
  var estado = document.getElementById("estado").checked;
  var nombre = document.getElementById('nombre'+id).value
  console.log(id);
  console.log(nombre);
  console.log(estado);
  Swal.fire({
  label: 'Nombre',
  input: 'text',
  title: 'Quiere editar el genero?',
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Aceptar',
  cancelButtonText: "Cancelar",
}).then((result) => {
  if (result.isConfirmed) {
    ruta=controlador+"?accion=editar&id="+id+"&nombre="+nombre+"&estado="+estado,
    window.setTimeout(function(){window.location.href=ruta},1500);
    Swal.fire({
    icon: 'success',
    title: 'Se edito con exito',
    showConfirmButton: false,
    timer: 2000})} 
    })
  }