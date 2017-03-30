/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
public class Data {
    private Session session;
    
    public List loadGoodsList(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Goods> list = session.createCriteria(Goods.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    public List loadTypesList(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Types> list = session.createCriteria(Types.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
