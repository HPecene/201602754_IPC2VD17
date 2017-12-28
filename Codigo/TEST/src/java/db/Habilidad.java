/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author nepen
 */
public class Habilidad {
    public int id;
    public String habilidad;
    public int karma;
    
    public Habilidad(int id, String habilidad, int karma){
        this.id = id;
        this.habilidad = habilidad;
        this.karma = karma;
    }
}
