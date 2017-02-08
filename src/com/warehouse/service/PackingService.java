/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.PalletsPacked;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class PackingService {
    public static List<PalletsPacked> list(SessionFactory sessionFactory) throws Exception{
        Session session = sessionFactory.openSession();
        List<PalletsPacked> list = session.createQuery("from PalletsPacked").list();
        session.close();
        
        return list;
    }
}
