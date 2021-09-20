/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedDatos;

import Comisiones.ClsPersonal;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ramos
 */
public class bdVendedores {
    
    private static final String SQL_SELECT = "select * from tb_vendedores";
    private static final String SQL_UPDATE = "update tb_vendedores set nombre=?,enero=?, febrero=?, marzo=? ,total=?,promedio=? where id=?";
    private static final String SQL_INSERT = "insert into tb_vendedores (nombre,enero,febrero,marzo,total,promedio) values (?,?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from tb_vendedores where id=?";
    
    //paso 1 definir el String de conexion
        String url = "jdbc:mysql://localhost:3306/bdproyect?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
       
         
        
        public List<ClsPersonal> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsPersonal alumno = null;
        List<ClsPersonal> Comisiones= new  ArrayList<ClsPersonal>();
        try {
            conn = bdconexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int codig = rs.getInt("id");
                String nombre =rs.getString("nombre");
                double enero = rs.getDouble("enero");
                double febrero = rs.getDouble("febrero");
                double marzo = rs.getDouble("marzo");
                double total = rs.getDouble("total");
                double promedio = rs.getDouble("promedio");
                alumno = new ClsPersonal();
                alumno.setCodigo(codig);
                alumno.setNombre(nombre);
                alumno.setEnero(enero);
                alumno.setFebrero(febrero);
                alumno.setMarzo(marzo);
                alumno.setVentatotal(total);
                alumno.setPromedio(promedio);
                Comisiones.add(alumno);
   
                
            }
            
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally{
           bdconexion.closeCon(conn);
           bdconexion.closeStm(stmt);
           bdconexion.closeresult(rs);
        }

        return Comisiones;
        
    }
        
      public int insert(ClsPersonal vendedor){
        int rows=0;
        Connection conn=null;
        PreparedStatement stmt=null;
        try {
            conn=bdconexion.getConnection();
            stmt=conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getNombre());
            stmt.setDouble(2, vendedor.getEnero());
            stmt.setDouble(3, vendedor.getFebrero());
            stmt.setDouble(4, vendedor.getMarzo());
            stmt.setDouble(5, vendedor.getVentatotal());
            stmt.setDouble(6, vendedor.getPromedio());
            
           
            rows=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            bdconexion.closeCon(conn);
            bdconexion.closeStm(stmt);
        }
        return rows;
    }
      
      
      public int actualizar(ClsPersonal alumno){
          int x = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = bdconexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

             stmt.setString(1, alumno.getNombre());
            stmt.setDouble(2, alumno.getEnero());
            stmt.setDouble(3, alumno.getFebrero());
            stmt.setDouble(4, alumno.getMarzo());
            stmt.setDouble(5, alumno.getVentatotal());
            stmt.setDouble(6, alumno.getPromedio());
            stmt.setInt(7, alumno.getCodigo());
            
          
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            bdconexion.closeStm(stmt);
            bdconexion.closeCon(conn);
        }
        
        return rows;
    }
      
       
   
       
           public String Ventas(String Mes,String op){
        String Respuesta="";
        String Nombre="";
        Double Cantidad=0.0;
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try {
            conn=bdconexion.getConnection();
            stmt=conn.prepareStatement("select nombre,"+Mes +" from personal where "+ Mes+"=(select "+op+"("+Mes+") from personal);");
            rs=stmt.executeQuery();
            while(rs.next()){
                Nombre=rs.getString("Nombre");
                Cantidad=rs.getDouble(Mes);
                
                Respuesta+=("El que vendio más es: "+Nombre+""
                        + "\nY la cantidad acumulada es de: Q"+Cantidad+"\n");
            }    
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            bdconexion.closeCon(conn);
           bdconexion.closeStm(stmt);
           bdconexion.closeresult(rs);
        }
        
        return Respuesta;
    }
    
    public String VentaMayor(){
        String Respuesta="";
        String Nombre="";
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try {
            conn=bdconexion.getConnection();
            stmt=conn.prepareStatement("select nombre from personal where total=(select max(total) from personal);");
            rs=stmt.executeQuery();
            while(rs.next()){
                Nombre=rs.getString("nombre");
            }
            
            Respuesta=("Mayot venta es de"+Nombre);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
             bdconexion.closeCon(conn);
           bdconexion.closeStm(stmt);
           bdconexion.closeresult(rs);
        }
        return Respuesta;
    }
    
}
