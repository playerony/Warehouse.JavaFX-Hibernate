/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.PalletsPacked;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
public class PackingDao {
    public List<PalletsPacked> getPackedPallets(){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from PalletsPacked p where 1";
            Query query = session.createQuery(sql);

            return query.list();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
