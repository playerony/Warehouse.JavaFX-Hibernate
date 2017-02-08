/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.PickingDao;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.service.PickingService;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class PickingDaoImpl implements PickingDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PalletsPicked> getPickedPallets() {
        return PickingService.list(sessionFactory);
    }
    
}
