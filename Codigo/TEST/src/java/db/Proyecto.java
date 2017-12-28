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
public class Proyecto {
    public int id;
    public String proyecto;
    public String fundador;
    
    public Proyecto(int id, String proyecto, String fundador){
        this.id = id;
        this.proyecto = proyecto;
        this.fundador = fundador;
    }
}
