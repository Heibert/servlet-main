package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class GeneroDao {
    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar los resultados de las consultas
    String sql=null; //variable para guardar sentencias de sql
    int r;
        
public List<GeneroVo> listar() throws SQLException{
    List<GeneroVo> generos=new ArrayList<>();
    sql= "SELECT*FROM Genero";
    try {
        con=Conexion.conectar();//Abrir la conexion
        ps=con.prepareStatement(sql);//Prepara sentencia select
        rs=ps.executeQuery();//Ejecutamos la sentencia y guardamos los resultados
        while(rs.next()){
            GeneroVo r=new GeneroVo();
            r.setIdGenero(rs.getInt("id_Genero"));
            r.setNombreGenero(rs.getString("nombreGenero"));
            r.setEstadoGenero(rs.getBoolean("estadoGenero"));
            generos.add(r);
        }
        ps.close();
        System.out.println("Consulta exitosa");
    
    } catch (Exception e) {
        System.out.println("No hay generos definidos"+e.getMessage());   
    }
    
        finally{
            con.close();//Cerrando la conexion
        }
    return generos;
}

public int registrar(GeneroVo Genero) throws SQLException{
    sql="INSERT INTO Genero(nombreGenero,estadoGenero) values(?,?)";
    
    try {
    con=Conexion.conectar();
    ps=con.prepareStatement(sql);
    ps.setString(1, Genero.getNombreGenero());
    ps.setBoolean(2, Genero.getEstadoGenero());
    System.out.println(ps);
    ps.executeUpdate();
    ps.close();
    System.out.println("Genero registrado con exito");

    }catch (Exception e) {
        System.out.println("Error en el registro "+e.getMessage().toString());
    }
        
    finally{
    con.close();
    }
        
    return r;
    }
    
public void eliminarGenero(int idGenero) throws SQLException{
    sql="DELETE FROM genero WHERE id_Genero="+idGenero;
    System.out.println(sql);
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.executeUpdate(sql);
        ps.close();
        System.out.println("se elimino correctamente");
    }
    catch(Exception e){
        System.out.println("Error al eliminar"+e.getMessage());
    }
    finally{
        con.close();
    }
}

public void estado(GeneroVo Genero)throws SQLException{
    sql="UPDATE genero SET estadoGenero = ? WHERE genero.id_Genero = ?;";
    try {
    con=Conexion.conectar();
    ps=con.prepareStatement(sql);
    ps.setBoolean(1, Genero.getEstadoGenero());
    ps.setInt(2, Genero.getIdGenero());
    System.out.println(ps);
    ps.executeUpdate();
    ps.close();
    System.out.println("Se cambio el estado exitosamente");
        
    }catch (Exception e) {
    System.out.println("No fue posible cambiar el estado del genero "+e.getMessage().toString());
    }
        
    finally{
    con.close();
    }
}

public void editar (String nombre,int id) throws SQLException{
    sql="UPDATE genero SET nombreGenero = ? WHERE id_Genero = ?";
    try {
    con=Conexion.conectar();
    ps=con.prepareStatement(sql);
    ps.setString(1, nombre);
    ps.setInt(2, id);
    System.out.println(ps);
    ps.executeUpdate();
    ps.close();
    System.out.println("Edicion exitosa");
    
    }catch (Exception e) {
    System.out.println("No fue posible editar "+e.getMessage().toString());
    }

    finally{
    con.close();
    }
}
}

