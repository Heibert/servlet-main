package controller;
import model.GeneroDao;
import model.GeneroVo;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Genero extends HttpServlet {
    GeneroDao gdao=new GeneroDao();
    GeneroVo gvo=new GeneroVo();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doGet");
    String accion=req.getParameter("accion");
    System.out.println(accion);
        
    switch (accion) {
        case "abrirForm":
            abrirForm(req, resp);
            break;
        
        case "listar":
            listar(req,resp);
            break;
        
        case "estado":
            estado(req, resp);
            break;
            
        case "eliminarGenero":
            eliminarGenero(req,resp);
            break;
            
        case "editar":
            editar(req, resp);
            break;
            
        case "registrar":
            registrar(req, resp);
            break;
     
        case "index":
            index(req, resp);
            break;
        case "formEd":
            formEd(req,resp);
            break;
        default:
            System.out.println("Hay error en el doGet");
            break;
        }
    }

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doPost");
    String accion=req.getParameter("accion");        
    System.out.println(accion);

    switch (accion) {
        
        case "listar":
            listar(req,resp);
            break;
            
        default:
            System.out.println("Hay error en el doPost");
            break;
        }
    }
    
private void editar(HttpServletRequest req, HttpServletResponse resp){
    String nombreG = req.getParameter("nombreGenero");
    try {
        int id =(Integer.parseInt(req.getParameter("id")));
        gdao.editar(nombreG,id);
        resp.sendRedirect("genero?accion=listar");
        System.out.println("Genero editado");
    } catch (Exception e) {
        //TODO: handle exception
    }
}
        
private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
    try{
        req.getRequestDispatcher("views/registrar.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    }catch(Exception e){
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
    }
}
        
private void eliminarGenero(HttpServletRequest req, HttpServletResponse resp) {
    GeneroDao gdao=new GeneroDao();
    GeneroVo gvo=new GeneroVo();
            
    if(req.getParameter("idGenero")!=null) {
        gvo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
    }
            
    else{
        System.out.println("No fue posible hallar el id");
    }
            
    try{
    gdao.eliminarGenero(gvo.getIdGenero());
    resp.sendRedirect("genero?accion=listar");
    System.out.println("Genero eliminado");
            
    }catch(Exception e){
    req.setAttribute("msje", "No fue posible eliminar" + e.getMessage());
    System.out.println("Error al eliminar" + e.getMessage());
    }
}

private void registrar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("nombreGenero")!=null){
        gvo.setNombreGenero(req.getParameter("nombreGenero"));
        gvo.setEstadoGenero(true);
    }
    try {
        gdao.registrar(gvo);
        resp.sendRedirect("genero?accion=listar");
        System.out.println("Registro exitoso");
    } catch (Exception e) {
        req.setAttribute("msje","no se pudo registrar el genero"+e.getMessage());
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    }
}

private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List <GeneroVo>genero=gdao.listar();
        req.setAttribute("generos", genero);
        req.getRequestDispatcher("views/lista.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}
        
private void estado(HttpServletRequest req, HttpServletResponse resp){
    Boolean estado1 = Boolean.valueOf(req.getParameter("Estado"));
    System.out.println("Se cambiara de "+estado1);
    gvo.setIdGenero(Integer.parseInt(req.getParameter("id")));
            
    if(estado1 == false){
        gvo.setEstadoGenero(false);
        System.out.println("Se cambio a falso");
    }
            
    else{
        gvo.setEstadoGenero(true);
        System.out.println("Se cambio a verdadero");
    }
    
    try{
        gdao.estado(gvo);
        resp.sendRedirect("genero?accion=listar");
        System.out.println("Cambios registrados");
            
    }catch (Exception e) {
        req.setAttribute("msje", "No se pudo cambiar el estado "+e.getMessage());
        System.out.println("Error en el cambio de estado "+e.getMessage().toString());
    }
}
        
private void index(HttpServletRequest req, HttpServletResponse resp){
            
    try {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
            
    }catch (Exception e) {
        req.setAttribute("msje", "Hay error en el Index "+e.getMessage());
        System.out.println("Hay error en el Index "+e.getMessage().toString());
    }
}
private void formEd(HttpServletRequest req, HttpServletResponse resp){
    try {
        req.setAttribute("id", (Integer.parseInt(req.getParameter("idGenero"))));
        req.getRequestDispatcher("views/formEd.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Hay error en el reenvio a editar "+e.getMessage().toString());
    }
}
}