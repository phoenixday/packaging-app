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
public class Listoftypes {
    private int idListoftypes;
    private int idType;
    
    public Listoftypes(){}
    public Listoftypes(int idListoftypes, int idType){
        this.idListoftypes = idListoftypes;
        this.idType = idType;
    }
    
    public int getIdListoftypes(){ return this.idListoftypes; }
    public int getIdType(){ return this.idType; }
    
    public void setIdListoftypes(int idListoftypes){ this.idListoftypes = idListoftypes; }
    public void setIdType(int idType){ this.idType = idType; }
}
