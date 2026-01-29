package com.example.tidsrejseagenturet;

import com.example.tidsrejseagenturet.config.DatabaseConfig;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    private final DatabaseConfig config = new DatabaseConfig();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
