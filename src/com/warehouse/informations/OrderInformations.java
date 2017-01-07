/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.informations;

import com.warehouse.dao.OrderDao;
import com.warehouse.entity.PalleteInfo;
import java.util.ArrayList;

/**
 *
 * @author pawel_000
 */
public class OrderInformations {
    private OrderDao orderDao;
    private ArrayList<PalleteInfo> palleteInfo;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public ArrayList<PalleteInfo> getPalleteInfo() {
        return palleteInfo;
    }

    public void setPalleteInfo(ArrayList<PalleteInfo> palleteInfo) {
        this.palleteInfo = palleteInfo;
    }
}
