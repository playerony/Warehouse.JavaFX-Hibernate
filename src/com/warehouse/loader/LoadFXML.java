/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.loader;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pawel_000
 */
public class LoadFXML {
    public LoadFXML(){
        
    }
    
    public LoadFXML(final String fxmlFileName) throws IOException {
        loadFile(fxmlFileName);
    }
    
    public URL getPath(final String fileName){
        return getClass().getResource("/com/warehouse/fxml/" + fileName + ".fxml");
    }

    private void loadFile(final String fxmlFileName) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getPath(fxmlFileName));

        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
