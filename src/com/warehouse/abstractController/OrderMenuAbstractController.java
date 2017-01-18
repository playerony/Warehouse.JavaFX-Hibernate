/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.abstractController;

import com.warehouse.cookie.Cookie;
import com.warehouse.dao.OrderDao;
import com.warehouse.entity.Order;
import com.warehouse.loader.LoadFXML;
import com.warehouse.utility.AlertBox;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.stage.Stage;

/**
 *
 * @author pawel_000
 */
public class OrderMenuAbstractController{
    protected AlertBox alertBox = new AlertBox();
    protected OrderDao orderDao = new OrderDao();
    protected LoadFXML loadFXML = new LoadFXML();
    
    public void handleGenerateTXT() throws FileNotFoundException {
        Order order = orderDao.getOrderById(Integer.parseInt(Cookie.get("orderID")));
        
        int clientID = order.getClient().getId();
        String clientName = order.getClient().getName();
        String clientAddress = order.getClient().getAddress();

        if (clientName != null && clientAddress != null) {
            PrintWriter saveFile = new PrintWriter("./generated.txt");

            saveFile.println(clientName);
            saveFile.println(clientAddress);

            saveFile.close();

            alertBox.display(getClass().getSimpleName().toString(), "Successful generated *.TXT file !");
        } else
            alertBox.display(getClass().getSimpleName().toString(), "Cant verify client informations !");
    }

    public void handleGeneratePDF() {
        
    }

    public void handleInformationAction() {
        alertBox.display("About", "It's a simple version of the ERP system written by the playerony(Paweł Wojtasiński)");
    }
}
