/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import db.Acciones;
import db.Habilidad;
import db.Post;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nepen
 */
@WebService(serviceName = "ServicioPosts")
public class ServicioPosts {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "BuscarPost")
    public ArrayList<Post> BuscarPost(@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        
        return a.buscarPosts(idUser);
    }
    
    @WebMethod(operationName = "AgrearPost")
    public boolean AgrearPost(@WebParam(name = "post") String post,@WebParam(name = "idCreador") int idCreador) throws SQLException {
        Acciones a = new Acciones();
        return a.agregarPost(post, idCreador);
    }
    
    @WebMethod(operationName = "ConseguirTimeline")
    public ArrayList<Post> ConseguirTimeline(@WebParam(name = "idUser") int idUser) throws SQLException {
        Acciones a = new Acciones();
        
        return a.timeline(idUser);
    }
}
