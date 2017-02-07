/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.Order;

/**
 *
 * @author pawel_000
 */
public interface OrderDao {
    public boolean checkOrderById(int id);
  
    public Order getOrderById(int id);
    
    public int getClientID(int id);
}
