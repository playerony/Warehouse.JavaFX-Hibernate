/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.abstractController.OrderMenuAbstractController;
import com.warehouse.cookie.Cookie;
import com.warehouse.informations.PickingInformations;
import com.warehouse.loader.LoadFXML;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author pawel_000
 */
public class PickingMenuController extends OrderMenuAbstractController{
    @FXML
    public TableView<PickingInformations> tableView;
    @FXML
    public TableColumn<PickingInformations, String> id;
    @FXML
    public TableColumn<PickingInformations, String> workerLogin;
    @FXML
    public TableColumn<PickingInformations, String> itemCode;
    @FXML
    public TableColumn<PickingInformations, String> itemAmount;
    @FXML
    public TableColumn<PickingInformations, String> clientName;
    @FXML
    public TableColumn<PickingInformations, String> clientAddress;
    
    public void handleBackMenuItem() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.close();
        Cookie.clear();

        LoadFXML load = new LoadFXML("checkOrderNumber");
    }

    public void handleLogoutMenuItem() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.close();
        Cookie.clear();

        LoadFXML load = new LoadFXML("loginPanel");
    }
    
    public void handleShowOrderAction() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(loadFXML.getPath("checkOrder"))));
    }
    
    public void handleShowPackingAction() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(loadFXML.getPath("packingMenu"))));
    }
}
