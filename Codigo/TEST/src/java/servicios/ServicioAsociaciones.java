/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import db.Acciones;
import db.Asociacion;
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
@WebService(serviceName = "ServicioAsociaciones")
public class ServicioAsociaciones {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "BuscarAsociaciones")
    public ArrayList<Asociacion> BuscarAsociaciones(@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        
        return a.buscarAsociacion(idUser);
    }
    
    @WebMethod(operationName = "AgregarAsociacion")
    public boolean AgrearAsociacion(@WebParam(name = "asociacion") String asociacion,@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        return a.agregarAsociacion(asociacion, idUser);
    }
}
