package com.example.tidsrejseagenturet;

import com.example.tidsrejseagenturet.config.DatabaseConfig;
import com.example.tidsrejseagenturet.controllers.*;
import com.example.tidsrejseagenturet.repositories.*;
import com.example.tidsrejseagenturet.service.BookingService;
import com.example.tidsrejseagenturet.service.CustomerService;
import com.example.tidsrejseagenturet.service.TimeMachineService;
import com.example.tidsrejseagenturet.service.TimePeriodService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimeAgencyApplication extends Application {
   @Override
    public void start(Stage stage) throws Exception{
      DatabaseConfig config = new DatabaseConfig();
      CustomerRepository customerRepo = new CustomerRepository(config);
      TimeMachineRepository timeMachineRepo = new TimeMachineRepository(config);
      TimePeriodRepository timePeriodRepo = new TimePeriodRepository(config);
      BookingRepository bookingRepo = new BookingRepository(config);
      GuideRepository guideRepo = new GuideRepository(config);

      CustomerService customerService = new CustomerService(customerRepo);
      TimeMachineService timeMachineService = new TimeMachineService(timeMachineRepo);
      TimePeriodService timePeriodService = new TimePeriodService(timePeriodRepo);
      BookingService bookingService = new BookingService(customerRepo, timeMachineRepo, timePeriodRepo, guideRepo, bookingRepo);

      FXMLLoader fxmlLoader = new FXMLLoader(TimeAgencyApplication.class.getResource("hello-view.fxml"));
      Scene scene  = new Scene(fxmlLoader.load(),700,400);

      // Service-injection
      TimeAgencyController controller = fxmlLoader.getController();
      controller.setCustomerService(customerService);
      controller.setTimeMachineService(timeMachineService);
      controller.setTimePeriodService(timePeriodService);
      controller.setBookingService(bookingService);

      stage.setScene(scene);
      stage.setTitle("TimeAgency Application");
      stage.show();
   }
}
