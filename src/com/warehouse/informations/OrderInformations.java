/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.informations;

import com.warehouse.entity.Order;
import com.warehouse.entity.PalleteInfo;
import java.util.ArrayList;

/**
 *
 * @author pawel_000
 */
public class OrderInformations {
    private Order order;
    private ArrayList<PalleteInfo> palleteInfo;

    public Order getOrder() {
        return order;
    }

    public void setOrderDao(Order order) {
        this.order = order;
    }

    public ArrayList<PalleteInfo> getPalleteInfo() {
        return palleteInfo;
    }

    public void setPalleteInfo(ArrayList<PalleteInfo> palleteInfo) {
        this.palleteInfo = palleteInfo;
    }
}
