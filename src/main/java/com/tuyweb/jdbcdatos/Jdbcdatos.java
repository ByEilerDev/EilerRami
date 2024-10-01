package com.tuyweb.jdbcdatos;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbcdatos {
    public static void main(String[] args) throws ClassNotFoundException {
        String usuarios="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/jdbcdatos";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        try {     
            conexion = DriverManager.getConnection(url, usuarios, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));                
            }
            
            // Insercion de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'jsanime');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }   
            
            // Actualización de datos    
            statement.execute("UPDATE `usuarios` SET `nombre` = 'jsamario' WHERE `usuarios`.`id` = 3;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            // Borrado o Eliminacion de datos
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 3");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Jdbcdatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }            
}
