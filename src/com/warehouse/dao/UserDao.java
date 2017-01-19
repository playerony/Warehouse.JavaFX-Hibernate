/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.User;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
public class UserDao {
    public boolean find(final String name, final String password) {
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " from User u where u.login=:name and u.password=:pass";
            Query query = session.createQuery(sql);
            query.setParameter("name", name);
            query.setParameter("pass", password);
            List<User> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return true;
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public String getUserNameById(final int id){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from User u where u.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);

            return query.list().get(0).toString();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
