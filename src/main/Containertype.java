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
public class Containertype {
    private int idContainertype;
    private String containertype;
    private int length;
    private int width;
    private int height;
    private double maxloading;
    private double carCapacity;
    
    public Containertype(){}
    public Containertype(int idContainertype, String containertype, 
            int length, int width, int height, 
            double maxloading, double carCapacity){
        this.idContainertype = idContainertype;
        this.containertype = containertype;
        this.length = length;
        this.width = width;
        this.height = height;
        this.maxloading = maxloading;
        this.carCapacity = carCapacity;
    }
    
    public int getIdContainertype(){ return this.idContainertype; }
    public String getContainertype(){ return this.containertype; }
    public int getLength(){ return this.length; }
    public int getWidth(){ return this.width; }
    public int getHeight(){ return this.height; }
    public double getMaxloading(){ return this.maxloading; }
    public double getCarCapacity(){ return this.carCapacity; }
    
    public void setIdContainertype(int idContainertype){ this.idContainertype = idContainertype; }
    public void setContainertype(String containertype){ this.containertype = containertype; }
    public void setLength(int length){ this.length = length; }
    public void setWidth(int width){ this.width = width; }
    public void setHeight(int height){ this.height = height; }
    public void setMaxloading(double maxloading){ this.maxloading = maxloading; }
    public void setCarCapacity(double carCapacity){ this.carCapacity = carCapacity; }
}
