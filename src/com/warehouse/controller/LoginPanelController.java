package com.warehouse.controller;

import com.warehouse.dao.UserDao;
import com.warehouse.impl.UserDaoImpl;
import com.warehouse.loader.LoadFXML;
import com.warehouse.utility.AlertBox;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPanelController {
    public TextField loginField;
    public TextField passwordField;
    
    private final AlertBox alertBox;
    private final UserDao userDao;
    private LoadFXML loadFXML;
    
    public LoginPanelController(){
        alertBox = new AlertBox();
        userDao = new UserDaoImpl();
    }
    
    public void handleButtonClick() throws IOException {
        if(userDao.find(loginField.getText(), passwordField.getText())){
            Stage stage = (Stage) loginField.getScene().getWindow();
            stage.close();
            
            loadFXML = new LoadFXML("checkOrderNumber");
        }else
            alertBox.display(getClass().getSimpleName(), "Wrong login or password");
    }
}
