/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionmysql;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author alumno04
 */
public class ConexionMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**conexion conexion = new conexion();
        conexion.conectar();*/
        
        if (conexion.conectar()==null) {
            System.out.println("Conexion Fallida.");
        } else {
            System.out.println("Conexion Exitosa.");
            try {
                 Statement st = conexion.conectar().createStatement();//con esto creas el camino
                 ResultSet rs = st.executeQuery("select * from persona");//el que regresa co el resultado
                 while (rs.next()) {                    
                     System.out.println("ID: "+rs.getInt("idpersona")+" NOMBRE: "+rs.getString("nombre")+
                             " APELLIDO PATERNO: "+rs.getString("apellido_pat")+
                             " APELLIDO MATERNO: "+rs.getString("apellido_mat")+
                             " DNI: "+rs.getString("dni"));
                }
                 conexion.conectar().close();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                   conexion.conectar().close(); 
                } catch (Exception ex) {
                }
                
            }
           
        }
    }
    
}
