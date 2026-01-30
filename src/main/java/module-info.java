module com.example.tidsrejseagenturet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.tidsrejseagenturet to javafx.fxml;
    exports com.example.tidsrejseagenturet;
    exports com.example.tidsrejseagenturet.controllers;
    opens com.example.tidsrejseagenturet.controllers to javafx.fxml;
    exports com.example.tidsrejseagenturet.models;
    opens com.example.tidsrejseagenturet.models to javafx.fxml;
    exports com.example.tidsrejseagenturet.Service;
    opens com.example.tidsrejseagenturet.Service to javafx.fxml;
}