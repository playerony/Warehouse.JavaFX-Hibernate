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
public class OrderInformations extends AbstractInformation{
    private String itemName;
    private String itemCode;
    private String whenOrder;

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

    public String getWhenOrder() {
        return whenOrder;
    }

    public void setWhenOrder(final String whenOrder) {
        this.whenOrder = whenOrder;
    }
}
