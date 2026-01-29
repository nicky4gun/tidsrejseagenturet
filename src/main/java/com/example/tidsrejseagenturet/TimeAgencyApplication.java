package com.example.tidsrejseagenturet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimeAgencyApplication extends Application {
   @Override
    public void start(Stage stage) throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader(TimeAgencyApplication.class.getResource("hello-view.fxml"));
       Scene scene  = new Scene(fxmlLoader.load(),700,400);
       stage.setScene(scene);
       stage.setTitle("TimeAgency Application");
       stage.show();
   }
}
