/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import db.Acciones;
import db.Habilidad;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nepen
 */
@WebService(serviceName = "ServicioHabilidades")
public class ServicioHabilidades {

    /**
     * This is a sample web service operation
     * @param idUser
     * @return 
     * @throws java.sql.SQLException 
     */
    @WebMethod(operationName = "BuscarHabilidades")
    public ArrayList<Habilidad> BuscarHabilidades(@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        
        return a.buscarHabilidades(idUser);
    }
    
    @WebMethod(operationName = "AgrearHabilidad")
    public boolean AgrearHabilidad(@WebParam(name = "habilidad") String habilidad,@WebParam(name = "karma") int karma,@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        return a.agregarHabilidad(habilidad, karma, idUser);
    }
}
