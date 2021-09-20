/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedDatos;

import Comisiones.ClsUsuario;
import java.sql.*;

/**
 *
 * @author ramos
 */
public class bdusuarios {
    
   private static final String SQL_INSERT="insert into vendedores (user,password) values (?,?);";

    
    public int insert(ClsUsuario usuario){
    
         bdconexion conexion=null;
        PreparedStatement statement=null;
        int rows=0;
        try{
            conexion=(bdconexion) bdconexion.getConnection();
            statement=conexion.prepareStatement(SQL_INSERT);
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
  
            System.out.println("El usuario a usa la siguietne sentencia: " + SQL_INSERT);
            rows=statement.executeUpdate();
        }
         catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
           bdconexion.closeStm(statement);
           bdconexion.closeCon(conexion);
        }
        return rows;
    }

    public boolean  Validar(ClsUsuario datos){
         bdconexion conexion=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        boolean tienepermiso=false;

        try {
            conexion=(bdconexion) bdconexion.getConnection();
          
            String Condicion="SELECT * FROM vendedores where user='"+datos.getUsername()+"'"
                    + " and password='"+datos.getPassword()+"';";
            statement=conexion.prepareStatement(Condicion);
            rs=statement.executeQuery();
            
            while (rs.next()) {
                    tienepermiso=true;
            }      
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
           bdconexion.closeCon(conexion);
           bdconexion.closeresult(rs);
           bdconexion.closeStm(statement);
        }
        
        return tienepermiso;
    }  
    
}
