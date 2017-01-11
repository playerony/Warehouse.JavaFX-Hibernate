/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.Item;
import com.warehouse.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
public class ItemDao {
    public Item getItemById(final int id){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from Item i where i.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);

            return (Item) query.list().get(0);
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
