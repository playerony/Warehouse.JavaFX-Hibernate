/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.Item;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class ItemService {
    public static List<Item> list(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Item> personList = session.createQuery("from Item").list();
        session.close();
        
        return personList;
    }
}
