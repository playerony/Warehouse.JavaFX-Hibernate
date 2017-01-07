package com.warehouse.controller;

import com.warehouse.dao.UserDao;
import com.warehouse.loader.LoadFXML;
import com.warehouse.utility.AlertBox;
import java.io.IOException;
import javafx.scene.control.TextField;

public class LoginPanelController {
    public TextField login;
    public TextField password;
    
    private final AlertBox alertBox;
    private final UserDao userDao;
    private LoadFXML loadFXML;
    
    public LoginPanelController(){
        alertBox = new AlertBox();
        userDao = new UserDao();
    }
    
    public void handleButtonClick() throws IOException {
        if(userDao.find(login.getText(), password.getText()))
            loadFXML = new LoadFXML("checkOrderNumber");
        else
            alertBox.display("LoginController", "Wrong login or password");
    }
}
