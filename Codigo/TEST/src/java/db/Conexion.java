/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nepen
 */
public class Conexion {
    
    
    private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
    
    private static final String cHOST = "localhost";
    private static final String cPORT = "3306";
    private static final String cDATABASE = "PROYECTO";
    
    private static final String cUSER = "root";
    private static final String cPASSWORD = "1234";
    
    private static final String DB_CONNECTION = "jdbc:mariadb://"+cHOST+":"+cPORT+"/"+cDATABASE;
    
    public Connection getDBConnection(){
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, cUSER, cPASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}

