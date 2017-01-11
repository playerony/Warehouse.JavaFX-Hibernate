/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.informations;

/**
 *
 * @author pawel_000
 */
public class PackingInformations {
    private int id;
    private int amount;

    private String workerLogin;
    private String itemCode;
    private String clientName;
    private String clientAddress;
    private String whenOrder;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getWorkerLogin() {
        return workerLogin;
    }

    public void setWorkerLogin(String workerLogin) {
        this.workerLogin = workerLogin;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getWhenOrder() {
        return whenOrder;
    }

    public void setWhenOrder(String whenOrder) {
        this.whenOrder = whenOrder;
    }
}
