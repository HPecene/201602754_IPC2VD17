/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import db.Acciones;
import db.Asociacion;
import db.Tarea;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nepen
 */
@WebService(serviceName = "ServicioTareas")
public class ServicioTareas {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "BuscarTareas")
    public ArrayList<Tarea> BuscarTareas(@WebParam(name = "idPro") int idPro) throws SQLException {
        Acciones a = new Acciones();
        
        return a.buscarTarea(idPro);
    }
    
    @WebMethod(operationName = "AgregarTarea")
    public boolean AgregarTarea(@WebParam(name = "tarea") String tarea,@WebParam(name = "idPro") int idPro) throws SQLException {
        Acciones a = new Acciones();
        return a.agregarTarea(tarea, idPro);
    }
}
