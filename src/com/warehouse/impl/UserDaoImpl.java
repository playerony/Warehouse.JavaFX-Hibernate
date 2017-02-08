/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.UserDao;
import com.warehouse.entity.User;
import com.warehouse.service.UserService;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public String find(String name, String password) {
        List<User> list = null;
        
        try{
            list = UserService.list(sessionFactory);
        }catch(Exception e){
            return "connection";
        }
        
        for(User u : list)
            if(u.getLogin().equals(name) && u.getPassword().equals(password))
                return "success";
        
        return "input";
    }
    
    @Override
    public String getUserNameById(int id){
        return UserService.list(sessionFactory).get(id).getLogin();
    }
}
