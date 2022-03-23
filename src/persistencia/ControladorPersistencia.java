/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import datos.Socio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lalo_
 */
public class ControladorPersistencia {
    SocioJpaController socioJpa=new SocioJpaController();
    public boolean crearSocio(Socio socio){
        try {
            socioJpa.create(socio);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public List<Socio> consultaTodos(){
          return socioJpa.findSocioEntities();
    }
}