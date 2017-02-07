/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.abstractController.OrderMenuAbstractController;
import com.warehouse.abstractController.OrderMenuInterface;
import com.warehouse.dao.ItemDao;
import com.warehouse.dao.OrderDao;
import com.warehouse.entity.Order;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.impl.ItemDaoImpl;
import com.warehouse.impl.OrderDaoImpl;
import com.warehouse.informations.OrderInformations;
import com.warehouse.loader.LoadFXML;
import com.warehouse.utility.Validate;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author pawel_000
 */
public class OrderStatusController extends OrderMenuAbstractController implements Initializable, OrderMenuInterface{
    
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
    
    private ItemDao itemDao;
    private OrderDao orderDao;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initInstances();
        initTableView();
    }
    
    @Override
    public void initInstances() {
        itemDao = new ItemDaoImpl();
        orderDao = new OrderDaoImpl();
    }
    
    @Override
    public void initTableView() {
        orderID.setCellValueFactory(new PropertyValueFactory<>("id"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        clientAddress.setCellValueFactory(new PropertyValueFactory<>("clientAddress"));
        whenOrder.setCellValueFactory(new PropertyValueFactory<>("whenOrder"));

        tableView.setItems(getObservableList());
    }
    
    @Override
    public ObservableList<OrderInformations> getObservableList() {
        ObservableList<OrderInformations> result = FXCollections.observableArrayList();

        try {
            Order order = orderDao.getOrderById(Integer.parseInt(cookie.get("orderID")));
            List<PalleteInfo>palleteInfo = Validate.getPalleteInformations(order.getItems());
            
            if (order != null) {
                for (PalleteInfo p : palleteInfo) {
                    OrderInformations cm = new OrderInformations();
                    cm.setId(order.getId());
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
    
    @Override
    public void handleBackMenuItem() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.close();
        cookie.clear();

        LoadFXML load = new LoadFXML("checkOrderNumber");
    }

    @Override
    public void handleLogoutMenuItem() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.close();
        cookie.clear();

        LoadFXML load = new LoadFXML("loginPanel");
    }
    
    public void handlePackingOrderAction() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(loadFXML.getPath("packingMenu"))));
    }
    
    public void handlePickingOrderAction() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(loadFXML.getPath("pickingMenu"))));
    }
}
