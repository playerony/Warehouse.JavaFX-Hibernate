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
public class OrderInformations {
    private int orderID;
    private int amount;

    private String itemName;
    private String itemCode;
    private String clientName;
    private String clientAddress;
    private String whenOrder;

    public OrderInformations() {

    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(final int orderID) {
        this.orderID = orderID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(final String itemCode) {
        this.itemCode = itemCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(final String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(final String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getWhenOrder() {
        return whenOrder;
    }

    public void setWhenOrder(final String whenOrder) {
        this.whenOrder = whenOrder;
    }
}
