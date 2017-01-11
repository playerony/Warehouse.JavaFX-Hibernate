/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.abstractController;

import com.warehouse.loader.LoadFXML;
import com.warehouse.utility.AlertBox;
import java.io.IOException;

/**
 *
 * @author pawel_000
 */
public class OrderMenuAbstractController{
    protected AlertBox alertBox = new AlertBox();
    protected LoadFXML loadFXML = new LoadFXML();
    
    public void handleGenerateTXT() {
        
    }

    public void handleGeneratePDF() {
        
    }

    public void handleInformationAction() {
        alertBox.display("About", "It's a simple version of the ERP system written by the playerony(Paweł Wojtasiński)");
    }

    public void handleBackMenuItem() throws IOException {
        
    }

    public void handleLogoutMenuItem() throws IOException {
        
    }
}
