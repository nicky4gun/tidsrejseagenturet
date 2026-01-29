package com.example.tidsrejseagenturet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TimeAgencyApplication extends Application {
   @Override
    public void start(Stage stage) throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader(TimeAgencyApplication.class.getResource("hello-view.fxml"));
       Scene scene  = new Scene(fxmlLoader.load(),800,600);
       stage.setScene(scene);
       stage.setTitle("TimeAgency");
       stage.show();
   }
}
// @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(TimeAgencyApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
