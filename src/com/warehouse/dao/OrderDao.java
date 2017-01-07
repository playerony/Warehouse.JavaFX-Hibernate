/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.Order;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
public class OrderDao {
    public boolean checkOrderById(final int id){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Order o where o.id=:orderId";
            Query query = session.createQuery(sql);
            query.setParameter("orderId", id);
            List<Order> list = query.list();

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
}
