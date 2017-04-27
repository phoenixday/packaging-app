/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Aline
 */
@ManagedBean
@SessionScoped
public class Data implements AutoCloseable{
    private final Session session;
    
    public Data(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List loadGoodsList(){
        return session.createCriteria(Goods.class).list();
    }
    
    public List loadContainersList(){
        return session.createCriteria(Containers.class).list();
    }
    
    public List loadStoresList(){
        return session.createCriteria(Stores.class).list();
    } 
      
    public List loadListofgoods(int number){
        session.beginTransaction();
        Query query = session.createQuery("from Listofgoods where idContainer = :number");
        query.setParameter("number", number);
        List l = query.list();
        Iterator<Listofgoods> it = l.iterator();
	while (it.hasNext()) { 
            Listofgoods tmp = it.next();
            query = session.createQuery("select g.name from Goods g where g.idGood = :idGood");
            query.setParameter("idGood", tmp.getIdGood());
            if (!query.list().isEmpty()) tmp.setName(query.list().get(0).toString());
        }
        session.getTransaction().commit();
        return l;
    }
    
    public List loadTypesList(){
        session.beginTransaction();
        Query query = session.createQuery("SELECT t.type FROM Types t");
        session.getTransaction().commit();
        return query.list();
    }
    
    public List loadContainertypesList(){
        session.beginTransaction();
        Query query = session.createQuery("SELECT c.containertype FROM Containertype c");
        session.getTransaction().commit();
        return query.list();
    }
    
    public void addGood(Goods g){ 
        session.beginTransaction();
        session.save(g); 
        session.getTransaction().commit();
    }
    
    public int addContainer(Containers c){ 
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        return c.getIdContainer();
    }
    
    public void addStore(Stores s){
        session.beginTransaction(); 
        session.save(s); 
        session.getTransaction().commit();
    }
    
    public void deleteGood(int id){
        session.beginTransaction();
        session.delete(session.get(Goods.class, id));
        session.getTransaction().commit();
    }
    
    public void deleteContainer(int id){
        session.beginTransaction();
        session.delete(session.get(Containers.class, id));
        session.getTransaction().commit();
    }
    
    public void deleteStore(int id){
        session.beginTransaction();
        session.delete(session.get(Stores.class, id));
        session.getTransaction().commit();
    }
    
    public void updateGood(Goods g){
        session.beginTransaction();
        session.update(g);
        session.getTransaction().commit();
    }
    
    public void updateStore(Stores s){
        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
    }
    
    @Override
    public void close(){
        session.close();
    }
}