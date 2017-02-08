/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.PackingDao;
import com.warehouse.entity.PalletsPacked;
import com.warehouse.service.PackingService;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class PackingDaoImpl implements PackingDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PalletsPacked> getPackedPallets() {
        return PackingService.list(sessionFactory);
    }
    
}
