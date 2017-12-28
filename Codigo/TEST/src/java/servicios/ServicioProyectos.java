/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import db.Acciones;
import db.Asociacion;
import db.Proyecto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nepen
 */
@WebService(serviceName = "ServicioProyectos")
public class ServicioProyectos {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "BuscarProyectos")
    public ArrayList<Proyecto> BuscarProyectos(@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        
        return a.buscarProyecto(idUser);
    }
    
    @WebMethod(operationName = "AgregarProyecto")
    public boolean AgrearProyecto(@WebParam(name = "proyecto") String proyecto,@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        return a.agregarProyecto(proyecto, idUser);
    }
}
