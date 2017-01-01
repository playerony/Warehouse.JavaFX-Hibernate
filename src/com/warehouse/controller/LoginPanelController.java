package com.warehouse.controller;

import com.warehouse.utility.AlertBox;
import java.io.IOException;
import javafx.scene.control.TextField;

public class LoginPanelController {
    public TextField login;
    public TextField password;
    
    private AlertBox alertBox;
    
    public LoginPanelController(){
        alertBox = new AlertBox();
    }
    
    public void handleButtonClick() throws IOException {
        alertBox.display("LoginController", "work");
    }
}
