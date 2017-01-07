/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.hibernate.warehouse;

import com.warehouse.loader.LoadFXML;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author pawel_000
 */
public class JavaFXHibernateWarehouse extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        LoadFXML loadFXML = new LoadFXML("loginPanel");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
