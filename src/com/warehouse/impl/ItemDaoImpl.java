/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.ItemDao;
import com.warehouse.entity.Item;
import com.warehouse.service.ItemService;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class ItemDaoImpl implements ItemDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public Item getItemById(final int id){
        return ItemService.list(sessionFactory).get(id);
    }
}
