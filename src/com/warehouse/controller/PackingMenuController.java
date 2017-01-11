/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.abstractController.OrderMenuAbstractController;
import com.warehouse.cookie.Cookie;
import com.warehouse.informations.PackingInformations;
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
public class PackingMenuController extends OrderMenuAbstractController {
    @FXML
    public TableView<PackingInformations> tableView;
    @FXML
    public TableColumn<PackingInformations, String> id;
    @FXML
    public TableColumn<PackingInformations, String> workerLogin;
    @FXML
    public TableColumn<PackingInformations, String> itemCode;
    @FXML
    public TableColumn<PackingInformations, String> itemAmount;
    @FXML
    public TableColumn<PackingInformations, String> clientName;
    @FXML
    public TableColumn<PackingInformations, String> clientAddress;
    
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
    
    public void handleShowPickingAction() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(loadFXML.getPath("pickingMenu"))));
    }
}
