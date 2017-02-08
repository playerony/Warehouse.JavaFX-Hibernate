/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.Order;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class OrderService {
    public static List<Order> list(SessionFactory sessionFactory) throws Exception {
        Session session = sessionFactory.openSession();
        List<Order> list = session.createQuery("from Order").list();
        session.close();
        
        return list;
    }
}
