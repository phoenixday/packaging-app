/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Aline
 */
public class Containers {
    private int idContainer;
    private int idContainertype;
    private boolean free;
    private Integer idListofgoods;
    
    public Containers(){}
    public Containers(int idContainer, int idContainertype, boolean free, Integer idListofgoods){
        this.idContainer = idContainer;
        this.idContainertype = idContainertype;
        this.free = free;
        this.idListofgoods = idListofgoods;
    }
    
    public int getIdContainer(){ return this.idContainer; }
    public int getIdContainertype(){ return this.idContainertype; }
    public boolean getFree(){ return this.free; }
    public int getIdListofgoods(){ return this.idListofgoods; }
    
    public void setIdContainer(int idContainer){ this.idContainer = idContainer; } 
    public void setIdContainertype(int idContainertype){ this.idContainertype = idContainertype; }
    public void setFree(boolean free){ this.free = free; }
    public void setIdListofgoods(int idListofgoods){ this.idListofgoods = idListofgoods; }
}
