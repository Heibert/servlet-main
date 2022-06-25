package model;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //estos son los atributos para la conexion
    private static final String BD="jdbc:mysql://localhost:3306/disquera";
    private static final String usuario="root";
    private static final String clave="";
    private static Connection con;
    //este es el metodo de conexion
    public static Connection conectar() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(BD,usuario,clave);
        System.out.println("Conexión Exitosa mi perrito");
    }
    catch(Exception e) {
        System.out.println("No se conecto a la base de datos "+e.getMessage().toString());
    }
    return con;
    }
    public static void main(String[] args) {
    Conexion.conectar();
    }
    }