/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *8
 * @author lalo_
 */
public class SociosDAO implements ISociosDAO{
    public iConexionBD conexion= new ConexionBD();

    public SociosDAO() {
    }

    public SociosDAO(iConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean agregar(Socio socio){
        try{ 
        String query="INSERT INTO `clubnautico`.`socio` (`idSocio`, `Nombre`, `Direccion`, `Telefono`) VALUES ('"+socio.idSocio+"', '"+socio.Nombre+"', '"+socio.Direccion+"', '"+socio.Telefono+"')";
        Connection con=conexion.crearConexion();
        Statement comando = con.createStatement();
        comando.executeUpdate(query);
        con.close();
        return true;
        }
        catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    
    @Override
    public boolean actualizar(Socio socio){
         try{
        String query="CALL Actualiza_Socio("+socio.idSocio+",'"+socio.Nombre+"','"+socio.Direccion+"','"+socio.Telefono+"')";
        Connection con=conexion.crearConexion();
        Statement comando = con.createStatement();
        comando.executeUpdate(query);
        con.close();
        return true;
        }
        catch(Exception ex){
            System.out.println(ex);
            return false;
        }

    }
  
    @Override
    public List<Socio> consultarTodos(){

        try{
        List<Socio> list= new ArrayList();
        String query="SELECT * FROM clubnautico.socio";
        Connection con=conexion.crearConexion();
        Statement comando = con.createStatement();
        ResultSet datos = comando.executeQuery(query);
        while(datos.next()){
            Socio socio =new Socio();
            socio.idSocio=datos.getInt("idSocio");
            socio.Nombre=datos.getString("Nombre");
            socio.Direccion=datos.getString("Direccion");
            socio.Telefono=datos.getString("Telefono");
            list.add(socio);
            
        }
        con.close();
        
        return list;
        }
        catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
     
}
