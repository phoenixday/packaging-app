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
public class Stores {
    private int idStore;
    private String address;
    private int size;
    private boolean universal;
    
    public Stores(){}
    public Stores(int idStore, String address, int size, boolean universal){
        this.idStore = idStore;
        this.address = address;
        this.size = size;
        this.universal = universal;
    }
    
    public int getIdStore(){ return this.idStore; }
    public String getAddress(){ return this.address; }
    public int getSize(){ return this.size; }
    public boolean getUniversal(){ return this.universal; }
    
    public void setIdStore(int idStore){ this.idStore = idStore; }
    public void setAddress(String address){ this.address = address; }
    public void setSize(int size){ this.size = size; }
    public void setUniversal(boolean universal){ this.universal = universal; }
}
