/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author user
 */
public class Listofgoods {
    private int idListofgoods;
    private int idGood;
    private int count;
    
    public Listofgoods(){}
    public Listofgoods(int idListofgoods, int idGood, int count){
        this.idListofgoods = idListofgoods;
        this.idGood = idGood;
        this.count = count;
    }
    
    public int getIdListofgoods(){ return this.idListofgoods; }
    public int getIdGood(){ return this.idGood; }
    public int getCount(){ return this.count; }
    
    public void setIdListofgoods(int idListofgoods){ this.idListofgoods = idListofgoods; }
    public void setIdGood(int idGood){ this.idGood = idGood; }
    public void setCount(int count){ this.count = count; }
}
