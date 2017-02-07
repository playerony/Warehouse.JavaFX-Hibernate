/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.warehouse.entity.Item;

/**
 *
 * @author pawel_000
 */
public interface ItemDao {
    public Item getItemById(int id);
}
