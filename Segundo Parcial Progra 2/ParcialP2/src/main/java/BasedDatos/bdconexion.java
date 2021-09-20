/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ramos
 */
public class bdconexion {
    
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/bdproyect?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER ="root";
    private static final String JDBC_PWD ="loso";
    
    //crear metodo conexion
    public static Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PWD);
    }
    
    //cerrar conexion
    public static void closeresult (ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
     public static void closeStm (PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     
      public static void closeCon (Connection cn){
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    PreparedStatement prepareStatement(String SQL_INSERT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
