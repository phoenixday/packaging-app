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
    private int idContainer;
    private int idGood;
    private int count;
    private String name;
    
    public Listofgoods(){}
    public Listofgoods(int idListofgoods, int idContainer, int idGood, int count, String name){
        this.idListofgoods = idListofgoods;
        this.idContainer = idContainer;
        this.idGood = idGood;
        this.count = count;
        this.name = name;
    }
    
    public int getIdListofgoods(){ return this.idListofgoods; }
    public int getIdContainer(){ return this.idContainer; }
    public int getIdGood(){ return this.idGood; }
    public int getCount(){ return this.count; }
    public String getName(){ return this.name; }
    
    public void setIdListofgoods(int idListofgoods){ this.idListofgoods = idListofgoods; }
    public void setIdContainer(int idContainer){ this.idContainer = idContainer; }
    public void setIdGood(int idGood){ this.idGood = idGood; }
    public void setCount(int count){ this.count = count; }
    public void setName(String name){ this.name = name; }
}
