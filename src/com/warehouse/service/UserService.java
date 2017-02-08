/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class UserService {
    public static List<User> list(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery("from User").list();
        session.close();
        
        return list;
    }
}
