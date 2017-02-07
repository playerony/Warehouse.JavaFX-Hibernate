/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.abstractController.OrderMenuAbstractController;
import com.warehouse.abstractController.OrderMenuInterface;
import com.warehouse.dao.ItemDao;
import com.warehouse.dao.PickingDao;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.impl.ItemDaoImpl;
import com.warehouse.informations.PickingInformations;
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
public class PickingMenuController extends OrderMenuAbstractController implements Initializable, OrderMenuInterface{
    
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
    
    private ItemDao itemDao;
    private PickingDao pickingDao;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initInstances();
        initTableView();
    }
    
    @Override
    public void initInstances() {
        itemDao = new ItemDaoImpl();
        pickingDao = new PickingDao();
    }
    
    @Override
    public void initTableView() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        workerLogin.setCellValueFactory(new PropertyValueFactory<>("workerLogin"));
        itemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        itemAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        clientAddress.setCellValueFactory(new PropertyValueFactory<>("clientAddress"));

        tableView.setItems(getObservableList());
    }
    
    @Override
    public ObservableList<PickingInformations> getObservableList() {
        ObservableList<PickingInformations> result = FXCollections.observableArrayList();

        try {
            List<PalletsPicked>palletsPicked = pickingDao.getPackedPallets();
            
            for (PalletsPicked p : palletsPicked) {
                List<PalleteInfo>palleteInfo = Validate.getPalleteInformations(p.getProducts());
                
                for (PalleteInfo pa : palleteInfo) {
                    PickingInformations cm = new PickingInformations();
                    cm.setId(p.getId());
                    cm.setClientName(p.getClient().getName());
                    cm.setClientAddress(p.getClient().getAddress());
                    cm.setItemCode(itemDao.getItemById(p.getId()).getCode());
                    cm.setAmount(pa.getAmount());
                    cm.setWorkerLogin(p.getUser().getLogin());
                    
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
    
    public void handleShowOrderAction() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(loadFXML.getPath("checkOrder"))));
    }
    
    public void handleShowPackingAction() throws IOException {
        Stage stage = (Stage) tableView.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(loadFXML.getPath("packingMenu"))));
    }
}
