/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nepen
 */
public class Acciones{
    
    public ArrayList<User> login(String nick, String pass){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<User> list = new ArrayList<User>();

        String selectSQL = "SELECT * FROM USUARIO WHERE nickname = \""+nick +"\" AND passwd = \""+pass+"\"";
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                User us =  new User(rs.getInt("id_usuario"),rs.getString("nickname"),rs.getString("passwd"),rs.getString("email"));
                list.add(us);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
    
    public ArrayList<User> buscarUsuarios(){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<User> list = new ArrayList<User>();

        String selectSQL = "SELECT * FROM USUARIO";
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                User us =  new User(rs.getInt("id_usuario"),rs.getString("nickname"),rs.getString("passwd"),rs.getString("email"));
                list.add(us);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<Habilidad> buscarHabilidades(int idUser){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<Habilidad> list = new ArrayList<Habilidad>();

        String selectSQL = "SELECT * FROM HABILIDAD WHERE id_user = "+ idUser;
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                Habilidad ha =  new Habilidad(rs.getInt("id_habilidad"),rs.getString("habilidad"),rs.getInt("karma"));
                list.add(ha);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
    
    public boolean agregarHabilidad(String habilidad, int karma, int idUser) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO HABILIDAD (habilidad,karma,id_user) "
                + "VALUES(?,?,?)";
        try{
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, habilidad);
            preparedStatement.setInt(2, karma);
            preparedStatement.setInt(3, idUser);
            preparedStatement.executeUpdate();
            
            dbConnection.close();
            return true;
        }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public boolean agregarUsuario(String user, String pass, String mail) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO USUARIO (nickname,passwd,email) "
                + "VALUES(?,?,?)";
        try{
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, mail);
            preparedStatement.executeUpdate();
            
            dbConnection.close();
            return true;
        }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public boolean agregarPost(String post, int idUser) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO POST (post,likes,dislikes,id_creator) "
                + "VALUES(?,0,0,?)";
        try{
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, post);
            preparedStatement.setInt(2, idUser);
            preparedStatement.executeUpdate();
            
            dbConnection.close();
            return true;
        }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public ArrayList<Post> buscarPosts(int idUser){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<Post> list = new ArrayList<Post>();

        String selectSQL = "SELECT * FROM POST WHERE id_creator = "+ idUser;
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                Post po =  new Post(rs.getInt("id_post"),"Usuario Actual",rs.getString("post"),rs.getInt("likes"),rs.getInt("dislikes"));
                list.add(po);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
    
    public void buscarPorNick(String nick, int id1){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<User> list = new ArrayList<User>();

        String selectSQL = "SELECT * FROM USUARIO WHERE nickname = \""+nick +"\"";
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                User us =  new User(rs.getInt("id_usuario"),rs.getString("nickname"),rs.getString("passwd"),rs.getString("email"));
                list.add(us);
            }
            
            rs.close();
            agregarAmistad(id1, list.get(0).id);
            agregarAmistad(list.get(0).id, id1);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
    }
    
    public boolean agregarAmistad(int id1, int id2) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO AMISTAD (id_user1,id_user2) "
                + "VALUES(?,?)";
        try{
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, id1);
            preparedStatement.setInt(2, id2);
            preparedStatement.executeUpdate();
            
            dbConnection.close();
            return true;
        }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public ArrayList<User> buscarAmigos(int id){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<User> list = new ArrayList<User>();

        String selectSQL = "SELECT * FROM AMISTAD A, USUARIO U WHERE A.id_user1 = "+ id +" AND A.id_user2 = U.id_usuario";
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                User us =  new User(rs.getInt("id_usuario"),rs.getString("nickname"),rs.getString("passwd"),rs.getString("email"));
                list.add(us);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
    
    public ArrayList<Post> timeline(int idUser){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<Post> list = new ArrayList<Post>();

        String selectSQL = "SELECT * FROM POST P, Usuario U Where( P.id_creator = "+ idUser;
        
        for(int x=0;x<buscarAmigos(idUser).size();x++) {
            selectSQL = selectSQL + " OR id_creator = "+ buscarAmigos(idUser).get(x).id;
         }
        
        selectSQL = selectSQL + " )AND P.id_creator = U.id_usuario";
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                Post po =  new Post(rs.getInt("id_post"),rs.getString("nickname"),rs.getString("post"),rs.getInt("likes"),rs.getInt("dislikes"));
                list.add(po);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
    
    public boolean agregarAsociacion(String asociacion, int idUser) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO ASOCIACION (nombreAsociacion,id_admin) "
                + "VALUES(?,?)";
        try{
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, asociacion);
            preparedStatement.setInt(2, idUser);
            preparedStatement.executeUpdate();
            
            dbConnection.close();
            return true;
        }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public ArrayList<Asociacion> buscarAsociacion(int idUser){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<Asociacion> list = new ArrayList<Asociacion>();

        String selectSQL = "SELECT * FROM ASOCIACION WHERE id_admin = "+ idUser;
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                Asociacion ass =  new Asociacion(rs.getInt("id_asociacion"),rs.getString("nombreAsociacion"),"Usuario Actual");
                
                list.add(ass);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
    
    public boolean agregarProyecto(String proyecto, int idUser) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO PROYECTO (nombreProyecto,id_fundador) "
                + "VALUES(?,?)";
        try{
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, proyecto);
            preparedStatement.setInt(2, idUser);
            preparedStatement.executeUpdate();
            
            dbConnection.close();
            return true;
        }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public ArrayList<Proyecto> buscarProyecto(int idUser){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<Proyecto> list = new ArrayList<Proyecto>();

        String selectSQL = "SELECT * FROM PROYECTO WHERE id_fundador = "+ idUser;
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                Proyecto ass =  new Proyecto(rs.getInt("id_proyecto"),rs.getString("nombreProyecto"),"Usuario Actual");
                
                list.add(ass);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
    
    public boolean agregarTarea(String tarea, int idPro) throws SQLException {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO TAREA (nombreTarea,id_proyecto) "
                + "VALUES(?,?)";
        try{
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, tarea);
            preparedStatement.setInt(2, idPro);
            preparedStatement.executeUpdate();
            
            dbConnection.close();
            return true;
        }catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    
    public ArrayList<Tarea> buscarTarea(int idPro){
        Connection dbConnection = null;
        Statement preparedStatement = null;
        ArrayList<Tarea> list = new ArrayList<Tarea>();

        String selectSQL = "SELECT * FROM TAREA WHERE id_proyecto = "+ idPro;
        
        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.createStatement();
            ResultSet rs = preparedStatement.executeQuery(selectSQL);
            
            while (rs.next()){
                Tarea ass =  new Tarea(rs.getInt("id_tarea"),rs.getString("nombreTarea"));
                
                list.add(ass);
            }
            
            rs.close();
            return list;
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException se) {
                
                se.printStackTrace();
            }
        }
        return null;
    }
}
