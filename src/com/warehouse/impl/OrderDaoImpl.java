/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.OrderDao;
import com.warehouse.entity.Order;
import com.warehouse.service.OrderService;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class OrderDaoImpl implements OrderDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public boolean checkOrderById(final int id){
        if(OrderService.list(sessionFactory).get(id) != null)
            return true;
        return false;
    }
    
    @Override
    public Order getOrderById(int id){
        return OrderService.list(sessionFactory).get(id);
    }
    
    @Override
    public int getClientID(int id){
        return OrderService.list(sessionFactory).get(id).getClient().getId();
    }
}
