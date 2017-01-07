/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.abstractController.OrderMenuAbstractController;
import com.warehouse.entity.Order;
import com.warehouse.informations.OrderInformations;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author pawel_000
 */
public class OrderStatusController extends OrderMenuAbstractController{
    @FXML
    public TableView<Order> tableView;
    @FXML
    public TableColumn<OrderInformations, String> orderID;
    @FXML
    public TableColumn<OrderInformations, String> itemName;
    @FXML
    public TableColumn<OrderInformations, String> itemCode;
    @FXML
    public TableColumn<OrderInformations, String> amount;
    @FXML
    public TableColumn<OrderInformations, String> clientName;
    @FXML
    public TableColumn<OrderInformations, String> clientAddress;
    @FXML
    public TableColumn<OrderInformations, String> whenOrder;
    
    public void handlePackingOrderAction() throws IOException {
        
    }
    
    public void handlePickingOrderAction() throws IOException {
        
    }
}
