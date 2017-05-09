/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Date;

/**
 *
 * @author Aline
 */
public class Goods {
    private int idGood;
    private String name;
    private int type;
    private int count;
    private int idStore;
    private double mass;
    private int width;
    private int length;
    private int height;
    private int idContainerType;
    private Date expirationDate;
    private String addFeatures;
    private String typeName;
    private String containertypeName;
    
    public Goods(){}
    public Goods(int idGood, String name, int type, int count, int idStore, 
            double mass, int width, int length, int height, 
            int idContainerType, Date expirationDate, String addFeatures){
        this.idGood = idGood;
        this.name = name;
        this.type = type;
        this.count = count;
        this.idStore = idStore;
        this.mass = mass;
        this.width = width;
        this.length = length;
        this.height = height;
        this.idContainerType = idContainerType;
        this.expirationDate = expirationDate;
        this.addFeatures = addFeatures;
    }
    
    public int getIdGood(){ return this.idGood; }
    public String getName(){ return this.name; }
    public int getType(){ return this.type; }
    public int getCount(){ return this.count; }
    public int getIdStore(){ return this.idStore; }
    public double getMass(){ return this.mass; }
    public int getWidth(){ return this.width; }
    public int getLength(){ return this.length; }
    public int getHeight(){ return this.height; }
    public int getIdContainerType(){ return this.idContainerType; }
    public Date getExpirationDate(){ return this.expirationDate; }
    public String getAddFeatures(){ return this.addFeatures; }
    public String getTypeName(){ return this.typeName; }
    public String getContainertypeName(){ return this.containertypeName; }
    
    public void setIdGood(int idGood){ this.idGood = idGood; }
    public void setName(String name){ this.name = name; }
    public void setType(int type){ this.type = type; }
    public void setCount(int count){ this.count = count; }
    public void setIdStore(int idStore){ this.idStore = idStore; }
    public void setMass(double mass){ this.mass = mass; }
    public void setWidth(int width){ this.width = width; }
    public void setLength(int length){ this.length = length; }
    public void setHeight(int height){ this.height = height; }
    public void setIdContainerType(int idContainerType){ this.idContainerType = idContainerType; }
    public void setExpirationDate(Date expirationDate){ this.expirationDate = expirationDate; }
    public void setAddFeatures(String addFeatures){ this.addFeatures = addFeatures; }
    public void setTypeName(String typeName){ this.typeName = typeName; }
    public void setContainertypeName(String containertypeName){ this.containertypeName = containertypeName; }
}
