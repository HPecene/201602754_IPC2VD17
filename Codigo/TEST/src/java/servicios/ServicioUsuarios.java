/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import db.Acciones;
import db.User;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author nepen
 */
@WebService(serviceName = "ServicioUsuarios")
public class ServicioUsuarios {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Login")
    public int Login(@WebParam(name = "nickname") String nickname,@WebParam(name = "pass") String pass) throws SQLException {
        Acciones a = new Acciones();
        if (a.login(nickname, pass).isEmpty()){
            return 0;
        } else {
            return a.login(nickname, pass).get(0).id;
        }
    }
    
    @WebMethod(operationName = "BuscarUsers")
    public ArrayList<User> BuscarUsers() throws SQLException {
        Acciones a = new Acciones();
        
        return a.buscarUsuarios();
    }
    
    @WebMethod(operationName = "Amigo")
    public void Amigo(@WebParam(name = "nickname") String nickname,@WebParam(name = "id") int id) throws SQLException {
        Acciones a = new Acciones();
        a.buscarPorNick(nickname, id);
        
    }
    
    @WebMethod(operationName = "BuscarAmigo")
    public ArrayList<User> BuscarAmigo(@WebParam(name = "id") int id) throws SQLException {
        Acciones a = new Acciones();
        
        return a.buscarAmigos(id);
    }
    
    @WebMethod(operationName = "CrearUsuario")
    public boolean CrearUsuario(@WebParam(name = "user") String user,@WebParam(name = "pass") String pass
            ,@WebParam(name = "mail") String mail) throws SQLException {
        Acciones a = new Acciones();
        
        return a.agregarUsuario(user,pass,mail);
    }
}
