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
public class Types {
    private int idType;
    private String type;
    
    public Types(){}
    public Types(int idType, String type){
        this.idType = idType;
        this.type = type;
    }
    
    public int getIdType(){ return this.idType; }
    public String getType(){ return this.type; }
    
    public void setIdType(int idType){ this.idType = idType; }
    public void setType(String type){ this.type = type; }
}
