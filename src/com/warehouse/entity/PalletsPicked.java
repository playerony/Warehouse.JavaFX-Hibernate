/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.entity;

/**
 *
 * @author pawel_000
 */
public class PalletsPicked {
    private int id;
    private User user;
    private Client client;
    private String products;
    
    public PalletsPicked(){
        
    }
    
    public PalletsPicked(int id, User user, Client client, String products){
        this.id = id;
        this.user = user;
        this.client = client;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
