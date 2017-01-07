/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.controller;

import com.warehouse.loader.LoadFXML;
import com.warehouse.utility.AlertBox;
import java.io.IOException;
import javafx.scene.control.TextField;

/**
 *
 * @author pawel_000
 */
public class CheckOrderNumberController {
    public TextField orderField;

    private LoadFXML loadFXML;
    private final AlertBox alertBox;

    public CheckOrderNumberController() {
        alertBox = new AlertBox();
    }

    public void handleButtonClick() throws IOException {
        
    }
}
