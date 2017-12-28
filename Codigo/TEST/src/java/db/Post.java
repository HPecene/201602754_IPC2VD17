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
public class Post {
    public int id;
    public String creador;
    public String post;
    public int likes;
    public int dislikes;
    
    public Post(int id,String creador, String post, int likes, int dislikes){
        this.id = id;
        this.creador = creador;
        this.post = post;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
