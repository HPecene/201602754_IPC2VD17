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
public class Asociacion {
    public int id;
    public String asociacion;
    public String admin;
    
    public Asociacion(int id, String asociacion, String admin){
        this.id = id;
        this.asociacion = asociacion;
        this.admin = admin;
    }
}
