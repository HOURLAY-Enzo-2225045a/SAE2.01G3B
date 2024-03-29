package com.sae201g3b;
/**
 * Main du projet
 *
 * @version 2.0
 *
 * @see com.sae201g3b.SisMapApplication
 * @author Enzo HOURLAY / Alexandre Crespin
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SisMapApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(SisMapApplication.class.getResource("SisMapView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("SisMapApplication");
        stage.setScene(scene);
        stage.show();
    }
}
