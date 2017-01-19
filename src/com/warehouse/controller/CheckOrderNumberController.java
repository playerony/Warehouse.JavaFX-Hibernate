/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.cookie.Cookie;
import com.warehouse.dao.OrderDao;
import com.warehouse.loader.LoadFXML;
import com.warehouse.utility.AlertBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author pawel_000
 */
public class CheckOrderNumberController implements Initializable{
    public TextField orderField;

    private LoadFXML loadFXML;
    private AlertBox alertBox;
    private OrderDao orderDao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        alertBox = new AlertBox();
        orderDao = new OrderDao();
    }

    public void handleButtonClick() throws IOException {
        if(orderDao.checkOrderById(Integer.parseInt(orderField.getText()))){
            Stage stage = (Stage) orderField.getScene().getWindow();
            stage.close();
            
            Cookie cookie = Cookie.getInstance();
            cookie.add("orderID", orderField.getText());
            loadFXML = new LoadFXML("checkOrder");
        }else
            alertBox.display(getClass().getSimpleName(), "Wrong value");
    }
}
