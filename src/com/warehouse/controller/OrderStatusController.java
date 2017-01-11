/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.abstractController.OrderMenuAbstractController;
import com.warehouse.cookie.Cookie;
import com.warehouse.dao.ItemDao;
import com.warehouse.dao.OrderDao;
import com.warehouse.entity.Order;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.informations.OrderInformations;
import com.warehouse.utility.AlertBox;
import com.warehouse.utility.Validate;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author pawel_000
 */
public class OrderStatusController extends OrderMenuAbstractController implements Initializable{
    @FXML
    public TableView<OrderInformations> tableView;
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
    
    private AlertBox alertBox;
    private ItemDao itemDao;
    private OrderDao orderDao;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initInstances();
        initTableView();
    }
    
    private void initInstances() {
        alertBox = new AlertBox();
        itemDao = new ItemDao();
        orderDao = new OrderDao();
    }
    
    private void initTableView() {
        orderID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        clientAddress.setCellValueFactory(new PropertyValueFactory<>("clientAddress"));
        whenOrder.setCellValueFactory(new PropertyValueFactory<>("whenOrder"));

        tableView.setItems(getObservableList());
    }
    
    public ObservableList<OrderInformations> getObservableList() {
        ObservableList<OrderInformations> result = FXCollections.observableArrayList();

        try {
            Order order = orderDao.getOrderById(Integer.parseInt(Cookie.get("orderID")));
            List<PalleteInfo>palleteInfo = Validate.getPalleteInformations(order.getItems());
            
            if (order != null) {
                for (PalleteInfo p : palleteInfo) {
                    OrderInformations cm = new OrderInformations();
                    cm.setOrderID(order.getId());
                    cm.setClientName(order.getClient().getName());
                    cm.setClientAddress(order.getClient().getAddress());
                    cm.setItemName(itemDao.getItemById(p.getId()).getName());
                    cm.setItemCode(itemDao.getItemById(p.getId()).getCode());
                    cm.setAmount(p.getAmount());
                    cm.setWhenOrder(order.getDate().toString());

                    result.add(cm);
                }
            }
        return result;
        } catch (Exception e) {
            alertBox.display(getClass().getSimpleName(), "Cant get informations from DB");
            e.printStackTrace();
        }

        return result;
    }
    
    public void handlePackingOrderAction() throws IOException {
        
    }
    
    public void handlePickingOrderAction() throws IOException {
        
    }
}
