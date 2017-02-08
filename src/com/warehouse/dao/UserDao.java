/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

/**
 *
 * @author pawel_000
 */
public interface UserDao {
    public boolean find(String name, String password);
    
    public String getUserNameById(int id);
}
