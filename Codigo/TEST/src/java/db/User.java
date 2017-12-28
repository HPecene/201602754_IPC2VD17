/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
public class User {
    public int id;
    public String nickname;
    public String pass;
    public String email;
    
    public User(int id, String nickname,String pass, String email){
        this.id = id;
        this.nickname = nickname;
        this.pass = pass;
        this.email = email;
    }
}
