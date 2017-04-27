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
    private String containertypeName;
    
    public Containers(){}
    public Containers(int idContainer, int idContainertype, boolean free){
        this.idContainer = idContainer;
        this.idContainertype = idContainertype;
        this.free = free;
    }
    
    public int getIdContainer(){ return this.idContainer; }
    public int getIdContainertype(){ return this.idContainertype; }
    public boolean getFree(){ return this.free; }
    public String getContainertypeName(){ return this.containertypeName; }
    
    public void setIdContainer(int idContainer){ this.idContainer = idContainer; } 
    public void setIdContainertype(int idContainertype){ this.idContainertype = idContainertype; }
    public void setFree(boolean free){ this.free = free; }
    public void setContainertypeName(String containertypeName){ this.containertypeName = containertypeName; }
}
